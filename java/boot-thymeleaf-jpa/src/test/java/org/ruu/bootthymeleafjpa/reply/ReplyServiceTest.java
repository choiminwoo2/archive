package org.ruu.bootthymeleafjpa.reply;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.ruu.bootthymeleafjpa.dto.reply.ReplyDTO;
import org.ruu.bootthymeleafjpa.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ReplyServiceTest {

    @Autowired
    private ReplyService replyService;

    @Test
    public void testRegister(){

        ReplyDTO replyDTO = ReplyDTO.builder()
            .replyText("ReplyDTO TEXT")
            .replyer("replyer")
            .bno(705L)
            .build();

        log.info(replyService.register(replyDTO));
    }
}
