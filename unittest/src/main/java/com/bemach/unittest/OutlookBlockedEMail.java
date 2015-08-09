package com.bemach.unittest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class OutlookBlockedEMail {

	private int count;
	private List<String> names;
	private List<String> domains;
	private Hashtable<String,String> existDomains = new Hashtable<String,String>();

	public void split(String blockedFile) throws IOException {
		FileReader fr = new FileReader(blockedFile) ;
		BufferedReader br = new BufferedReader(fr);
		count = 0;
		names = new ArrayList<String>();
		domains = new ArrayList<String>();
		
		for (;;) {
			String line = br.readLine();
			
			if (line == null) { break; }
			
			String[] tokens = line.split("@");
			
			if (tokens.length != 2) { continue; }
			if (existDomains.get(tokens[1]) != null) { continue; }
			existDomains.put(tokens[1], tokens[1]);
			
			names.add(tokens[0]);
			domains.add(tokens[1]);
			count++;
		}
		
		br.close();
	}

	public List<String> getNames() {
		return names;
	}

	public List<String> getDomains() {
		return domains;
	}

	public Object size() {
		
		return count;
	}

	public void createBlockFile(String newFile) throws IOException {
		File file = new File(newFile);
		
		if (file.exists()) { file.delete(); }
		file.createNewFile();
		
		Collections.sort(domains);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
		for (String domain: domains) {
			bw.write('@');
			bw.write(domain);
			bw.write('\n');
		}
		
		bw.close();
	}

	public static void main (String[] args) throws IOException {
		OutlookBlockedEMail block = new OutlookBlockedEMail();
		URL fileUrl = block.getClass().getResource("/");
		String file = block.getClass().getResource("/outlook_blocked.txt").getFile();
		String path = fileUrl.getPath();
		String newFile = path + File.separator + "new_blocked_email.txt";
		
		block.split(file);
		block.createBlockFile(newFile);
	}
}
