package kr.zzimcong.ecommerce.item.repository;

import kr.zzimcong.ecommerce.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {
}
