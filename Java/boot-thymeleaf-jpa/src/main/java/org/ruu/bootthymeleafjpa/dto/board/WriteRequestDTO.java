package org.ruu.bootthymeleafjpa.dto.board;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WriteRequestDTO {

    private String title;
    private String content;
    @Builder.Default
    private String writer = "ㅇㅇ";
}
