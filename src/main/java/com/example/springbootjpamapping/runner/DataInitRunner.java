package com.example.springbootjpamapping.runner;

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

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitRunner implements ApplicationRunner {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) {
        productRepository.saveAll(createProducts());
        memberRepository.saveAll(createMembers());
    }

    private List<Member> createMembers() {
        Member member1 = Member.builder().name("김홍석").orders(createOrders()).build();
        Member member2 = Member.builder().name("나연준").orders(createOrders()).build();
        Member member3 = Member.builder().name("박태경").orders(createOrders()).build();
        Member member4 = Member.builder().name("이승준").orders(createOrders()).build();
        return List.of(member1, member2, member3, member4);
    }

    private List<Order> createOrders() {
        return List.of(
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts()),
                Order.of(getOrderProducts())
        );
    }

    private List<OrderProduct> getOrderProducts() {
        List<Product> products = productRepository.findAll();
        return List.of(
                OrderProduct.builder().product(products.get(0)).quantity(2).build(),
                OrderProduct.builder().product(products.get(1)).quantity(1).build(),
                OrderProduct.builder().product(products.get(2)).quantity(3).build(),
                OrderProduct.builder().product(products.get(3)).quantity(1).build(),
                OrderProduct.builder().product(products.get(4)).quantity(2).build(),
                OrderProduct.builder().product(products.get(5)).quantity(1).build(),
                OrderProduct.builder().product(products.get(6)).quantity(1).build(),
                OrderProduct.builder().product(products.get(7)).quantity(2).build(),
                OrderProduct.builder().product(products.get(8)).quantity(1).build()
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
