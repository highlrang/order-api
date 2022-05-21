package kr.zzimcong.ecommerce.cart.repository;

import kr.zzimcong.ecommerce.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c JOIN FETCH c.user u JOIN FETCH c.cartItems ci JOIN FETCH ci.item i JOIN FETCH i.brand WHERE u.id = :userId")
    Optional<Cart> findByUser(@Param(value = "userId") Long userId);

}
