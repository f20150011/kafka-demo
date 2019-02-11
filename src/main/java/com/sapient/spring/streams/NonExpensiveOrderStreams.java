package com.sapient.spring.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface NonExpensiveOrderStreams {

	String INPUT = "InNonExpensiveOrder";
	String OUTPUT = "OutNonExpensiveOrder";
	
	@Input(INPUT)
	SubscribableChannel inNonExpensiveOrder();

	@Output(OUTPUT)
	MessageChannel outNonExpensiveOrder();
	
}
