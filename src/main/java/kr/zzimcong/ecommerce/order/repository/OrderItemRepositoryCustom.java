package kr.zzimcong.ecommerce.order.repository;

import kr.zzimcong.ecommerce.order.dto.OrderItemResponseDto;

import java.util.List;

public interface OrderItemRepositoryCustom {
    List<OrderItemResponseDto> findAllByOrders(List<Long> orderIds);

}
