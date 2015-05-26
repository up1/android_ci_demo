package demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    @Test public void
    my_first_test() {
        Hello hello = new Hello();
        assertEquals("Hello", hello.say());
    }

}
