package kr.zzimcong.ecommerce.item.repository;

import kr.zzimcong.ecommerce.item.domain.Item;
import kr.zzimcong.ecommerce.item.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom{

    private final JdbcTemplate jdbcTemplate;
    private final EntityManager em;

    @Override
    public List<ItemResponseDto> findAllDto(Long brandId, Long categoryId, String search, String sort) {

        String query = "SELECT new kr.zzimcong.ecommerce.item.dto.ItemResponseDto(i.id, i.name, b.name, i.price, i.discountRate, i.discountPrice)"
                + " FROM Item i"
                + " JOIN Category c ON i.category.id = c.id"
                + " JOIN Brand b ON i.brand.id = b.id";

        query = whereBuilder(query, brandId, categoryId, search);
        query = orderBuilder(query, sort);
        return em.createQuery(query, ItemResponseDto.class).getResultList();
    }

    private String orderBuilder(String query, String sort){
        query += " ORDER BY i.createdDate DESC";

        if(sort != null){
            Class<Item> itemClass = Item.class;
            for (Field field : itemClass.getDeclaredFields()) {
                field.setAccessible(true);
                if(field.getName().equals(sort))
                    query += ", i." + sort + " DESC";
            }
        }

        return query;
    }

    private String whereBuilder(String query, Long brandId, Long categoryId, String search){
        if(brandId != null)
            query += " WHERE b.id = " + brandId;

        if(categoryId != null) {
            if (query.contains("WHERE"))
                query += " AND";
            else
                query += " WHERE";
            query += " c.id = " + categoryId;
        }

        if(search != null){
            if(query.contains("WHERE"))
                query += " AND";
            else
                query += " WHERE";
            query += " i.name LIKE '%" + search + "%'";
        }
        return query;
    }
}
