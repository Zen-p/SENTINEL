package sentinel.project.DTOs;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record SystemEventDTO( 
    UUID eventId,      
    String source,     
    String status,      
    String payload,     
    Instant timestamp
) 
{ 
    public SystemEventDTO {

        Objects.requireNonNull(eventId, "eventId cannot be null!");
        
        if (timestamp == null) {
            timestamp = Instant.now();
        }
    }
}
