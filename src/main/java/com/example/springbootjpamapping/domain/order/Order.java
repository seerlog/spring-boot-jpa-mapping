package com.example.springbootjpamapping.domain.order;

import com.example.springbootjpamapping.domain.common.BaseEntity;
import com.example.springbootjpamapping.domain.member.Member;
import com.example.springbootjpamapping.domain.orderProduct.OrderProduct;
import com.example.springbootjpamapping.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO", nullable = false)
    private Long no;

    @Column(name = "ORDER_NUMBER", nullable = false)
    private String orderNumber;

    @Column(name = "ORDER_AT", nullable = false)
    private LocalDateTime orderAt;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderProduct> orderProducts;
}
