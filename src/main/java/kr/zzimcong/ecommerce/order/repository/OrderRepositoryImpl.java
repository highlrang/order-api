package kr.zzimcong.ecommerce.order.repository;

import kr.zzimcong.ecommerce.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom{

    private final EntityManager em;

    @Override
    public List<OrderResponseDto> findAllDto(Long userId) {
        return em.createQuery("SELECT new kr.zzimcong.ecommerce.order.dto.OrderResponseDto(o.id, o.orderStatus, o.totalPrice, o.createdDate)"
                + " FROM Order o"
                + " JOIN Delivery d ON o.delivery.id = d.id"
                + " ORDER BY o.createdDate DESC", OrderResponseDto.class
        ).getResultList();
    }
}
