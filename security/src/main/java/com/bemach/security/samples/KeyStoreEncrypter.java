package com.bemach.security.samples;

public interface KeyStoreEncrypter {

	public String getAliasName();

	public String getKeyStore();

	public void setKeyStore(String keyStore);

	public String getPassphrase();

	public void setPassphrase(String passphrase);

	public String passphrase();

	public void setAliasName(String aliasName);

	public void setConfigFile(String configFile);

	public String getSecretFile();

	public void setSecretFile(String secretFile);

	/*
	 * (non-Javadoc)
	 *
	 */
	public String decrypt(byte[] keyValue, String encryptedText64) throws Exception;

	public String encrypt(byte[] keyValue, String clearTextStr) throws Exception;

	public byte[] getKey(String keyStore, String passphrase, String aliasName) throws Exception;

	public String decrypt(String keyStore, String passphrase, String aliasName, String cipherText) throws Exception;

	public String encrypt(String keyStore, String passphrase, String aliasName, String clearText) throws Exception;

	public String decrypt(String cipherText) throws Exception;

	public String encrypt(String clearText) throws Exception;

}