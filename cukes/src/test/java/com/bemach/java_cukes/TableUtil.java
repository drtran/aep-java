package com.bemach.java_cukes;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TableUtil {

	public List<Hashtable<String, String>> symbolicHash(List<List<String>> table) {
		List<String> keys = table.get(0);
		List<Hashtable<String,String>> symbolicHash = new ArrayList<Hashtable<String,String>> ();
		
		for (int i = 1; i < table.size(); i++) {
			List<String> entries = table.get(i);
			Hashtable<String,String> hash = new Hashtable<String,String>();
			for (int j = 0; j < keys.size(); j++) {
				String key = keys.get(j).toLowerCase().replace(' ', '_');
				hash.put(key, entries.get(j));
			}
			symbolicHash.add(hash);
		}
		return symbolicHash;
	}

}
