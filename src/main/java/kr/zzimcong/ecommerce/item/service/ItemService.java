package kr.zzimcong.ecommerce.item.service;

import kr.zzimcong.ecommerce.item.domain.Category;
import kr.zzimcong.ecommerce.item.domain.Item;
import kr.zzimcong.ecommerce.item.dto.ItemResponseDto;
import kr.zzimcong.ecommerce.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {

    List<ItemResponseDto> findAll();
    ItemResponseDto findById(Long id);

}
