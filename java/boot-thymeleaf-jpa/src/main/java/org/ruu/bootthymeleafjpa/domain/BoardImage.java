package org.ruu.bootthymeleafjpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "board")
@Entity
@Builder
public class BoardImage implements Comparable<BoardImage>{

    @Id
    private String uuid;

    private String fileName;

    private int ord;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Override
    public int compareTo(BoardImage o) {
        return this.ord - o.ord;
    }

    public void changeBoard(Board board){
        this.board = board;
    }
}
