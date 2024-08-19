package org.ruu.bootthymeleafjpa.dto.reply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.domain.Reply;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {

    private Long rno;
    @NotNull
    private Long bno;
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replyer;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    @JsonIgnore
    private LocalDateTime modDate;

    public static ReplyDTO of(Reply reply){
        return ReplyDTO.builder()
            .rno(reply.getRno())
            .bno(reply.getBno())
            .replyer(reply.getReplyer())
            .replyText(reply.getReplyText())
            .regDate(reply.getRegDate())
            .modDate(reply.getModDate())
            .build();
    }
    public Board toBoard(){
        return Board.builder()
            .bno(this.bno)
            .build();
    }

}
