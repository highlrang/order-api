package kr.zzimcong.ecommerce.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.zzimcong.ecommerce.order.domain.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderResponseDto {
    private Long id;
    private List<OrderItemResponseDto> orderItems;
    private String orderStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdDate;
    private int totalPrice;
}
