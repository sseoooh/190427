package com.bit_etland.web.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component
public class OrderDTO {
	String orderId, customer_Id, employeeId, orderDate, shipperId;
}
