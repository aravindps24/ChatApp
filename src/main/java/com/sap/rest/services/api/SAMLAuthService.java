package com.sap.rest.services.api;

import com.sap.rest.services.impl.dataObjects.MetaDataRequest;
import com.sap.rest.services.impl.dataObjects.SAMLRequest;

public interface SAMLAuthService {

	public String getMetaData(MetaDataRequest metaDataRequest) throws Exception;
	
	public String getSAMLAssertion(SAMLRequest sAMLRequest) throws Exception;
}
