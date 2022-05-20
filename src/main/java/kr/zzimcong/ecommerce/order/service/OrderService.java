package kr.zzimcong.ecommerce.order.service;

import kr.zzimcong.ecommerce.order.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    List<OrderResponseDto> findAll();
    OrderResponseDto findById(Long id);
    void cancel(Long id);
    // 상태 업데이트 기능
}
