package kr.zzimcong.ecommerce.cart.domain;

import kr.zzimcong.ecommerce.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    public void addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
    }

    public void removeCartItem(CartItem... cartItem){
        this.cartItems.removeAll(List.of(cartItem));
    }

    public Cart(User user){
        this.user = user;
        user.setCart(this);
    }
}
