package ru.sberbank.restfifo.Controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sberbank.restfifo.Domain.Message;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ControllerTest {

    @Autowired
    Controller controller;

    @Test
    void getAllMessages() {
        List<Message> messageList = controller.getAllMessages();

        assertNotNull(messageList);
        assertTrue(messageList.size() > 0);
    }

    @Test
    void peekMessage() {
        Message messagePeekActual = controller.getMessage("peek");
        Message messagePeekExpected = new Message();
        messagePeekExpected.setId(1);
        messagePeekExpected.setMsg("oh, hi it is me, the first message");

        assertEquals(messagePeekExpected, messagePeekActual);
    }


    @Test
    void peekMaxMessage(){
        Message messagePeekMaxActual = controller.getMessage("peekmax");
        Message messagePeekMaxExpected = new Message();
        messagePeekMaxExpected.setId(4);
        messagePeekMaxExpected.setMsg("hello, darkness, my old friend. i've come to talk to you again");

        assertEquals(messagePeekMaxExpected, messagePeekMaxActual);
    }


    @Test
    void pollMessage() {
        Message messagePollActual = controller.getMessage("poll");
        Message messagePollExpected = new Message();
        messagePollExpected.setId(1);
        messagePollExpected.setMsg("oh, hi it is me, the first message");

        assertEquals(messagePollExpected, messagePollActual);
    }
}