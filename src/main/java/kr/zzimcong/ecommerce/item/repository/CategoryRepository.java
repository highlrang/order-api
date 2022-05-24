package kr.zzimcong.ecommerce.item.repository;

import kr.zzimcong.ecommerce.item.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
