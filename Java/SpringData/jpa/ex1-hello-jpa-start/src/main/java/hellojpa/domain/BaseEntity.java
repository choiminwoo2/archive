package hellojpa.domain;


import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @Override
    public String toString() {

        return super.toString();
    }
}
