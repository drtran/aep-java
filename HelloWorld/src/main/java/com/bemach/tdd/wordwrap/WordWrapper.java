package com.bemach.tdd.wordwrap;

import java.util.ArrayList;
import java.util.List;

public class WordWrapper {
    public static String wrap(String in, int rowLength) {
//        return in;

//        if(in.length() < rowLength) {
//            return in;
//        } else {
//            return in.substring(0, rowLength) + "," + in.substring(rowLength, in.length());
//        }

        if(in.length() < rowLength) {
            return in;
        } else {
            StringBuffer sb = new StringBuffer();
            List<String> strings = new ArrayList<String>();
            for (int start = 0; start < in.length(); start += rowLength) {
                sb.append(in.substring(start, Math.min(in.length(), start + rowLength)));
                sb.append("\n");
                strings.add(in.substring(start, Math.min(in.length(), start + rowLength)));
            }
            return sb.substring(0, sb.length()-1).toString();
        }


    }
}
