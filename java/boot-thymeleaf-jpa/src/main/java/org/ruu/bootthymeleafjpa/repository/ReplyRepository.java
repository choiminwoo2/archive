package org.ruu.bootthymeleafjpa.repository;

import org.ruu.bootthymeleafjpa.domain.Reply;
import org.ruu.bootthymeleafjpa.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long>, BoardSearch {

    @Query("select r from Reply r where r.board.bno = :bno")
    Page<Reply> listOfBoard(Long bno, Pageable pageable);

    void deleteByBoard_bno(Long bno);

}
