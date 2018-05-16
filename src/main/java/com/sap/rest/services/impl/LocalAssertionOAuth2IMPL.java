package com.sap.rest.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.opensaml.xml.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.config.SAMLProperties;
import com.sap.security.oa2.LocalSamlTokenFactory;
import com.sap.security.oa2.OAuth2SAML2AccessToken;
import com.sap.security.oa2.TrustData;
import com.sap.security.oa2.trace.OAuthTraceData;
import com.sap.security.oa2.trace.OAuthTracer;

@Component
public class LocalAssertionOAuth2IMPL {

	LocalSamlTokenFactory localSAMLTokenFactory;
	//Properties configurationProperties;
	
	@Autowired
	SAMLProperties samlProperties;

	/*public void setUp() throws IOException, NoSuchAlgorithmException,
			KeyManagementException, ConfigurationException {
		configurationProperties = new Properties();
		configurationProperties.load(getClass().getResourceAsStream(
				"saml.properties"));
		localSAMLTokenFactory = (LocalSamlTokenFactory) LocalSamlTokenFactory
				.getInstance(configurationProperties);
		// Install the all-trusting trust manager
		setIgnoreSSLErrors();
	}*/

	/**
	 * Generate SAML Metadata based on the saml.properties file
	 * @throws Exception
	 */
	public void dumpSAML2Metadata() throws Exception {
		File f = new File("metadata.xml");
		FileOutputStream fos = new FileOutputStream(f);
		System.out.println("SAML2 Metadata");
		new TrustData(samlProperties).createMetadata(fos);
		fos.close();
		String path = f.getAbsolutePath();
		System.out.println("Metadata written to " + path);
	}

	/**
	 * Obtain an access token from a Gateway system
	 * @throws Exception
	 */
	public String getSAMLAssertion() throws Exception {
		String at = null;
		try {
			OAuth2SAML2AccessToken atf = new OAuth2SAML2AccessToken(
					localSAMLTokenFactory);
			// set name to be added in Subject field
			/*properties.remove("saml_nameid");
			properties.setProperty("saml_nameid",
					"prasad.muddappa@katerra.com");*/
			// obtain access token for scope EPM_LANES_DEMO_SRV_0001.
			// multiple scopes are separated by space, e.g.
			// "EPM_LANES_DEMO_SRV_0001 EPM_SCOPE2"
			at = atf.getAccessToken(samlProperties,
					"ZTASKPROCESSING_0002 ZTESTSSO_384_SRV_0001");
			//System.out.println(at);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			dumpTraces();
		}
		dumpTraces();
		return at;
		// usage of an access token
		/*
		 * String url =
		 * "https://vete2012nwmst.fair.sap.corp:50443/sap/opu/odata/IWBEP/RMTSAMPLEFLIGHT_2/BookingCollection"
		 * ; HttpURLConnection con = (HttpURLConnection) new
		 * URL(url).openConnection(); con.addRequestProperty("Authorization",
		 * "Bearer " + at); con.setDoOutput(true); con.setDoInput(true);
		 * con.setRequestProperty("Cookie", ""); con.setRequestMethod("GET");
		 * InputStream is = null; int respCode = con.getResponseCode(); if
		 * (respCode != 200) { is = con.getErrorStream(); } else is =
		 * con.getInputStream(); ByteArrayOutputStream bos = new
		 * ByteArrayOutputStream(); int dataElement; while ((dataElement =
		 * is.read()) != -1) { bos.write(dataElement); } byte[] inData =
		 * bos.toByteArray(); System.out.println(bos);
		 */
	}

	/**
     * 
     */
	private void dumpTraces() {
		List<OAuthTraceData> traceDataList = OAuthTracer.getTraceData();
		for (OAuthTraceData td : traceDataList) {
			if (td.getType() == OAuthTracer.TEXT_TYPE)
				System.out
						.println(td.getDescription() + ":" + td.getDataText());
			if (td.getType() == OAuthTracer.XML_TYPE)
				System.out.println(td.getDescription() + ":"
						+ new String(td.getData()));
			if (td.getType() == OAuthTracer.HTTP_TYPE)
				System.out.println(td.getDescription() + ":"
						+ new String(td.getData()));
			System.out.println();
		}
	}

	private byte[] readData(InputStream is) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int dataElement;
		while ((dataElement = is.read()) != -1) {
			bos.write(dataElement);
		}
		byte[] inData = bos.toByteArray();
		return inData;
	}

	public void setIgnoreSSLErrors() throws NoSuchAlgorithmException,
			KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {

				return null;
			}

			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) {
			}

		} };
		SSLContext sc = SSLContext.getInstance("SSL");

		sc.init(null, trustAllCerts, new java.security.SecureRandom());

		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	};

	
	@PostConstruct
	public void initFactory() throws ConfigurationException {
		localSAMLTokenFactory = (LocalSamlTokenFactory) LocalSamlTokenFactory
				.getInstance(samlProperties);
	}
}
