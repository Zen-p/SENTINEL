package sentinel.project.services;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sentinel.project.DTOs.SystemEventDTO;
import sentinel.project.models.Message;


@Service
@AllArgsConstructor
@Slf4j
public class KafkaListenerService {

    MessageService service;


    @KafkaListener(topics = "sentinel-topic", groupId = "my-group")
    public void listen(SystemEventDTO event) { 
        log.info("Received event: {}", event);


        Message message = Message.builder()
                .eventId(event.eventId())
                .source(event.source())
                .status(event.status())
                .timestamp(event.timestamp())
                .payload(event.payload())
                .build();

        try {
            service.save(message);
            log.info("Saved to DB id: {}", message.getId());
        } catch (DataIntegrityViolationException e) {
            log.error("Duplicate found: {}", message.getEventId());
        }
        
    }

}
