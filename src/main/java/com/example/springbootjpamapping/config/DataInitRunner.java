package com.example.springbootjpamapping.config;

import com.example.springbootjpamapping.domain.member.MemberRepository;
import com.example.springbootjpamapping.domain.order.OrderRepository;
import com.example.springbootjpamapping.domain.orderProduct.OrderProductRepository;
import com.example.springbootjpamapping.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitRunner implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) {
        // memberRepository.save(Member.builder().name("이수민").build());
    }
}
