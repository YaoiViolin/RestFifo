package ru.sberbank.restfifo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.restfifo.Domain.Message;

public interface MessageRepo extends JpaRepository<Message, Integer> {
}
