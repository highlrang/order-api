package kr.zzimcong.ecommerce.item.controller;

import kr.zzimcong.ecommerce.common.ApiResponseDto;
import kr.zzimcong.ecommerce.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kr.zzimcong.ecommerce.common.StatusCode.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemApiController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(value = "brand", required = false) Long brandId,
                                     @RequestParam(value = "category", required = false) Long categoryId,
                                     @RequestParam(value = "search", required = false) String search,
                                     @RequestParam(value = "sort", required = false) String sort){
        return ResponseEntity.ok(
                ApiResponseDto.success(itemService.findAll(brandId, categoryId, search, sort))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                ApiResponseDto.success(itemService.findById(id))
        );
    }


}
