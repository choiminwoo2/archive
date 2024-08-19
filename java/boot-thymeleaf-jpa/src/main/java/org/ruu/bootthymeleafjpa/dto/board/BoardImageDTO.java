package org.ruu.bootthymeleafjpa.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.ruu.bootthymeleafjpa.domain.BoardImage;


//Builder는 static을 사용하는  생성 패턴이라 가능하다.
//정적 메서드 팩토리도 가능한가?
@Builder
public record BoardImageDTO(String uuid, String fileName, int ord) {

    public static BoardImageDTO of(BoardImage boardImage){

        return BoardImageDTO.builder()
            .uuid(boardImage.getUuid())
            .ord(boardImage.getOrd())
            .fileName(boardImage.getFileName())
            .build();
    }
}
