package sentinel.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sentinel.project.models.Message;



@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    
    
}
