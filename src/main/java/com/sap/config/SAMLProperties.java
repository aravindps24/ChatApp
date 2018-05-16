package com.sap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SAMLProperties {

	@Value("${ks_resource}")
	private String keyStorePath;
	@Value("${ks_type}")
	private String keyStoreType;
	@Value("${ks_pwd}")
	private String keyStorePassword;
	@Value("${ks_binary}")
	private String keyStoreBinaryData;
	@Value("${ks_alias}")
	private String keyStoreAlias;
	@Value("${saml_audience_restriction}")
	private String samlProvider;
	@Value("${saml_issuer}")
	private String samlIssuer;
	@Value("${saml_session_authentication}")
	private String samlSessionAuth;
	@Value("${oa2_token_endpoint}")
	private String samlTokenEndpoint;
	@Value("${oa2_client_id}")
	private String clientUser;
	@Value("${oa2_client_secret}")
	private String clientPassword;
	@Value("${saml_nameid}")
	private String samlNameId;
	@Value("${saml_nameid_format}")
	private String samlNameIdFormat;
	@Value("${saml_session_authentication}")
	private String samlSessionAuthentication;
	
	public String getKeyStorePath() {
		return keyStorePath;
	}
	public String getKeyStoreType() {
		return keyStoreType;
	}
	public String getKeyStoreBinaryData() {
		return keyStoreBinaryData;
	}
	public String getKeyStoreAlias() {
		return keyStoreAlias;
	}
	public String getSamlProvider() {
		return samlProvider;
	}
	public String getSamlIssuer() {
		return samlIssuer;
	}
	public String getSamlSessionAuth() {
		return samlSessionAuth;
	}
	public String getSamlTokenEndpoint() {
		return samlTokenEndpoint;
	}
	public String getClientUser() {
		return clientUser;
	}
	public String getClientPassword() {
		return clientPassword;
	}
	public String getKeyStorePassword() {
		return keyStorePassword;
	}
	public String getSamlNameId() {
		return samlNameId;
	}
	public String getSamlNameIdFormat() {
		return samlNameIdFormat;
	}
	public String getSamlSessionAuthentication() {
		return samlSessionAuthentication;
	}
	
}

