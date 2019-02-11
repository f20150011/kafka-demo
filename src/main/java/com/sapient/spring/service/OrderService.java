package com.sapient.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.sapient.spring.dto.Order;
import com.sapient.spring.streams.ExpensiveOrderStreams;
import com.sapient.spring.streams.NonExpensiveOrderStreams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderService implements IOrderService {

	@Autowired
	private ExpensiveOrderStreams expensiveOrderStreams;
	@Autowired
	private NonExpensiveOrderStreams nonExpensiveOrderStreams;
	
	private void sendExpensiveOrder(Order order) {
		
		log.info("Sending order through expensive orders' stream : {}", order);
		
		MessageChannel messageChannel = expensiveOrderStreams.outExpensiveOrder();
        messageChannel.send(MessageBuilder
                .withPayload(order)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
	}
	
	private void sendNonExpensiveOrder(Order order) {
		
		log.info("Sending order through non expensive orders' stream : {}", order);
		
		MessageChannel messageChannel = nonExpensiveOrderStreams.outNonExpensiveOrder();
        messageChannel.send(MessageBuilder
                .withPayload(order)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
	}
	
	@Override
	public void sendOrder(Order order) {

        if(order.getPrice() >= 50 ) {
        	sendExpensiveOrder(order);
        } else {
        	sendNonExpensiveOrder(order);
        }
		
	}

}
