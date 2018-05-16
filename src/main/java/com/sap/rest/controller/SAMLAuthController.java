package com.sap.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.rest.services.api.SAMLAuthService;
import com.sap.rest.services.impl.dataObjects.MetaDataRequest;
import com.sap.rest.services.impl.dataObjects.SAMLRequest;

@Component
@Path("/SAMLAuthController")
public class SAMLAuthController {
	
	@Autowired
	private SAMLAuthService sAMLAuthService; 

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getMetaData")
	public String getMetaData(MetaDataRequest metaDataRequest) throws Exception {
		
		return "This is a MetaData response";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getSAMLAssertion")
    public String getSAMLAssertion(SAMLRequest sAMLRequest) throws Exception {
		return sAMLAuthService.getSAMLAssertion(sAMLRequest);
    }
}
