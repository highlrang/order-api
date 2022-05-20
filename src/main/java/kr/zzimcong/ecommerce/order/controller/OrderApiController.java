package kr.zzimcong.ecommerce.order.controller;

import kr.zzimcong.ecommerce.order.dto.OrderRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderApiController {

    @GetMapping
    public ResponseEntity<?> findAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return null;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid OrderRequestDto dto){
        return null;
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable("id") Long id){
        return null;
    }
}
