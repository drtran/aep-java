package com.bemach.security.samples;

public interface KeyStoreEncrypter {

	String getAliasName();

	String getKeyStore();

	void setKeyStore(String keyStore);

	String getPassphrase();

	void setPassphrase(String passphrase);

	String passphrase();

	void setAliasName(String aliasName);

	String getConfigFile();

	void setConfigFile(String configFile);

	String getSecretFile();

	void setSecretFile(String secretFile);

	/*
	 * (non-Javadoc)
	 *
	 */
	String decrypt(byte[] keyValue, String encryptedText64) throws Exception;

	String encrypt(byte[] keyValue, String clearTextStr) throws Exception;

	byte[] getKey(String keyStore, String passphrase, String aliasName) throws Exception;

	String decrypt(String keyStore, String passphrase, String aliasName, String cipherText) throws Exception;

	String encrypt(String keyStore, String passphrase, String aliasName, String clearText) throws Exception;

	String decrypt(String cipherText) throws Exception;

	String encrypt(String clearText) throws Exception;

}