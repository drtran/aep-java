package com.bemach.tdd.stringset;

import java.util.HashSet;

public class StringSet {

    HashSet<String> set = new HashSet<String>();

    public void add(String s) {
        set.add(s);
    }

    public int size() {
        return set.size();  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean contains(String s) {
        return set.contains(s);  //To change body of created methods use File | Settings | File Templates.
    }
}
