package kr.zzimcong.ecommerce.item.repository;

import kr.zzimcong.ecommerce.item.dto.ItemResponseDto;

import java.util.List;

public interface ItemRepositoryCustom{
    List<ItemResponseDto> findAllDto();
}
