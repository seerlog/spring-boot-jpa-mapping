package com.example.springbootjpamapping.domain.member;

import com.example.springbootjpamapping.domain.common.BaseEntity;
import com.example.springbootjpamapping.domain.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO", nullable = false)
    private Long no;

    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Order> orders;
}
