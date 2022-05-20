package kr.zzimcong.ecommerce.item.domain;

import kr.zzimcong.ecommerce.order.domain.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static kr.zzimcong.ecommerce.common.StatusCode.STOCK_ZERO_EXCEPTION;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "ITEM_SEQ_GENERATOR",
        sequenceName = "ITEM_SEQ",
        allocationSize = 1
)
@EntityListeners(value = AuditingEntityListener.class)
public class Item {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_SEQ_GENERATOR"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    private Integer discountRate;

    @NotNull
    private Integer stock;

    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    public Item(Category category, Brand brand, String name, Integer price, Integer discountRate, Integer stock){
        this.category = category;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
    }

    public void checkStock(int quantity){
        int nowStock = stock - quantity;
        if(nowStock < 0 )
            throw new IllegalStateException(STOCK_ZERO_EXCEPTION.getMessage());
        stock = nowStock;
    }


    public int getDiscountPrice() {
        return price * (discountRate / 100);
    }

}
