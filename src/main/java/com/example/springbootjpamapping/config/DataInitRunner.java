package com.example.springbootjpamapping.config;

import com.example.springbootjpamapping.domain.member.Member;
import com.example.springbootjpamapping.domain.member.MemberRepository;
import com.example.springbootjpamapping.domain.order.Order;
import com.example.springbootjpamapping.domain.order.OrderRepository;
import com.example.springbootjpamapping.domain.orderProduct.OrderProduct;
import com.example.springbootjpamapping.domain.orderProduct.OrderProductRepository;
import com.example.springbootjpamapping.domain.product.Product;
import com.example.springbootjpamapping.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitRunner implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) {
        memberRepository.saveAll(createMembers());
        productRepository.saveAll(createProducts());
    }

    private List<Member> createMembers() {
        return List.of(
                Member.builder().name("김홍석").build(),
                Member.builder().name("나연준").build(),
                Member.builder().name("박태경").build(),
                Member.builder().name("이승준").build()
        );
    }

    private List<Product> createProducts() {
        return List.of(
                Product.builder().name("나무의자").price(60000).build(),
                Product.builder().name("손전등").price(25000).build(),
                Product.builder().name("야구모자").price(40000).build(),
                Product.builder().name("백팩").price(120000).build(),
                Product.builder().name("에어팟").price(250000).build(),
                Product.builder().name("축구공").price(36000).build(),
                Product.builder().name("자전거").price(320000).build(),
                Product.builder().name("모자").price(56000).build(),
                Product.builder().name("카드지갑").price(23000).build()
        );
    }
}
