package com.sapient.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.spring.dto.Order;
import com.sapient.spring.service.IOrderService;

@RestController
public class Controller {

	@Autowired
	private final IOrderService orderService;

	public Controller(IOrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/orders")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void greetings(@RequestParam("item") String item, @RequestParam("price") float price) {
		Order order = new Order();
		order.setItem(item);
		order.setPrice(price);
		orderService.sendOrder(order);
	}

}
