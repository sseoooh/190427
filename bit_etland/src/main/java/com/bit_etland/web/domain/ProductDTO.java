package com.bit_etland.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component
public class ProductDTO {
	String productId, productName, supplierId, categoryId, unit, price, photo;
}