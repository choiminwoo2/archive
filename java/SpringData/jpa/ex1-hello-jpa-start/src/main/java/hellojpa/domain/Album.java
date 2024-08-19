package hellojpa.domain;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Album extends Item{
    private String artist;
    private String etc;
}
