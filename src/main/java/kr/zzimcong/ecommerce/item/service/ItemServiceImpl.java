package kr.zzimcong.ecommerce.item.service;

import kr.zzimcong.ecommerce.item.domain.Item;
import kr.zzimcong.ecommerce.item.dto.ItemResponseDto;
import kr.zzimcong.ecommerce.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static kr.zzimcong.ecommerce.common.StatusCode.ITEM_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public List<ItemResponseDto> findAll(Long brandId, Long categoryId, String search, String sort) {
        return itemRepository.findAllDto(brandId, categoryId, search, sort);
    }

    @Override
    public ItemResponseDto findById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(ITEM_NOT_FOUND.getMessage()));
        item.increaseViews();
        return new ItemResponseDto(item);
    }
}
