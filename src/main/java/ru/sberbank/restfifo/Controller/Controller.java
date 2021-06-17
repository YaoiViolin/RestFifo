package ru.sberbank.restfifo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.restfifo.Domain.Message;
import ru.sberbank.restfifo.Service.MessageService;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    MessageService messageService;

    @GetMapping("/getall")
    @ResponseBody
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/")
    @ResponseBody
    public Message getMessage(@RequestParam (name = "action", required = true) String action ) {
        switch (action) {
            case "peek":
                return messageService.peek();
            case "peekmax":
                return messageService.peekMax();
            case "poll":
                return messageService.poll();
            default:
                return null;
        }
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<Message> offerMessage(@RequestBody Message message) {
        if (messageService.offer(message))
            return ResponseEntity.ok(message);
        else return null;
    }
}
