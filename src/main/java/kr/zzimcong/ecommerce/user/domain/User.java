package kr.zzimcong.ecommerce.user.domain;

import kr.zzimcong.ecommerce.cart.domain.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ZzimItem> zzimItems = new ArrayList<>();

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public void addZzimItem(ZzimItem item){
        this.zzimItems.add(item);
    }

    @Builder
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
