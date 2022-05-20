package kr.zzimcong.ecommerce.cart.controller;

import kr.zzimcong.ecommerce.cart.dto.CartItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartApiController {

    @GetMapping
    public ResponseEntity<?> findByUser(){
        return null;
    }

    @PostMapping
    public ResponseEntity<?> addCartItem(@RequestBody @Valid CartItemRequestDto dto){
        return null;
    }

    @DeleteMapping("/{id}/item")
    public ResponseEntity<?> removeCartItem(
            @PathVariable("id") Long cartId,
            @RequestParam("cartItemId") List<Long> cartItemIds){
        return null;
    }
}
