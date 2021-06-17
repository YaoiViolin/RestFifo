package ru.sberbank.restfifo.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGettingAllMessages() throws Exception {
        mockMvc.perform(get("/getall")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"msg\":\"rita\"")));
    }

    @Test
    public void testPeek() throws Exception {
        mockMvc.perform(get("/?action=peek")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"msg\":\"oh, hi it is me, the first message\"")));
    }

    @Test
    public void testPeekMax() throws Exception {
        mockMvc.perform(get("/?action=peekmax")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"msg\":\"hello, darkness, my old friend. i've come to talk to you again\"")));
    }

    @Test
    public void testPoll() throws Exception {
        mockMvc.perform(get("/?action=poll")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"msg\":\"oh, hi it is me, the first message\"")));
    }
}
