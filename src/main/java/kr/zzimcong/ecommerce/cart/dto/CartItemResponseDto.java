package kr.zzimcong.ecommerce.cart.dto;

import kr.zzimcong.ecommerce.cart.domain.CartItem;
import kr.zzimcong.ecommerce.item.dto.ItemResponseDto;
import lombok.Getter;

@Getter
public class CartItemResponseDto {
    private Long id;
    private ItemResponseDto item;

    public CartItemResponseDto(CartItem cartItem){
        this.id = cartItem.getId();
        this.item = new ItemResponseDto(cartItem.getItem());
    }
}
