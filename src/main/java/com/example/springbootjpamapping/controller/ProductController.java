package com.example.springbootjpamapping.controller;

import com.example.springbootjpamapping.response.member.MemberResponse;
import com.example.springbootjpamapping.response.product.ProductResponse;
import com.example.springbootjpamapping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getMembers() {
        return ResponseEntity.ok(productService.getProducts());
    }
}
