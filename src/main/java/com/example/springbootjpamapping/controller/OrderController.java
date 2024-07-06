package com.example.springbootjpamapping.controller;

import com.example.springbootjpamapping.response.order.OrderResponse;
import com.example.springbootjpamapping.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("{id}")
    public ResponseEntity<List<OrderResponse>> getMembers(@PathVariable("id") String id) {
        return ResponseEntity.ok(orderService.getOrders(id));
    }
}
