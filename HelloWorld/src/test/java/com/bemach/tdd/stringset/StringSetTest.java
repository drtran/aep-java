package com.bemach.tdd.stringset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bemach.tdd.stringset.StringSet;

public class StringSetTest {

    StringSet testSubject;

    @Before
    public void setup() {
        testSubject = new StringSet();
    }

    @Test
    public void itAddsGivenStringToEmptySet() {

        testSubject.add("one");
        assertEquals(testSubject.size(), 1);
        assertTrue(testSubject.contains("one"));
    }

    @Test
    public void itAddsMultipleStringsToSet() {

        testSubject.add("one");
        testSubject.add("two");
        assertEquals(testSubject.size(), 2);
        assertTrue(testSubject.contains("one"));
        assertTrue(testSubject.contains("two"));
    }

    @Test
    public void itDoesNotAddTheSameStringToSet() {

        testSubject.add("one");
        testSubject.add("one");
        assertEquals(testSubject.size(), 1);
    }
}
