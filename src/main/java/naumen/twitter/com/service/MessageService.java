package naumen.twitter.com.service;

import naumen.twitter.com.domain.Message;
import naumen.twitter.com.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    public List<Message> findAll()
    {
        return messageRepo.findAll();
    }
    public void deleteAll()
    {
        messageRepo.deleteAll();
    }
    public List<Message> findByTag(String tag)
    {
        return  messageRepo.findByTag(tag);
    }

    public List<Message> findByAuthor_Id(Long id){
        return messageRepo.findByAuthor_Id(id);
    }
}
