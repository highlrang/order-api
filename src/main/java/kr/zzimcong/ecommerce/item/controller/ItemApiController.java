package kr.zzimcong.ecommerce.item.controller;

import kr.zzimcong.ecommerce.common.ApiResponseDto;
import kr.zzimcong.ecommerce.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kr.zzimcong.ecommerce.common.StatusCode.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemApiController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(
                ApiResponseDto.success(itemService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                ApiResponseDto.success(itemService.findById(id))
        );
    }


}
