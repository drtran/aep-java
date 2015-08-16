package com.bemach.mocking.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.List;

import com.bemach.mocking.contracts.KeystoreManager;

public class KeystoreManagerImpl implements KeystoreManager {

	private String keystoreFile;
	private String password;
	private KeyStore keystore;

	public KeystoreManagerImpl (String keystoreFile, String password) throws KeyStoreException {
		this.keystoreFile = keystoreFile;
		this.password = password;
		keystore = KeyStore.getInstance(KeyStore.getDefaultType());
	}

	public List<String> keyAliases() throws NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, KeyStoreException {
		keystore.load(new FileInputStream(new File(keystoreFile)), password.toCharArray());
		return Collections.list(keystore.aliases());
	}

}
