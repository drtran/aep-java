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

public class KeystoreMgrImpl implements KeystoreManager {

	private String keystoreFile;
	private String password;

	public KeystoreMgrImpl(String keystoreFile, String password) {
		this.keystoreFile = keystoreFile;
		this.password = password;
	}

	@Override
	public List<String> keyAliases() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		keystore.load(new FileInputStream(new File(keystoreFile)), password.toCharArray());
		return Collections.list(keystore.aliases());
	}

}
