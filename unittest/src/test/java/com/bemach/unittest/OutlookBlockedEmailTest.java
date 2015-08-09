package com.bemach.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OutlookBlockedEmailTest {
	private URL fileUrl = getClass().getResource("/");
	private String file = getClass().getResource("/outlook_blocked.txt").getFile();
	private OutlookBlockedEMail blockEmail;
	
	@Before
	public void setUp() throws IOException {
		blockEmail = new OutlookBlockedEMail();
		blockEmail.split(file);
		
	}
	
	@Test
	public void shouldReadFile() {
		assertEquals ("", 11, blockEmail.size());
	}
	
	@Test
	public void shouldSplitNameAndDomain() throws IOException {
		List<String> names = blockEmail.getNames();
		List<String> domains = blockEmail.getDomains();
		assertEquals("", names.size(), domains.size());
	}
	
	@Test
	public void shouldGetSplitCorrectly() throws IOException {
		List<String> names = blockEmail.getNames();
		List<String> domains = blockEmail.getDomains();
		assertEquals("", "businessphonesystem", names.get(5));
		assertEquals("", "itgonline.com", domains.get(3));
	}
	
	@Test
	public void shouldGenerateDomainBlockedFile() throws IOException {
		String path = fileUrl.getPath();
		String newFile = path + File.separator + "new_blocked_email.txt";
		blockEmail.createBlockFile(newFile);
		assertTrue("", new File(newFile).exists());
	}
}
