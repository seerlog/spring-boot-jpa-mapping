package com.example.springbootjpamapping.domain.order;

import com.example.springbootjpamapping.domain.member.Member;
import com.example.springbootjpamapping.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO", nullable = false)
    private Long no;

    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDateTime orderDt;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_NO")
    private Product product;
}
