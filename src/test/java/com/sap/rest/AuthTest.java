package com.sap.rest;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sap.config.TestConfig;
import com.sap.rest.services.impl.dataObjects.SAMLRequest;

public class AuthTest {

	@Autowired
    private ApplicationContext applicationContext;
	
	public static void main(String [] args) throws  IOException {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				TestConfig.class);
		
		testGetMetaData(applicationContext);
		testGetSAMLAssertion(applicationContext);
	}
	
	public static void testGetMetaData(
			AnnotationConfigApplicationContext applicationContext)
			throws IOException {

		Client client = (Client) applicationContext.getBean("jerseyClient");

		WebTarget webTarget = client
				.target("http://localhost:7001/Katerra_Auth_1.0/rest/SAMLAuthController/getMetaData");

		javax.ws.rs.client.Invocation.Builder request = webTarget.request();

		Response response = request.get();

		String metaData = response.getEntity().toString();

		System.out.println("metaData: " + metaData);
	}
	
	public static void testGetSAMLAssertion(
			AnnotationConfigApplicationContext applicationContext)
			throws IOException {

		Client client = (Client) applicationContext.getBean("jerseyClient");

		WebTarget webTarget = client
				.target("http://localhost:7001/Katerra_Auth_1.0/rest/SAMLAuthController/getSAMLAssertion");

		javax.ws.rs.client.Invocation.Builder request = webTarget.request();
		SAMLRequest sAMLRequest = new SAMLRequest();
		sAMLRequest.setClientUser("Test");
		Response response = request.post(Entity.entity(sAMLRequest, MediaType.APPLICATION_JSON));

		String metaData = response.getEntity().toString();

		System.out.println("metaData: " + metaData);
	}
	
}