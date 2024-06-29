package com.example.springbootjpamapping.response.order;

import com.example.springbootjpamapping.domain.orderProduct.OrderProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderProductResponse {
    private String name;
    private int price;
    private int quantity;

    public static List<OrderProductResponse> of(List<OrderProduct> orderProducts) {
        return orderProducts.stream()
                .map(OrderProductResponse::of)
                .toList();
    }

    public static OrderProductResponse of(OrderProduct orderProduct) {
        OrderProductResponse response = new OrderProductResponse();
        response.setName(orderProduct.getProduct().getName());
        response.setPrice(orderProduct.getProduct().getPrice());
        response.setQuantity(orderProduct.getQuantity());
        return response;
    }
}
