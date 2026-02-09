package sentinel.project.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(
    name = "message",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_message_event_id",
            columnNames = "event_id"
        )
    }
)
@Data
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "event_id", nullable = false)
    private UUID eventId;

    private String source;
    private String status;
    private String payload;
    private Instant timestamp;
}
