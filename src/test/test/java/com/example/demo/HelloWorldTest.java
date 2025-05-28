package com.example.demo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public void testGreet() {
        HelloWorld hw = new HelloWorld();
        assertEquals("Hello, DevOps", hw.greet("DevOps"));
    }
}

