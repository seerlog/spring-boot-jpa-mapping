package com.example.springbootjpamapping.domain.orderProduct;

import com.example.springbootjpamapping.domain.common.BaseEntity;
import com.example.springbootjpamapping.domain.order.Order;
import com.example.springbootjpamapping.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "ORDER_PRODUCT")
@Entity
public class OrderProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO", nullable = false)
    private Long no;

    @Column(name = "PRODUCT_COUNT", nullable = false)
    private Integer productCount;

    @ManyToOne
    @JoinColumn(name = "ORDER_NO")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_NO")
    private Product product;
}
