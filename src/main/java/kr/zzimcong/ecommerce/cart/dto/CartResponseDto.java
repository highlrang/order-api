package kr.zzimcong.ecommerce.cart.dto;

import kr.zzimcong.ecommerce.cart.domain.Cart;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponseDto {
    private Long id;
    private List<CartItemResponseDto> cartItems;

    public CartResponseDto(Cart cart){
        this.id = cart.getId();
        this.cartItems = cart.getCartItems().stream()
                .map(CartItemResponseDto::new)
                .collect(Collectors.toList());
    }
}
