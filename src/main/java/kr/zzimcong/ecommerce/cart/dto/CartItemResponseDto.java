package kr.zzimcong.ecommerce.cart.dto;

import kr.zzimcong.ecommerce.item.dto.ItemResponseDto;
import lombok.Getter;

@Getter
public class CartItemResponseDto {
    private Long id;
    private ItemResponseDto item;
}
