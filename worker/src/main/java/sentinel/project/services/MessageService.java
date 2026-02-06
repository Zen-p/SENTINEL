package sentinel.project.services;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sentinel.project.repos.MessageRepository;

@Service
@AllArgsConstructor
public class MessageService {
    
    private final MessageRepository messageRepository;


    public void save(sentinel.project.models.Message message) {
        messageRepository.save(message);
    }

}
