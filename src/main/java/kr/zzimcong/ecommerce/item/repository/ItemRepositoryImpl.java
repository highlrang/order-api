package kr.zzimcong.ecommerce.item.repository;

import kr.zzimcong.ecommerce.item.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom{

    private final EntityManager em;

    @Override
    public List<ItemResponseDto> findAllDto() {
        return em.createQuery("SELECT new kr.zzimcong.ecommerce.item.dto.ItemResponseDto(i.id, i.name, b.name, i.price, i.discountRate, i.discountPrice)"
                        + " FROM Item i"
                        + " JOIN Brand b ON i.brand.id = b.id"
                        + " ORDER BY i.createdDate DESC"
                , ItemResponseDto.class
        ).getResultList();
    }
}
