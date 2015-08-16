# mockito's note:
Kiet T. Tran

_14 August 2015_

## Activities:

- _FlowerTest1.java_: A simple mocking with BDD style.

- _FlowerTest2.java_: A simple mocking with regular style.

- _KeystoreManagerImplTest1.java_: Simple JUnit without mocking.

- _KeystoreManagerImplTest2.java_: Simple Junit test with mocking KeyStore class.
I include these annotation in the begining of the JUnit class because I am mocking this static method _Keystore.getInstance(String)_:

		@RunWith(PowerMockRunner.class)
		@PrepareForTest(value={KeyStore.class, KeystoreManagerImpl.class})

When use PowerMockito, I includes all class that are involved in the @PrepareForTest annotation. That includes the test that I am testing. In this case the _KeystoreManagerImpl_ class. Because the testing class actually creates a FileInputStream, I had to make sure that a file exists. I could have mock that class too but decided to use a 'dummy.txt' file instead. This is so that the open of the file succeeds.

The tests are identical of that the KeystoreManagerImplTest1 class but fakes data is being used instead.

- _KeystoreManagerImplTest3.java_: Introducing mocking File and FileInputStream using whenNew method.

		@RunWith(PowerMockRunner.class)
		@PrepareForTest(value={KeyStore.class, File.class, KeystoreManagerImpl.class})

		@Mock
		private File mockFile;
		
		@Mock
		private FileInputStream mockFileInputStream;
	
		PowerMockito.whenNew(File.class).withArguments(keystoreFile).thenReturn(mockFile);
		PowerMockito.whenNew(FileInputStream.class).withArguments(mockFile).thenReturn(mockFileInputStream);

- _KeystoreManagerImplTest4.java_: Rearrange import for readability.	

## Additional information:

From Oracle WebLogic install. We use this for testing only.

		Keystore: cacerts
		Password: changeit
		
		Keystore: DemoTrust.jks
		Password: DemoTrustKeyStorePassPhrase
