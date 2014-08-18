package com.bemach.security.samples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class KeystoreInformation implements Serializable {
	private static final long serialVersionUID = 1L;
	private String configFile="configFile.prop";
	private String secretFile="secretFile.prop";
	private String keystore="my.keystore";
	private String alias="myalias";
	private static KeystoreInformation ki = null;
	protected Hashtable<String,String> secProps = new Hashtable<String,String>();

	public static KeystoreInformation getInstance() {
		if (ki == null) 
			ki = new KeystoreInformation();
		return ki;
	}
	
	protected KeystoreInformation () {
		StringBuffer ksDir = new StringBuffer(System.getProperty("dcapes.config.directory"));
		ksDir.append(File.separatorChar).append("keystore").append(File.separatorChar);
		configFile = ksDir.toString() + configFile;
		File f = new File(configFile);
		if (!f.exists()) {
			return;
		}
		
		secretFile = ksDir.toString() + secretFile;
		f = new File(secretFile);
		if (!f.exists()) {
			return;
		}
		
		String prop = System.getProperty("dcapes.keystore");
		if (prop != null && prop.trim().length() > 0)
			keystore = prop;
		keystore = ksDir.toString() + keystore;
		f = new File(keystore);
		
		if (!f.exists()) {
			return;
		}
		
		prop = System.getProperty("dcapes.keyalias");
		if (prop != null && prop.trim().length() > 0)
			alias = prop;
		gatherKSRelatedInfo();
	}

	protected void gatherKSRelatedInfo() {
		File file = new File(keystore);
		FileInputStream is;
		try {
			is = new FileInputStream(file);
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			keystore.load(is, getPassphrase().toCharArray());
			Certificate[] certChain = keystore.getCertificateChain(alias);
			Enumeration<String> aliases = keystore.aliases();
			
			StringBuffer sb = new StringBuffer();
			for (Certificate cert: certChain) {
				sb.append(cert.getPublicKey().getFormat()).append("\n");
			}
			secProps.put("keychain-for-"+alias, sb.toString());
			secProps.put("keystore-size", Integer.toString(keystore.size()));
			ArrayList<String> certList = new ArrayList<String>();
			while (aliases.hasMoreElements()) {
				String alias = aliases.nextElement();
				certList.add(getCert4Display(keystore, alias));
			}
			sb = new StringBuffer();
			for (String certStr: certList) {
				sb.append(certStr);
			}
			secProps.put("aliases", sb.toString());
		} catch (FileNotFoundException e) {
		} catch (KeyStoreException e) {
		} catch (CertificateException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (IOException e) {
		} 
	}

	protected String getCert4Display(KeyStore keystore, String certAlias) {
		try {
			Certificate cert = keystore.getCertificate(certAlias);
			
			StringBuffer sb = new StringBuffer("Alias name: ").append(certAlias).append('\n');
			sb.append("Creation date: ").append(keystore.getCreationDate(certAlias)).append("\n");
			sb.append("Entry type: ");
			if (cert.toString().indexOf("CA:true") >= 0)
				sb.append("trustedCertEntry\n");
			else
				sb.append("keyEntry\n");
			Certificate[] certChain = keystore.getCertificateChain(certAlias);
			if (certChain != null) {
				sb.append(String.format("Certificate chain length:%d\n",certChain.length));
				int certNo = 1;
				for (Certificate certEntry: certChain) {
					sb.append(String.format("Certificate[%d]:\n", certNo++));
					sb.append(certDetail(certEntry.toString()));
				}
				sb.append(">>>>>>>>>>>>>>>>>>>>>>>\n\n");
			}
			sb.append('\n').append(certDetail(cert.toString()));
			return sb.toString();
		} catch (KeyStoreException e) {
			return null;
		}
	}

	/**
	 * Get the detail of the certificate.
	 * @param certDetail
	 * @return
	 */
	protected String certDetail(String certDetail) {
		BufferedReader br = new BufferedReader(new StringReader(certDetail));
		StringBuffer sb = new StringBuffer();
		try {
			for (;;) {
				String line = br.readLine();
				if (line == null) 
					break;
				line = line.trim();
				if (line.indexOf("Subject:") == 0)
					sb.append("Owner: ").append(line.substring(8).trim()).append('\n');
				else if (line.indexOf("Issuer:") == 0) {
					int idx = sb.indexOf("Serial number");
					if (idx >= 0)
						sb.insert(idx, line+"\n");
					else
						sb.append(line).append('\n');
				}
				else if (line.indexOf("Validity:") == 0) {
					sb.append(line).append('\n');
					sb.deleteCharAt(sb.length()-1);
					sb.append(br.readLine().trim()).append('\n');
				} else if (line.indexOf("SerialNumber") >= 0) {
					int idx = line.lastIndexOf(' ');
					sb.append("Serial number:").append(line.substring(idx));
					sb.deleteCharAt(sb.length()-1).append('\n');
				}
			}
			return sb.toString();
		} catch (IOException e) {
			return null;
		}
	}
	
	public Vector<String> getKeys (){
		Vector<String> sortedList =  new Vector<String>(secProps.keySet());
		Collections.sort(sortedList);
		return sortedList;
	}

	public String getValue(String key) {
		return (String)secProps.get(key);
	}
	
	public String getPassphrase() {
		return CredentialsFileUtil.getPassword(alias, configFile, secretFile);
	}
	
	public String getConfigFile() {
		return configFile;
	}

	public String getSecretFile() {
		return secretFile;
	}

	public String getKeystore() {
		return keystore;
	}

	public String getAlias() {
		return alias;
	}
	
	public static KeyPair getKeyPair(KeyStore keystore, String keyalias, String psw) {
		try { 
			Key key = keystore.getKey(keyalias, psw.toCharArray()); 
			if (key instanceof PrivateKey) {
				Certificate cert = keystore.getCertificate(keyalias); 
				PublicKey publicKey = cert.getPublicKey(); 
				return new KeyPair(publicKey, (PrivateKey)key); 
			} 
		} catch (UnrecoverableKeyException e) { 
		} catch (NoSuchAlgorithmException e) { 
		} catch (KeyStoreException e) { 
		} 
		return null; 
	}
}
