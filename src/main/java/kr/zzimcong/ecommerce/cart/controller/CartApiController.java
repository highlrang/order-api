package kr.zzimcong.ecommerce.cart.controller;

import kr.zzimcong.ecommerce.cart.dto.CartItemRequestDto;
import kr.zzimcong.ecommerce.cart.dto.CartResponseDto;
import kr.zzimcong.ecommerce.cart.service.CartService;
import kr.zzimcong.ecommerce.common.ApiResponseDto;
import kr.zzimcong.ecommerce.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static kr.zzimcong.ecommerce.common.StatusCode.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartApiController {

    private final HttpSession session;
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<?> findByUser(){
        CartResponseDto cart = cartService.findByUser();
        return ResponseEntity.ok(
                ApiResponseDto.success(cart)
        );
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addCartItem(@PathVariable("id") Long id,
                                         @RequestBody @Valid CartItemRequestDto dto){
        cartService.addCartItem(id, dto);
        return ResponseEntity.ok(ApiResponseDto.success());
    }

    @DeleteMapping("/{id}/item")
    public ResponseEntity<?> removeCartItem(@PathVariable("id") Long cartId,
                                            @RequestParam("cartItemId") List<Long> cartItemIds){
        cartService.removeCartItem(cartId, cartItemIds);
        return ResponseEntity.ok(ApiResponseDto.success());
    }
}
