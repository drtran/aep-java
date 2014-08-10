package com.bemach.tdd.helloworld;

import org.junit.Assert;
import org.junit.Test;

import com.bemach.tdd.helloworld.HelloWorld;

public class HelloWorldTest {

    @Test
    public void itSaysHelloWorld() {
        HelloWorld testSubject = new HelloWorld();
        Assert.assertEquals("Hello World", testSubject.getMessage());
    }
}
