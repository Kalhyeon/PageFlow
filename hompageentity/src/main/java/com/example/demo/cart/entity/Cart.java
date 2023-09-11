package com.example.demo.cart.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private Long cno;
	private Long bno;
	private String memberId;
	private Long cartCount;
}
