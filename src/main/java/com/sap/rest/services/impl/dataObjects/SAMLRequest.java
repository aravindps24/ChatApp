package com.sap.rest.services.impl.dataObjects;

public class SAMLRequest {

	private String keyStorePath;
	private String keyStoreType;
	private String keyStoreBinaryData;
	private String keyStoreAlias;
	private String samlProvider;
	private String samlIssuer;
	private String samlSessionAuth;
	private String samlTokenEndpoint;
	private String clientUser;
	private String clientPassword;
	public String getKeyStorePath() {
		return keyStorePath;
	}
	public void setKeyStorePath(String keyStorePath) {
		this.keyStorePath = keyStorePath;
	}
	public String getKeyStoreType() {
		return keyStoreType;
	}
	public void setKeyStoreType(String keyStoreType) {
		this.keyStoreType = keyStoreType;
	}
	public String getKeyStoreBinaryData() {
		return keyStoreBinaryData;
	}
	public void setKeyStoreBinaryData(String keyStoreBinaryData) {
		this.keyStoreBinaryData = keyStoreBinaryData;
	}
	public String getKeyStoreAlias() {
		return keyStoreAlias;
	}
	public void setKeyStoreAlias(String keyStoreAlias) {
		this.keyStoreAlias = keyStoreAlias;
	}
	public String getSamlProvider() {
		return samlProvider;
	}
	public void setSamlProvider(String samlProvider) {
		this.samlProvider = samlProvider;
	}
	public String getSamlIssuer() {
		return samlIssuer;
	}
	public void setSamlIssuer(String samlIssuer) {
		this.samlIssuer = samlIssuer;
	}
	public String getSamlSessionAuth() {
		return samlSessionAuth;
	}
	public void setSamlSessionAuth(String samlSessionAuth) {
		this.samlSessionAuth = samlSessionAuth;
	}
	public String getSamlTokenEndpoint() {
		return samlTokenEndpoint;
	}
	public void setSamlTokenEndpoint(String samlTokenEndpoint) {
		this.samlTokenEndpoint = samlTokenEndpoint;
	}
	public String getClientUser() {
		return clientUser;
	}
	public void setClientUser(String clientUser) {
		this.clientUser = clientUser;
	}
	public String getClientPassword() {
		return clientPassword;
	}
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
	
}
