package com.bemach.mocking.impl;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bemach.mocking.contracts.KeystoreManager;

/**
 * No Mocking -- Straight JUnit tests.
 * 
 * @author ktran
 *
 */
public class KeystoreManagerTest1 {
	private KeystoreManager keystoreMgr;
	private String keystoreFile = getClass().getResource("/cacerts").getFile();;
	private String password = "changeit";

	@Before
	public void setUp() throws KeyStoreException {
		keystoreMgr = new KeystoreManagerImpl(keystoreFile, password);
	}
	
	@Test
	public void shouldCreateInstance() {
		assertNotNull(keystoreMgr);
	}
	
	@Test
	public void shouldGetListOfKeyAliases() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		List<String> keyAliases = keystoreMgr.keyAliases();
		Assert.assertThat(keyAliases, CoreMatchers.is(not(empty())));
	}
	
	@Test
	public void shouldHaveOneAliasInList() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		List<String> actualAliases = keystoreMgr.keyAliases();
		Assert.assertThat(actualAliases, CoreMatchers.hasItem("verisignserverca"));
	}
	
	@Test
	public void shouldHaveSeveralAliasesInList() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		List<String> actualAliases = keystoreMgr.keyAliases();
		String[] expectedAliases = {"thawtepersonalfreemailca", "wlsdemobcca1024", "wlscertgenca"};
		Assert.assertThat(actualAliases, CoreMatchers.hasItems(expectedAliases));
	}

}
