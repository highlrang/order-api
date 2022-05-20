package kr.zzimcong.ecommerce.order.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {
    private List<OrderItemRequestDto> orderItems;
    private AddressDto address;
}
