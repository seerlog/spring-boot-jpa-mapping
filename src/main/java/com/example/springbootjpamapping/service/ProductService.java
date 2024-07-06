package com.example.springbootjpamapping.service;

import com.example.springbootjpamapping.domain.product.ProductRepository;
import com.example.springbootjpamapping.response.order.OrderResponse;
import com.example.springbootjpamapping.response.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::of)
                .collect(java.util.stream.Collectors.toList());
    }
}
