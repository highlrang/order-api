package kr.zzimcong.ecommerce.order.domain;

import kr.zzimcong.ecommerce.item.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer quantity;

    @Builder
    public OrderItem(Item item, Integer quantity){
        this.item = item;
        item.removeStock(quantity);
        this.quantity = quantity;
    }

    public void setOrder(Order order){
        this.order = order;
    }
}
