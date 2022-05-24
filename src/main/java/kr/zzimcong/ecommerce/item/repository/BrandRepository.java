package kr.zzimcong.ecommerce.item.repository;

import kr.zzimcong.ecommerce.item.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
