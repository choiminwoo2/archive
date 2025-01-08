package org.ruu.bootthymeleafjpa.study;

import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.domain.BoardImage;
import org.ruu.bootthymeleafjpa.dto.board.BoardImageDTO;

public class RecordTest {

    @Test
    void recordTest(){

        BoardImage boardImage = BoardImage.builder()
            .uuid(UUID.randomUUID().toString())
            .ord(100000)
            .fileName("test")
            .build();
        BoardImageDTO boardImageDTO = BoardImageDTO.of(boardImage);
        Assertions.assertThat(boardImageDTO).isNotNull();

    }
}
