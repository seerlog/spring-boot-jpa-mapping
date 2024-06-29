package com.example.springbootjpamapping.response.order;

import com.example.springbootjpamapping.domain.order.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private String orderNumber;
    private LocalDateTime orderAt;
    private Order.Status status;
    private List<OrderProductResponse> products;

    public static List<OrderResponse> of(List<Order> orders) {
        return orders.stream()
                .map(OrderResponse::of)
                .toList();
    }

    public static OrderResponse of(Order order) {
        OrderResponse response = new OrderResponse();
        response.setOrderNumber(order.getOrderNumber());
        response.setOrderAt(order.getOrderAt());
        response.setStatus(order.getStatus());
        response.setProducts(OrderProductResponse.of(order.getOrderProducts()));
        return response;
    }
}
