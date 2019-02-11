package com.sapient.spring.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface ExpensiveOrderStreams {
	
	String INPUT = "InExpensiveOrder";
	String OUTPUT = "OutExpensiveOrder";

	@Input(INPUT)
	SubscribableChannel inExpensiveOrder();

	@Output(OUTPUT)
	MessageChannel outExpensiveOrder();
	
}
