package ru.sberbank.restfifo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.restfifo.Domain.Message;
import ru.sberbank.restfifo.Repos.MessageRepo;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepo messageRepo;

    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    public Message peek() {
        return messageRepo.findTopByOrderByIdAsc();
    }

    public Message peekMax() {
        return messageRepo.findTopOrderByMsgLength();
    }

    public boolean offer(Message message) {
        messageRepo.save(message);
        return messageRepo.existsByMsg(message.getMsg());
    }

    public Message poll() {
        Message message = messageRepo.findTopByOrderByIdAsc();
        messageRepo.deleteById(message.getId());
        return message;
    }
}
