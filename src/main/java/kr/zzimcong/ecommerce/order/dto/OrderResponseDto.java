package kr.zzimcong.ecommerce.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.zzimcong.ecommerce.order.domain.Order;
import kr.zzimcong.ecommerce.order.domain.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderResponseDto {
    private Long id;
    private List<OrderItemResponseDto> orderItems;
    private String orderStatus;
    private int totalPrice;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdDate;

    /** 목록 DTO */
    public OrderResponseDto(Long id, OrderStatus status, int totalPrice, LocalDateTime createdDate){
        this.id = id;
        this.orderStatus = status.getName();
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
    }

    public void setOrderItems(List<OrderItemResponseDto> orderItems){
        this.orderItems = orderItems;
    }

    public OrderResponseDto(Order o){
        this.id = o.getId();
        this.orderStatus = o.getOrderStatus().getName();
        this.totalPrice = o.getTotalPrice();
        this.createdDate = o.getCreatedDate();
    }
}
