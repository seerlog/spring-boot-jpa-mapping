package com.example.springbootjpamapping.response.order;

import com.example.springbootjpamapping.domain.order.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private String orderNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime orderAt;
    private String status;
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
        response.setStatus(order.getStatus().getDescription());
        response.setProducts(OrderProductResponse.of(order.getOrderProducts()));
        return response;
    }
}
