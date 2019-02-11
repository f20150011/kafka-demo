package com.sapient.spring.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.sapient.spring.streams.ExpensiveOrderStreams;
import com.sapient.spring.streams.NonExpensiveOrderStreams;

@EnableBinding({ExpensiveOrderStreams.class,NonExpensiveOrderStreams.class})
public class Config {
	
}
