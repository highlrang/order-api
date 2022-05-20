package kr.zzimcong.ecommerce.cart.domain;

import kr.zzimcong.ecommerce.item.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @Getter
@NoArgsConstructor
public class CartItem {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @NotNull
    private Integer quantity;

    @Builder
    public CartItem(Item item, Integer quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public void setCart(Cart cart){
        this.cart = cart;
        cart.addCartItem(this);
    }
}
