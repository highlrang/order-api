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
        if(userDto == null)
            throw new IllegalStateException(USER_LOGIN_REQUIRED.getMessage());

        Optional<Cart> optionalCart = cartRepository.findByUser(userDto.getId());
        Cart cart;
        if (optionalCart.isPresent()){
            cart = optionalCart.get();
       }else {
            cart = createCart(userDto.getId());
        }
        return new CartResponseDto(cart);
    }

    private Cart createCart(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(USER_NOT_FOUND.getMessage()));
        return cartRepository.save(new Cart(user));
    }

    @Transactional
    @Override
    public void addCartItem(Long cartId, CartItemRequestDto dto) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Cart cart;
        if(optionalCart.isPresent()) {
            cart = optionalCart.get();
        }else{
            UserResponseDto userDto = (UserResponseDto) session.getAttribute("user");
            if (userDto == null)
                throw new IllegalStateException(USER_LOGIN_REQUIRED.getMessage());
            cart = createCart(userDto.getId());
        }

        Item item = itemRepository.findById(dto.getItemId())
                        .orElseThrow(() -> new IllegalStateException(ITEM_NOT_FOUND.getMessage()));

        CartItem cartItem = CartItem.builder()
                .item(item)
                .quantity(dto.getQuantity())
                .build();
        cartItem.setCart(cart);

        cart.addCartItem(cartItem);
    }

    @Transactional
    @Override
    public void removeCartItem(Long cartId, List<Long> cartItemIds) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException(CART_NOT_FOUND.getMessage()));

        /** 삭제할 장바구니 상품 호출 */
        List<CartItem> cartItems = cartItemRepository.findAllByIdIn(cartItemIds);

        cart.removeCartItem(cartItems.toArray(CartItem[]::new));

        cartItemRepository.deleteAllInBatch(cartItems);
    }
}
