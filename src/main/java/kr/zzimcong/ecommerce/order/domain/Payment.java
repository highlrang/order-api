package kr.zzimcong.ecommerce.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private String name;

    private Integer price;

    private PaymentType paymentType;

    private PaymentStatus paymentStatus;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    public static Payment create(Order order, String name, Integer price, PaymentType paymentType){
        Payment payment = new Payment();
        payment.order = order;
        payment.name = name;
        payment.price = price;
        payment.paymentType = paymentType;
        payment.paymentStatus = PaymentStatus.READY;
        return payment;
    }

    public void setPaymentStatus(PaymentStatus status){
        paymentStatus = status;
    }
}
