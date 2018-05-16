package com.sap.config;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

	@Bean
	public static Client jerseyClient() {
		return ClientBuilder.newClient();
	}
}
