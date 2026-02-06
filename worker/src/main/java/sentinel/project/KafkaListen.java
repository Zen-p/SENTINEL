package sentinel.project;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import sentinel.project.models.Message;
import sentinel.project.services.MessageService;

@Service
@AllArgsConstructor
public class KafkaListen {

    MessageService service;


    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {            
        service.save(Message.builder().message(message).build());
    }

}
