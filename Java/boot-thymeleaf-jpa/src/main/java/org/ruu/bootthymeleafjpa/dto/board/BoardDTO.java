package org.ruu.bootthymeleafjpa.dto.board;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ruu.bootthymeleafjpa.domain.Board;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String writer;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private List<String> fileNames;

    public static BoardDTO from(Board board){
        BoardDTO boardDTO = BoardDTO.builder()
            .bno(board.getBno())
            .title(board.getTitle())
            .content(board.getContent())
            .writer(board.getWriter())
            .regDate(board.getRegDate())
            .modDate(board.getModDate())
            .build();

        List<String> fileNames = board.getImageSet().stream()
            .sorted()
            .map(boardImage -> boardImage.getUuid() +"_" + boardImage.getFileName())
            .toList();
        boardDTO.setFileNames(fileNames);

        return boardDTO;
    }

    public static Board toEntity(BoardDTO boardDTO){

        Board board = Board.builder()
            .bno(boardDTO.getBno())
            .title(boardDTO.getTitle())
            .content(boardDTO.getContent())
            .writer(boardDTO.getWriter())
            .build();

        if(boardDTO.getFileNames() != null){
            boardDTO.getFileNames().forEach(fileName ->{
                String[] arr = fileName.split("_");
                board.addImage(arr[0],arr[1]);
            });
        }
        return board;
    }
}
