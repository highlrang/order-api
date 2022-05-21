package kr.zzimcong.ecommerce.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor
@Table(name = "ORDERS")
@EntityListeners(value = AuditingEntityListener.class)
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private Integer totalPrice;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @CreatedDate
    private LocalDateTime createdDate;

    public static Order create(Delivery delivery, OrderItem... orderItems){
        Order order = new Order();
        order.addOrderItem(orderItems);
        order.delivery = delivery;
        order.calcTotalPrice();
        order.orderStatus = OrderStatus.INPROGRESS;
        return order;
    }

    public void addOrderItem(OrderItem... orderItems){
        this.orderItems.addAll(List.of(orderItems));
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(this);
        }
    }

    public void calcTotalPrice(){
        totalPrice = orderItems.stream()
                        .mapToInt(oi -> {
                            int price = oi.getItem().getDiscountPrice() != null ?
                                oi.getItem().getDiscountPrice() : oi.getItem().getPrice();
                            return price * oi.getQuantity();
                        })
                        .sum();
    }

    public void cancel(){
        for (OrderItem oi : orderItems) {
            oi.getItem().addStock(oi.getQuantity());
        }
        delivery.setDeliveryStatus(DeliveryStatus.CANCEL);
        orderStatus = OrderStatus.CANCEL;
    }
}
