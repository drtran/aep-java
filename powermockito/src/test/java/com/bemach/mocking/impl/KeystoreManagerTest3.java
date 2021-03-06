package com.bemach.mocking.impl;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bemach.mocking.contracts.KeystoreManager;

/**
 * Mocking -- Using PowerMockito
 * use whenNew ()
 * 
 * @author ktran
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value={KeyStore.class, File.class, KeystoreManagerImpl.class})
public class KeystoreManagerTest3 {
	private KeystoreManager target = null;
	
	@Mock
	private KeyStore mockKeystore;
	
	@Mock
	private File mockFile;
	
	@Mock
	private FileInputStream mockFileInputStream;
	
	private String keystoreFile = "";
	private String password = "";
	private List<String> mockAliases = Arrays.asList(new String[] 
			{"wlsdemobcca1024", "thawtepersonalfreemailca", "wlsdemobcca1024", "wlscertgenca", "verisignserverca"});

	@Before
	public void setUp() throws Exception {
		PowerMockito.mockStatic(KeyStore.class);
		PowerMockito
		.when(KeyStore.getInstance(Matchers.any(String.class)))
		.thenReturn(mockKeystore);
		PowerMockito
		.doNothing()
		.when(mockKeystore).load(Matchers.any(FileInputStream.class), Matchers.any(char[].class));
		PowerMockito
		.when(mockKeystore.aliases())
		.thenReturn(Collections.enumeration(mockAliases));
		//
		// Introduce mocking File and FileInputStream classes. Make sure to include these classes
		// in @PrepareForTest annotation's value parameter.
		//
		PowerMockito
		.whenNew(File.class).withArguments(keystoreFile)
		.thenReturn(mockFile);
		PowerMockito
		.whenNew(FileInputStream.class).withArguments(mockFile)
		.thenReturn(mockFileInputStream);
		
		target = new KeystoreManagerImpl(keystoreFile, password);
	}
	
	@Test
	public void shouldCreateInstance() {
		assertNotNull(target);
	}
	
	@Test
	public void shouldGetListOfKeyAliases() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		List<String> keyAliases = target.keyAliases();
		
		Mockito.verify(mockKeystore).load(Matchers.any(FileInputStream.class), Matchers.any(char[].class));
		Mockito.verify(mockKeystore).aliases();
		Assert.assertThat(keyAliases, CoreMatchers.is(not(empty())));
	}
	
	@Test
	public void shouldHaveOneAliasInList() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		List<String> actualAliases = target.keyAliases();
		
		Mockito.verify(mockKeystore).load(Matchers.any(FileInputStream.class), Matchers.any(char[].class));
		Mockito.verify(mockKeystore).aliases();
		Assert.assertThat(actualAliases, CoreMatchers.hasItem("verisignserverca"));
	}
	
	@Test
	public void shouldHaveSeveralAliasesInList() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		List<String> actualAliases = target.keyAliases();
		String[] expectedAliases = {"thawtepersonalfreemailca", "wlsdemobcca1024", "wlscertgenca"};
		
		Mockito.verify(mockKeystore).load(Matchers.any(FileInputStream.class), Matchers.any(char[].class));
		Mockito.verify(mockKeystore).aliases();
		Assert.assertThat(actualAliases, CoreMatchers.hasItems(expectedAliases));
	}

}
