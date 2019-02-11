package com.sapient.spring.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sapient.spring.dto.Order;
import com.sapient.spring.streams.ExpensiveOrderStreams;
import com.sapient.spring.streams.NonExpensiveOrderStreams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Listener {

	@StreamListener(ExpensiveOrderStreams.INPUT)
	public void readExpensiveOrder(@Payload Order order) {
		log.info("Received expensive order: {}", order);
	}

	@StreamListener(NonExpensiveOrderStreams.INPUT)
	public void readNonExpensiveOrder(@Payload Order order) {
		log.info("Received non expensive order: {}", order);
	}
	
}
