package com.example.order.dto;

public record OrderRequest(String identity,long productId,int quantity) {
}
