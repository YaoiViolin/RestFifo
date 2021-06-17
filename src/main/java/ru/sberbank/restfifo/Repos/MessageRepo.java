package ru.sberbank.restfifo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.restfifo.Domain.Message;

public interface MessageRepo extends JpaRepository<Message, Integer> {
    Message findTopByOrderByIdAsc();

    @Query(value = "select * from messages m order by length(m.msg) desc limit 1", nativeQuery = true)
    Message findTopOrderByMsgLength();

    @Transactional
    void deleteById(int id);

    boolean existsByMsg (String msg);
}
