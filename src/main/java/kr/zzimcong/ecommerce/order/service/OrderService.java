package kr.zzimcong.ecommerce.order.service;

import kr.zzimcong.ecommerce.order.dto.OrderRequestDto;
import kr.zzimcong.ecommerce.order.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    List<OrderResponseDto> findAll();
    OrderResponseDto findById(Long id);

    Long save(OrderRequestDto dto);

    void cancel(Long id);
}
