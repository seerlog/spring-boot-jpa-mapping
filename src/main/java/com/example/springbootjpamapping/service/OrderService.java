package com.example.springbootjpamapping.service;

import com.example.springbootjpamapping.domain.member.MemberRepository;
import com.example.springbootjpamapping.domain.order.OrderRepository;
import com.example.springbootjpamapping.response.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    public List<OrderResponse> getOrders(String id) {
        return memberRepository.findById(id).getOrders().stream()
                .map(OrderResponse::of)
                .collect(java.util.stream.Collectors.toList());
    }
}
