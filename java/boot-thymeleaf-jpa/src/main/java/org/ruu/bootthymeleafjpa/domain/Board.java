package org.ruu.bootthymeleafjpa.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.ruu.bootthymeleafjpa.dto.board.BoardDTO;

@Getter
@Builder
@Entity
@Table(name = "board")
@ToString(exclude = "imageSet")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long bno;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @BatchSize(size = 20)
    private Set<BoardImage> imageSet = new HashSet<>();

    public void addImage(String uuid, String fileName){
        BoardImage boardImage = BoardImage.builder()
            .uuid(uuid)
            .fileName(fileName)
            .board(this)
            .ord(imageSet.size())
            .build();
        imageSet.add(boardImage);
    }

    public void clearImages(){
        imageSet.forEach(image -> image.changeBoard(null));
        this.imageSet.clear();
    }

    @Builder
    public Board(Long bno, String title, String content, String writer) {

        this.bno = bno;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Board toEntity(BoardDTO dto){
        return Board.builder()
            .bno(dto.getBno())
            .title(dto.getTitle())
            .writer(dto.getTitle())
            .build();
    }
}
