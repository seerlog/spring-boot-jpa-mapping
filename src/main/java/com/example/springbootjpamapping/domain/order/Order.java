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
import java.util.UUID;

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

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
    private List<OrderProduct> orderProducts;

    public enum Status {
        ORDER_CREATED,
        PAYMENT_COMPLETED,
        PREPARING_DELIVERY,
        IN_TRANSIT,
        DELIVERED,
        ORDER_CANCELLED;

        public static Status randomStatus() {
            return values()[(int) (Math.random() * values().length)];
        }
    }

    public static Order of(List<OrderProduct> orderProducts) {
        return Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderAt(LocalDateTime.now())
                .status(Status.randomStatus())
                .orderProducts(orderProducts)
                .build();
    }
}
