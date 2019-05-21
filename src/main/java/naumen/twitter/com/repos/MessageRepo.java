package naumen.twitter.com.repos;

import naumen.twitter.com.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);

    List<Message> findByAuthor_Id(Long id);
}