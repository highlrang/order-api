package kr.zzimcong.ecommerce.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    @Embedded
    private Address address;

    public static Delivery create(Address address){
        Delivery delivery = new Delivery();
        delivery.address = address;
        delivery.deliveryStatus = DeliveryStatus.READY;
        return delivery;
    }
}
