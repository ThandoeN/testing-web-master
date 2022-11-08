package com.example;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GreetingController.class})
@ExtendWith(SpringExtension.class)
class GreetingControllerTest {
    @Autowired
    private GreetingController greetingController;

    @MockBean
    private GreetingService greetingService;

    /**
     * Method under test: {@link GreetingController#greeting()}
     */
    @Test
    void testGreeting() throws Exception {
        when(greetingService.greet()).thenReturn("Greet");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting");
        MockMvcBuilders.standaloneSetup(greetingController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Greet"));
    }

    /**
     * Method under test: {@link GreetingController#greeting()}
     */
    @Test
    void testGreeting2() throws Exception {
        when(greetingService.greet()).thenReturn("Greet");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/greeting");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(greetingController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Greet"));
    }
}

