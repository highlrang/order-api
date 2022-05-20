package kr.zzimcong.ecommerce.order.dto;

import lombok.Getter;

@Getter
public class OrderItemResponseDto {
    private String itemName;
    private int price;
    private int quantity;
}
