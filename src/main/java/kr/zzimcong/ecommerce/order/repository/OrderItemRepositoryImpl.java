package kr.zzimcong.ecommerce.order.repository;

import kr.zzimcong.ecommerce.order.dto.OrderItemResponseDto;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemRepositoryCustom{

    private final EntityManager em;

    @Override
    public List<OrderItemResponseDto> findAllByOrders(List<Long> orderIds) {
        return em.createQuery("SELECT new kr.zzimcong.ecommerce.order.dto.OrderItemResponseDto(o.id, i.name, i.price, i.discountRate, i.discountPrice, oi.quantity)"
                + " FROM OrderItem oi"
                + " JOIN Order o ON oi.order.id = o.id"
                + " JOIN Item i ON oi.item.id = i.id"
                + " WHERE o.id in :orderIds", OrderItemResponseDto.class
        )
                .setParameter("orderIds", orderIds)
                .getResultList();
    }
}
