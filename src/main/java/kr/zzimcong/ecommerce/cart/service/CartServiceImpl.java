package kr.zzimcong.ecommerce.cart.service;

import kr.zzimcong.ecommerce.cart.domain.Cart;
import kr.zzimcong.ecommerce.cart.domain.CartItem;
import kr.zzimcong.ecommerce.cart.dto.CartItemRequestDto;
import kr.zzimcong.ecommerce.cart.dto.CartResponseDto;
import kr.zzimcong.ecommerce.cart.repository.CartItemRepository;
import kr.zzimcong.ecommerce.cart.repository.CartRepository;
import kr.zzimcong.ecommerce.item.domain.Item;
import kr.zzimcong.ecommerce.item.repository.ItemRepository;
import kr.zzimcong.ecommerce.user.domain.User;
import kr.zzimcong.ecommerce.user.dto.UserResponseDto;
import kr.zzimcong.ecommerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static kr.zzimcong.ecommerce.common.StatusCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final HttpSession session;

    @Override
    public CartResponseDto findByUser() {
        UserResponseDto userDto = (UserResponseDto) session.getAttribute("user");
        Optional<Cart> optionalCart = cartRepository.findByUser(userDto.getId());
        Cart cart;
        if (optionalCart.isPresent()){
            cart = optionalCart.get();
       }else {
            User user = userRepository.findById(userDto.getId())
                    .orElseThrow(() -> new IllegalArgumentException(USER_NOT_FOUND.getMessage()));
            cart = cartRepository.save(new Cart(user));
        }
        return new CartResponseDto(cart);
    }

    @Override
    public void addCartItem(Long cartId, CartItemRequestDto dto) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Cart cart;
        if(!optionalCart.isPresent()) {
            UserResponseDto userDto = (UserResponseDto) session.getAttribute("user");
            User user = userRepository.findById(userDto.getId())
                    .orElseThrow(() -> new IllegalStateException(USER_NOT_FOUND.getMessage()));
            cart = cartRepository.save(new Cart(user));
        }else{
            cart = optionalCart.get();
        }

        Item item = itemRepository.findById(dto.getItemId())
                        .orElseThrow(() -> new IllegalStateException(ITEM_NOT_FOUND.getMessage()));

        cart.addCartItem(
                CartItem.builder()
                        .item(item)
                        .quantity(dto.getQuantity())
                        .build()
        );
    }

    @Override
    public void removeCartItem(Long cartId, List<Long> cartItemIds) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException(CART_NOT_FOUND.getMessage()));
        CartItem[] cartItems = cartItemRepository.findAllByIdIn(cartItemIds).toArray(CartItem[]::new);
        cart.removeCartItem(cartItems);
    }
}
