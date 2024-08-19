package org.ruu.bootthymeleafjpa.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ruu.bootthymeleafjpa.domain.Reply;
import org.ruu.bootthymeleafjpa.dto.PageRequestDTO;
import org.ruu.bootthymeleafjpa.dto.PageResponseDTO;
import org.ruu.bootthymeleafjpa.dto.reply.ReplyDTO;
import org.ruu.bootthymeleafjpa.repository.ReplyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public Long register(ReplyDTO replyDTO) {

        Reply reply = Reply.builder()
            .replyText(replyDTO.getReplyText())
            .board(replyDTO.toBoard())
            .replyer(replyDTO.getReplyer())
            .build();

        Long rno = replyRepository.save(reply).getRno();

        return rno;
    }

    public void modify(ReplyDTO replyDTO) {

        Optional<Reply> replyOptional = replyRepository.findById(replyDTO.getRno());

        Reply reply = replyOptional.orElseThrow();

        reply.changeText(replyDTO.getReplyText());

        replyRepository.save(reply);
    }

    public void delete(Long rno) {

        replyRepository.deleteById(rno);
    }

    public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {

        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() <= 0 ? 0 : pageRequestDTO.getPage() - 1,
            pageRequestDTO.getSize(),
            Sort.by("rno").ascending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        List<ReplyDTO> dtoList = result.getContent().stream()
            .map(ReplyDTO::of)
            .toList();

        return PageResponseDTO.<ReplyDTO>withAll()
            .pageRequestDTO(pageRequestDTO)
            .dtoList(dtoList)
            .total((int)result.getTotalElements())
            .build();

    }

    public ReplyDTO read(Long rno){
        ReplyDTO replyDTO = replyRepository.findById(rno).stream()
            .map(ReplyDTO::of)
            .findFirst().orElseThrow();

        return replyDTO;

    }
}
