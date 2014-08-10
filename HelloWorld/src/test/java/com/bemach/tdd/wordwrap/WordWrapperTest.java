package com.bemach.tdd.wordwrap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bemach.tdd.wordwrap.WordWrapper;

public class WordWrapperTest {

    @Test
    public void itReturnsOneLineWhenInputStringIsLessThanRowLength() {

        int rowLength = 50;
        String in = "my name is raj";
        String expected = "my name is raj";

        String out = WordWrapper.wrap(in, rowLength);
        assertEquals(out, expected);
    }

    @Test
    public void itReturnsTwoLinesWhenInputStringIsGreaterThanRowLength() {

        int rowLength = 10;
        String in = "my name is raj";
        String expected = "my name is\n raj";

        String out = WordWrapper.wrap(in, rowLength);
        assertEquals(out, expected);
    }

    @Test
    public void itReturnsThreeLinesWhenInputStringIsGreaterThanRowLength() {

        int rowLength = 10;
        String in = "my name is raj and I am here";
        String expected = "my name is\n raj and I\n am here";

        String out = WordWrapper.wrap(in, rowLength);
        assertEquals(out, expected);
    }
}
