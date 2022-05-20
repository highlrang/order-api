package kr.zzimcong.ecommerce.order.dto;

import lombok.Getter;

@Getter
public class OrderItemRequestDto {
    private Long itemId;
    private Integer quantity;
    private Integer price;
}
