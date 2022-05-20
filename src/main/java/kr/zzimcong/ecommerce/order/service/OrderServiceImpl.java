package kr.zzimcong.ecommerce.order.service;

import kr.zzimcong.ecommerce.item.domain.Item;
import kr.zzimcong.ecommerce.item.repository.ItemRepository;
import kr.zzimcong.ecommerce.order.domain.Address;
import kr.zzimcong.ecommerce.order.domain.Delivery;
import kr.zzimcong.ecommerce.order.domain.Order;
import kr.zzimcong.ecommerce.order.domain.OrderItem;
import kr.zzimcong.ecommerce.order.dto.*;
import kr.zzimcong.ecommerce.order.repository.OrderItemRepository;
import kr.zzimcong.ecommerce.order.repository.OrderRepository;
import kr.zzimcong.ecommerce.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static kr.zzimcong.ecommerce.common.StatusCode.ITEM_NOT_FOUND;
import static kr.zzimcong.ecommerce.common.StatusCode.ORDER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

    private final HttpSession session;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;

    @Override
    public List<OrderResponseDto> findAll() {
        UserResponseDto user = (UserResponseDto) session.getAttribute("user");
        List<OrderResponseDto> orderList = orderRepository.findAllDto(user.getId());

        List<Long> orderIds = orderList.stream()
                .map(OrderResponseDto::getId)
                .collect(Collectors.toList());
        List<OrderItemResponseDto> orderItems = orderItemRepository.findAllByOrders(orderIds);

        Map<Long, List<OrderItemResponseDto>> mapByOrderId
                = orderItems.stream().collect(Collectors.groupingBy(OrderItemResponseDto::getOrderId));

        orderList.forEach(o -> o.setOrderItems(mapByOrderId.get(o.getId())));
        return orderList;
    }

    @Override
    public OrderResponseDto findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ORDER_NOT_FOUND.getMessage()));
        OrderResponseDto orderDto = new OrderResponseDto(order);
        orderDto.setOrderItems(
                order.getOrderItems().stream()
                    .map(OrderItemResponseDto::new)
                    .collect(Collectors.toList())
        );
        return orderDto;
    }

    @Override
    public Long save(OrderRequestDto dto){
        List<OrderItem> orderItemList = dto.getOrderItems().stream()
                .map(oi -> {
                    Item item = itemRepository.findById(oi.getItemId())
                            .orElseThrow(() -> new IllegalArgumentException(ITEM_NOT_FOUND.getMessage()));
                    return new OrderItem(item, oi.getQuantity());
                })
                .collect(Collectors.toList());

        AddressDto addressDto = dto.getAddress();
        Address address = new Address(addressDto.getBasicAddress(), addressDto.getDetailAddress(), addressDto.getPostCode());
        Order order = Order.create(Delivery.create(address), orderItemList.toArray(OrderItem[]::new));
        Order result = orderRepository.save(order);
        return result.getId();
    }

    @Override
    public void cancel(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ORDER_NOT_FOUND.getMessage()));

        // 결제 취소 요청
        // 재고 복구 및 상태 변경
        order.cancel();
    }
}
