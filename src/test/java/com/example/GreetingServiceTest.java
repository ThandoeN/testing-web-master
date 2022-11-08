package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {GreetingService.class})
@ExtendWith(SpringExtension.class)
class GreetingServiceTest {
    @Autowired
    private GreetingService greetingService;

    /**
     * Method under test: {@link GreetingService#greet()}
     */
    @Test
    void testGreet() {
        assertEquals("Hello, Mock", greetingService.greet());
    }
}

