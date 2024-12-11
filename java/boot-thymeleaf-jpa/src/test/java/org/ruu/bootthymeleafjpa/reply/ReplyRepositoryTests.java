package org.ruu.bootthymeleafjpa.reply;


import jakarta.transaction.Transactional;
import java.sql.SQLException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.annotation.RepositoryTest;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.domain.Reply;
import org.ruu.bootthymeleafjpa.dto.board.BoardListReplyCountDTO;
import org.ruu.bootthymeleafjpa.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RepositoryTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    void testInsert() {

        Long bno = 705L;

        Board board = Board.builder()
            .bno(bno)
            .build();

        Reply reply = Reply.builder()
            .board(board)
            .replyText("댓글....")
            .replyer("replyer1")
            .build();

        replyRepository.save(reply);
    }

    @Test
    @Transactional(rollbackOn = {SQLException.class})
    void replyByBoard() {

        Long bno = 705L;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        result.getContent().forEach(reply -> log.info(reply));

    }

    @Test
    void testSearchReplyCount() {

        String[] types = {"t", "c", "w"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<BoardListReplyCountDTO> result = replyRepository.searchWithReplyCount(types, keyword, pageable);

        log.info(result.getTotalPages());

        log.info(result.getNumber());

        log.info(result.hasPrevious() + " : " + result.hasNext());

        result.getContent().forEach(log::info);
    }

    @Test
    public void testSearchImageReplyCount(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        // 9 + 1
        // 왜 일어날까?
        // BOARD 컬럼의 각각 IMAGE는 LazyLoading이 된다.
        // 각 게시글은 모두 같지 않은 이미지를 가지고 있고, 이미지 번호만을 가진 프록시 객체를 가졌을 뿐이다.
        // imageSet을 직접 사용하게 되거나 get으로 얻게되면
        // 해당 쿼리가 나간다.
        // @BatchSize를 통해 in쿼리 최적화를 해야한다.
        // Global 설정도 존재 하지만, 최적화를 위해서라면 @BatchSize를 사용하는게 낫다.
        // @OneToOne, @OneToMany, @ManyToMany에서 자주 일어난다.
        replyRepository.searchWithAllOrNull(null, null, pageable);
    }

}
