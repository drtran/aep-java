package com.bemach.mocking.contracts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

public interface KeystoreManager {

	List<String> keyAliases() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException;

}
