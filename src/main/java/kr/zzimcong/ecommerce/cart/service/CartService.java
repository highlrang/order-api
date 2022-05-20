package kr.zzimcong.ecommerce.cart.service;

import kr.zzimcong.ecommerce.cart.dto.CartItemRequestDto;
import kr.zzimcong.ecommerce.cart.dto.CartResponseDto;

import java.util.List;

public interface CartService {
    CartResponseDto findByUser(Long userId);
    void addCartItem(CartItemRequestDto dto);
    void removeCartItem(Long cartId, List<Long> cartItemIds);
}
