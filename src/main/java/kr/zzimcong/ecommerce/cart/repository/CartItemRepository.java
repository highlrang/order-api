package kr.zzimcong.ecommerce.cart.repository;

import kr.zzimcong.ecommerce.cart.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findAllByIdIn(List<Long> ids);
}
