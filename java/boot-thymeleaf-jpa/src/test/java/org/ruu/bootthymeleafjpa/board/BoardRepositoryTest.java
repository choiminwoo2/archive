package org.ruu.bootthymeleafjpa.board;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.annotation.RepositoryTest;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.dto.board.FindAllBoardDTO;
import org.ruu.bootthymeleafjpa.repository.BoardRepository;
import org.ruu.bootthymeleafjpa.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.PlatformTransactionManager;

@RepositoryTest
@Log4j2
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository repository;

    @Autowired
    private ReplyRepository replyRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void BoardTest() {

        Board board = Board.builder()
            .title("title")
            .content("content")
            .writer("ㅇㅇ")
            .build();
        repository.saveAndFlush(board);

        assertThat(board).isNotNull();

    }

    @Test
    @Commit
    void insertMany() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                .title("title.." + i)
                .content("content.." + i)
                .writer("user" + (i % 10))
                .build();
            for (int j = 0; j < 3; j++) {
                if(i % 5 == 0){
                    continue;
                }
                board.addImage(UUID.randomUUID().toString(), i + "file" + j + ".jpg");
            }

            Board result = repository.save(board);
            log.info("bno: " + result.getBno());
            assertThat(result).isNotNull();
        });
    }

    @Test
    void testSelect() {

        Long bno = 100L;

        Optional<Board> result = repository.findById(bno);

        Board board = result.orElseThrow();

        log.info(board);
    }

    @Test
    void updateBoard() {

        Long bno = 100L;

        Optional<Board> result = repository.findById(bno);

        Board board = result.orElseThrow();

        board.change("update...title 100", "update content 100");

        repository.save(board);
    }

    @Test
    void deleteBoard() {

        Long bno = 1L;
        repository.deleteById(bno);
    }

    @Test
    public void testPaging() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = repository.findAll(pageable);

    }

    @Test
    void selectAll() {

        String[] types = {"t", "c", "w"};

        String keword = "1";

        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());

        Page<Board> result = repository.searchAll(types, keword, pageable);
    }

    @Test
    void selectAll2() {

        String[] types = {"t", "c", "w"};

        String keword = "1";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = repository.searchAll(types, keword, pageable);

        log.info(result.getTotalPages());

        log.info(result.getSize());

        log.info(result.getNumber());

        log.info(result.hasPrevious() + " :" + result.hasNext());

        result.getContent().forEach(board -> log.info(board));
    }

    //영속성 전이 써서 보드에서 해야함.
    @Test
    public void insertWithImages() {

        Board board = Board.builder()
            .title("Image...")
            .content("첨부파일 테스트")
            .writer("tester")
            .build();

        for (int i = 0; i < 3; i++) {
            board.addImage(UUID.randomUUID().toString(), "file" + i + ".jpg");
        }

        repository.save(board);

    }

    @Test
    public void readWithImages() {

        Optional<Board> result = repository.findById(819L);
        Board board = result.orElseThrow();
        log.info(board);
        log.info("====================================");
        log.info(board.getImageSet());
        log.info("====================================");


    }

    @Test
    public void modifyImages() {

        Long findId = 819L;
        Optional<Board> result = repository.findByIdWithImage(819L);

        Board board = result.orElseThrow();
        board.clearImages();

        for (int i = 0; i < 2; i++) {
            board.addImage(UUID.randomUUID().toString(), "upadatefile" + i + ".jpg");
        }
        Long resultId = repository.save(board).getBno();

        assertThat(findId).isEqualTo(resultId);
    }

    @Test
    @Rollback
    void removeAll() throws Exception {
        Long bno = 819L;

        replyRepository.deleteByBoard_bno(bno);

        repository.deleteById(bno);
        entityManager.flush();
    }

    @Test
    public void searchImageReplyCount(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<FindAllBoardDTO> result = repository.searchWithAllOrNull(null, null, pageable);

        log.info("=================================");
        log.info(result.getTotalElements());

        result.getContent().forEach(findAllBoardDTO -> log.info(findAllBoardDTO));
    }
}
