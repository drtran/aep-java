package com.bemach.security.samples;

import java.io.File;
import java.net.URL;

public class SpringConfigEncrypter extends KeyStoreEncrypter {
	private String keyStoreDir="";
	
	public SpringConfigEncrypter() {
		super();	
		
		URL keystoreUrl = getClass().getClassLoader().getResource("keystore");
		if (keystoreUrl == null) {
			return;
		}
		keyStoreDir=keystoreUrl.getPath()+File.separator;				
	}

	public SpringConfigEncrypter(String keyStore,String aliasName,String configFile, String secretFile){
		this();
		super.setAliasName(aliasName);
		this.setSecretFile(secretFile);
		this.setKeyStore(keyStore);
		this.setConfigFile(configFile);
	}
	public void setKeyStore(String keyStore) {
		String absKeystore=keyStoreDir+keyStore;
		super.setKeyStore(absKeystore);
	}

	public void setSecretFile(String secretFile) {
		String absSecretFile=keyStoreDir+secretFile;
		super.setSecretFile(absSecretFile);
	}
	
	public void setConfigFile(String configFile){
		String absConfigFile=keyStoreDir+configFile;
		super.setConfigFile(absConfigFile);
	}


}
