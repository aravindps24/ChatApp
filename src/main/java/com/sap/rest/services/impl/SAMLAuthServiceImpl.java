package com.sap.rest.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.config.SAMLProperties;
import com.sap.rest.services.api.SAMLAuthService;
import com.sap.rest.services.impl.dataObjects.MetaDataRequest;
import com.sap.rest.services.impl.dataObjects.SAMLRequest;
import com.sap.security.oa2.TrustData;

@Service
public class SAMLAuthServiceImpl implements SAMLAuthService {

	@Autowired
	SAMLProperties samlProperties;
	
	@Autowired
	LocalAssertionOAuth2IMPL localAssertionOAuth2IMPL;
	
	public String getMetaData(MetaDataRequest metaDataRequest) throws Exception {

		return getSAML2Metadata(metaDataRequest);
	}

	public String getSAMLAssertion(SAMLRequest sAMLRequest) throws Exception {
		return localAssertionOAuth2IMPL.getSAMLAssertion();
	}
	
	public String getSAML2Metadata(MetaDataRequest metaDataRequest) throws Exception {
		File f = new File("metadata.xml");
		FileOutputStream fos = new FileOutputStream(f);
		System.out.println("SAML2 Metadata");
		new TrustData(samlProperties).createMetadata(fos);
		fos.close();
		String path = f.getAbsolutePath();
		System.out.println("Metadata written to " + path);
		
		String data = new String(Files.readAllBytes(Paths.get(path)));
		
		return data;
	}
}
