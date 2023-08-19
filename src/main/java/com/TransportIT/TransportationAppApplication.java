package com.TransportIT;

import com.TransportIT.service.TransportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TransportationAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TransportationAppApplication.class, args);
		TransportService transportService = context.getBean(TransportService.class);
		transportService.processTransport();
	}

}
