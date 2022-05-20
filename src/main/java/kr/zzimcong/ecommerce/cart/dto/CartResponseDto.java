package kr.zzimcong.ecommerce.cart.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CartResponseDto {
    private Long id;
    private List<CartItemResponseDto> cartItems;
}
