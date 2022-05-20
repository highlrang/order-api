package kr.zzimcong.ecommerce.order.repository;

import kr.zzimcong.ecommerce.order.dto.OrderItemResponseDto;
import kr.zzimcong.ecommerce.order.dto.OrderResponseDto;

import java.util.List;

public interface OrderRepositoryCustom {
    List<OrderResponseDto> findAllDto(Long userId);
}
