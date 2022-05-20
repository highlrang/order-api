package kr.zzimcong.ecommerce.cart.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CartItemRequestDto {
    @NotNull
    private Long itemId;
    @NotNull
    private Integer quantity;
}
