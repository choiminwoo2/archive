package org.ruu.bootthymeleafjpa.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import java.util.List;
import org.ruu.bootthymeleafjpa.domain.Board;
import org.ruu.bootthymeleafjpa.domain.QBoard;
import org.ruu.bootthymeleafjpa.domain.QReply;
import org.ruu.bootthymeleafjpa.dto.board.BoardImageDTO;
import org.ruu.bootthymeleafjpa.dto.board.BoardListReplyCountDTO;
import org.ruu.bootthymeleafjpa.dto.board.FindAllBoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        if(types != null && types.length > 0 && keyword != null){
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type : types){
                switch (type){
                    case "t" -> booleanBuilder.or(board.title.contains(keyword));
                    case "c" -> booleanBuilder.or(board.content.contains(keyword));
                    case "w" -> booleanBuilder.or(board.writer.contains(keyword));
                }
            }
            query.where(booleanBuilder);
        }

        query.where(board.bno.gt(0L));

        //paging
        this.getQuerydsl().applyPagination(pageable, query);

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list,pageable,count);
    }

    @Override
    public Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;

        JPQLQuery<Board> query = from(board);

        // why? leftJoin? 그것은 덧글이 0 일 수도 있기 때문이다.
        // 0 이면 board의 대한 정보를 알 수가 없다.
        // select * from board b left join reply r where b.bno = r.bno group by b.bno 인가?
        // 내가 추측하기로는 board나 reply가 그냥 들어가면 pk키 기준이라고 생각함.
        query.leftJoin(reply).on(reply.board.eq(board));
        //
        query.groupBy(board);

        if( (types != null && types.length > 0) && keyword != null){
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type: types){
                switch (type){
                    case "t" -> booleanBuilder.or(board.title.contains(keyword));
                    case "c" -> booleanBuilder.or(board.content.contains(keyword));
                    case "w" -> booleanBuilder.or(board.writer.contains(keyword));
                }
            }
            query.where(booleanBuilder);
        }

        //bno > 0
        query.where(board.bno.gt(0L));


        //Projections <= dto로 변환해준다.?
        // 해당 쿼리문은 어캐 동작할까?
        JPQLQuery<BoardListReplyCountDTO> dtoQuery = query.select(Projections
            .bean(BoardListReplyCountDTO.class,
                board.bno,
                board.title,
                board.writer,
                board.regDate,
                reply.count().as("replyCount")
            ));

        this.getQuerydsl().applyPagination(pageable, dtoQuery);

        List<BoardListReplyCountDTO> dtoList = dtoQuery.fetch();

        long count = dtoQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, count);

    }

    @Override
    public Page<FindAllBoardDTO> searchWithAllOrNull(String[] types, String keyword, Pageable pageable) {
        QBoard qBoard = QBoard.board;
        QReply qReply = QReply.reply;

        JPQLQuery<Board> boardJPQLQuery = from(qBoard);
        boardJPQLQuery.leftJoin(qReply).on(qReply.board.eq(qBoard));

        if( (types != null && types.length > 0) && keyword != null){
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type: types){
                switch (type){
                    case "t" -> booleanBuilder.or(qBoard.title.contains(keyword));
                    case "c" -> booleanBuilder.or(qBoard.content.contains(keyword));
                    case "w" -> booleanBuilder.or(qBoard.writer.contains(keyword));
                }
            }
            boardJPQLQuery.where(booleanBuilder);
        }

        boardJPQLQuery.groupBy(qBoard);

        getQuerydsl().applyPagination(pageable, boardJPQLQuery);


        JPQLQuery<Tuple> tupleJPQLQuery = boardJPQLQuery.select(qBoard, qReply.countDistinct());

        List<Tuple> tuples = tupleJPQLQuery.fetch();

        List<FindAllBoardDTO> dtoList = tuples.stream().map(tuple -> {

            Board board = tuple.get(qBoard);
            long replyCount = tuple.get(1, Long.class);

            FindAllBoardDTO dto = FindAllBoardDTO.builder()
                .bno(board.getBno())
                .writer(board.getWriter())
                .title(board.getTitle())
                .regDate(board.getRegDate())
                .replyCount(replyCount)
                .build();

            List<BoardImageDTO> imageDTOS = board.getImageSet().stream().sorted()
                .map(BoardImageDTO::of)
                .toList();

            dto.setBoardImages(imageDTOS);

            return dto;
        }).toList();
        long totalCount = boardJPQLQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, totalCount);
    }





}
