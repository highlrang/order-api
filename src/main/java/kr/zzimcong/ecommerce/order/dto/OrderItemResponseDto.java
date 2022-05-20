package kr.zzimcong.ecommerce.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.zzimcong.ecommerce.item.domain.Item;
import kr.zzimcong.ecommerce.order.domain.OrderItem;
import lombok.Getter;

@Getter
public class OrderItemResponseDto {
    @JsonIgnore
    private Long orderId;
    private String itemName;
    private int price;
    private int discountRate;
    private int discountPrice;
    private int quantity;

    public OrderItemResponseDto(Long orderId, String itemName, int price, int discountRate, int discountPrice, int quantity){
        this.orderId = orderId;
        this.itemName = itemName;
        this.price = price;
        this.discountRate = discountRate;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
    }

    public OrderItemResponseDto(OrderItem oi){ // 쿼리 확인하기
        Item item = oi.getItem();
        this.itemName = item.getName();
        this.price = item.getPrice();
        this.discountRate = item.getDiscountPrice();
        this.quantity = oi.getQuantity();
    }
}
