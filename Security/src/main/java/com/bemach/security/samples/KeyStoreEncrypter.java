package com.bemach.security.samples;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

public class KeyStoreEncrypter implements Encryption {
	private String keyStore;
	private String passphrase;
	private String aliasName;

	public String getAliasName() {
		return aliasName;
	}

	private String configFile;
	private String secretFile;

	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final String RSA_ENCRYPTION_SCHEME="RSA";
	private static final String UNICODE_FORMAT = "UTF8";

	public String getKeyStore() {
		return keyStore;
	}

	public void setKeyStore(String keyStore) {
		this.keyStore = keyStore;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String passphrase() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public String getSecretFile() {
		return secretFile;
	}

	public void setSecretFile(String secretFile) {
		this.secretFile = secretFile;
	}

	/**
	 * 
	 */
	public KeyStoreEncrypter() {
		super();
		KeystoreInformation ki = KeystoreInformation.getInstance();
		setConfigFile(ki.getConfigFile());
		setAliasName(ki.getAlias());
		setKeyStore(ki.getKeystore());
		setSecretFile(ki.getSecretFile());
	}

	/**
	 * @param bytes
	 * @return
	 */
	private static String bytes2String(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see mil.af.dcapes.common.security.IEncryption#decrypt(byte[],
	 * java.lang.String)
	 */
	public String decrypt(byte[] keyValue, String encryptedText64) throws Exception {
		try {
			DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
			SecretKey key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
			Cipher decrypter = Cipher.getInstance("DESede");
			decrypter.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptedText = Base64.decodeBase64(encryptedText64.getBytes()); // base64decoder.decodeBuffer(encryptedText);
			byte[] decryptedText = decrypter.doFinal(encryptedText);
			return bytes2String(decryptedText);
		} catch (Exception e) {
			throw e;
		}

	}

	public String encrypt(byte[] keyValue, String clearTextStr) throws Exception {
		try {
			DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
			SecretKey key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
			Cipher encrypter = Cipher.getInstance("DESede");
			encrypter.init(Cipher.ENCRYPT_MODE, key);

			byte[] clearText = clearTextStr.getBytes(UNICODE_FORMAT);
			byte[] cipherText = encrypter.doFinal(clearText);
			return new String(Base64.encodeBase64(cipherText));// base64encoder.encode(ciphertext);
		} catch (Exception e) {
			throw e;
		}
	}

	public static byte[] encrypt(byte[] keyValue, byte[] clearText) throws Exception {
		try {
			DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
			SecretKey key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
			Cipher encrypter = Cipher.getInstance("DESede");
			encrypter.init(Cipher.ENCRYPT_MODE, key);
			return encrypter.doFinal(clearText);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static byte[] decrypt(byte[] keyValue, byte[] encryptedText)
			throws Exception {
		try {
			DESedeKeySpec keySpec = new DESedeKeySpec(keyValue);
			SecretKey key = SecretKeyFactory.getInstance("DESede").generateSecret(keySpec);
			Cipher decrypter = Cipher.getInstance("DESede");
			decrypter.init(Cipher.DECRYPT_MODE, key);
			return decrypter.doFinal(encryptedText);
		} catch (Exception e) {
			throw e;
		}
	}

	public byte[] getKey(String keyStore, String passphrase, String aliasName)
			throws Exception {
		byte[] encKey = null;
		String errorMsg = "Private Key is unavailable !";
		try {
			File file = new File(keyStore);
			FileInputStream is = new FileInputStream(file);
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			keystore.load(is, passphrase.toCharArray());
			Key key = keystore.getKey(aliasName, passphrase.toCharArray());
			if (!(key instanceof PrivateKey)) {
				throw new Exception(errorMsg);
			}
			encKey = ((PrivateKey) key).getEncoded();

		} catch (Exception e) {
			throw e;
		}
		return encKey;
	}

	public String decrypt(String keyStore, String passphrase, String aliasName,
			String cipherText) throws Exception {
		byte[] encKey = getKey(keyStore, passphrase, aliasName);
		return decrypt(encKey, cipherText);
	}

	public String encrypt(String keyStore, String passphrase, String aliasName,
			String clearText) throws Exception {
		byte[] encKey = getKey(keyStore, passphrase, aliasName);
		return encrypt(encKey, clearText);
	}

	public String decrypt(String cipherText) throws Exception {
		String passphrase = CredentialsFileUtil.getPassword(getAliasName(),
				getConfigFile(), getSecretFile());
		byte[] encKey = getKey(getKeyStore(), passphrase, getAliasName());
		return decrypt(encKey, cipherText);
	}

	public String encrypt(String clearText) throws Exception {
		String passphrase = CredentialsFileUtil.getPassword(getAliasName(),
				getConfigFile(), getSecretFile());
		byte[] encKey = getKey(getKeyStore(), passphrase, getAliasName());
		return encrypt(encKey, clearText);
	}
	
	public static String rsaDecrypt(PrivateKey key, String encryptedText)
			throws Exception {
		try {
			Cipher decrypter = Cipher.getInstance(RSA_ENCRYPTION_SCHEME);
			decrypter.init(Cipher.DECRYPT_MODE, key);
			byte[] encText = Base64.decodeBase64(encryptedText.getBytes());
			byte[] ciphertext = decrypter.doFinal(encText);
			return bytes2String(ciphertext);

		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * Asymmetric decryption using RSA algorithm.
	 */
	public static String rsaEncrypt(PublicKey key, String clearText) throws Exception {
		try {
			Cipher encrypter = Cipher.getInstance("RSA");
			encrypter.init(Cipher.ENCRYPT_MODE, key);

			byte[] cleartext = clearText.getBytes(UNICODE_FORMAT);
			byte[] ciphertext = encrypter.doFinal(cleartext);
			return new String(Base64.encodeBase64(ciphertext));// base64encoder.encode(ciphertext);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static byte[] rsaDecrypt(PrivateKey key, byte[] encryptedText) throws Exception {
		try {
			Cipher decrypter = Cipher.getInstance(RSA_ENCRYPTION_SCHEME);
			decrypter.init(Cipher.DECRYPT_MODE, key);
			return decrypter.doFinal(encryptedText);
		} catch (Exception e) {
			throw e;
		}
	}

	public static byte[] rsaEncrypt(PublicKey key, byte[] clearText) throws Exception {
		try {
			Cipher encrypter = Cipher.getInstance("RSA");
			encrypter.init(Cipher.ENCRYPT_MODE, key);
			return encrypter.doFinal(clearText);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static byte[] dsaSign(InputStream is, PrivateKey key) throws Exception {
	    Signature sig = Signature.getInstance("DSA");
	    sig.initSign(key);
	 
		byte[] dataBytes = new byte[1024];
		int nread = is.read(dataBytes);
		while (nread > 0) {
			sig.update(dataBytes, 0, nread);
			nread = is.read(dataBytes);
		}
		is.close();
		return sig.sign();
	}

	public static boolean dsaVerify(InputStream is, PublicKey key, byte[] sigbytes) throws Exception {
	    Signature sig = Signature.getInstance("DSA");
	    sig.initVerify(key);

		byte[] dataBytes = new byte[1024];
		int nread = is.read(dataBytes);
		
		while (nread > 0) {
			sig.update(dataBytes, 0, nread);
			nread = is.read(dataBytes);
		}
		is.close();
		return sig.verify(sigbytes);
	}
}
