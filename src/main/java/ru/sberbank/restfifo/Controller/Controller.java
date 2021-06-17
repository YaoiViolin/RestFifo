package ru.sberbank.restfifo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.restfifo.Domain.Message;
import ru.sberbank.restfifo.Repos.MessageRepo;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    MessageRepo messageRepo;

    @GetMapping("/getall")
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }


}
