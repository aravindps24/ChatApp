package com.sap.security.oa2;

import com.sap.config.SAMLProperties;


public interface SamlTokenFactory {

    public abstract String getSamlAssertion(SAMLProperties samlProperties) throws SAMLException;

}