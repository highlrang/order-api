package kr.zzimcong.ecommerce.order.controller;

import kr.zzimcong.ecommerce.common.ApiResponseDto;
import kr.zzimcong.ecommerce.order.dto.OrderRequestDto;
import kr.zzimcong.ecommerce.order.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderApiController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
                ApiResponseDto.success(orderService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            ApiResponseDto.success(orderService.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid OrderRequestDto dto){
        return ResponseEntity.ok(
                ApiResponseDto.success(orderService.save(dto))
        );
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable("id") Long id){
        orderService.cancel(id);
        return ResponseEntity.ok(ApiResponseDto.success());
    }
}
