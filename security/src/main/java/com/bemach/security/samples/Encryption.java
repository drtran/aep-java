package com.bemach.security.samples;

public interface Encryption {
	public byte[] getKey(String keyStore, String password, String aliasName) throws Exception;
	public String encrypt(byte[] key, String clearText) throws Exception ;
	public String decrypt(byte[] key, String cipherText)throws Exception ;
	public String encrypt(String keyStore, String password,String aliasName,String clearText) throws Exception ;
	public String decrypt(String keyStore, String password,String aliasName,String cipherText)throws Exception ;	
}
