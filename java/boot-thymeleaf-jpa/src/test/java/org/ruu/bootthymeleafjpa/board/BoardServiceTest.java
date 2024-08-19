package org.ruu.bootthymeleafjpa.board;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.dto.board.BoardDTO;
import org.ruu.bootthymeleafjpa.dto.PageRequestDTO;
import org.ruu.bootthymeleafjpa.dto.PageResponseDTO;
import org.ruu.bootthymeleafjpa.dto.board.BoardImageDTO;
import org.ruu.bootthymeleafjpa.dto.board.FindAllBoardDTO;
import org.ruu.bootthymeleafjpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void register(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
            .title("Sample Title..")
            .content("SampleContent")
            .writer("user00")
            .build();

        Long bno = boardService.register(boardDTO);

        log.info("Bno: " + bno);

        Assertions.assertThat(bno).isNotNull();
    }

    @Test
    void registerWithImage(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
            .title("file...sample Title...")
            .content("sqmple content...")
            .writer("user00")
            .build();

        boardDTO.setFileNames(
            Arrays.asList(
                UUID.randomUUID() + "_aaa.jpg",
                UUID.randomUUID() + "_bbb.jpg",
                UUID.randomUUID() + "_bbb.jpg"
            ));
        Long bno = boardService.register(boardDTO);

        log.info("bno: " + bno);
    }

    @Test
    void readOne(){
        log.info(boardService.getClass().getName());
        long bno = 50L;

        BoardDTO boardDTO = boardService.readOne(bno);

        Assertions.assertThat(boardDTO.getBno()).isEqualTo(bno);
    }

    @Test
    void modify(){
        BoardDTO boardDTO = BoardDTO.builder()
            .bno(101L)
            .title("Update...101")
            .content("Update content 101...")
            .build();

        boardDTO.setFileNames(Arrays.asList(UUID.randomUUID().toString() + "_zzz.jpg"));

        boardService.modify(boardDTO);

        BoardDTO boardDTO1 = boardService.readOne(101L);

        Assertions.assertThat(boardDTO.getContent()).isEqualTo(boardDTO1.getContent());
    }

    @Test
    void getList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .type("tcw")
            .keyword("1")
            .page(1)
            .size(10)
            .build();

        PageResponseDTO<BoardDTO> reponseDTO = boardService.list(pageRequestDTO);

        log.info(reponseDTO);
    }

    @Test
    void readOneWithImage(){
        Long bno = 101L;

        BoardDTO boardDTO = boardService.readOne(bno);

        log.info(boardDTO);

        for(String fileName : boardDTO.getFileNames()){
            log.info(fileName);
        }
    }

    @Test
    @Rollback
    void remove(){
        Long bno = 101L;

        boardService.remove(bno);
    }

    @Test
    void listWithAll(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .build();

        PageResponseDTO<FindAllBoardDTO> responseDTO = boardService.listWithAll(pageRequestDTO);

        List<FindAllBoardDTO> dtoList = responseDTO.getDtoList();


        dtoList.forEach(findAllBoardDTO -> {
            log.info(findAllBoardDTO.getBno() + ":" + findAllBoardDTO.getTitle());

            if(findAllBoardDTO.getBoardImages() != null){
                for(BoardImageDTO boardImageDTO : findAllBoardDTO.getBoardImages()){
                    log.info(boardImageDTO);
                }
            }

            log.info("------------------------------------------------");
        });
    }
}
