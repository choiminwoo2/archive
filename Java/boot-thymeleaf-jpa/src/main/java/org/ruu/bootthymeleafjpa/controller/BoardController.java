package org.ruu.bootthymeleafjpa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ruu.bootthymeleafjpa.dto.board.BoardDTO;
import org.ruu.bootthymeleafjpa.dto.board.BoardListReplyCountDTO;
import org.ruu.bootthymeleafjpa.dto.PageRequestDTO;
import org.ruu.bootthymeleafjpa.dto.PageResponseDTO;
import org.ruu.bootthymeleafjpa.dto.board.FindAllBoardDTO;
import org.ruu.bootthymeleafjpa.service.BoardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Log4j2
@Tag(name = "BoardController")
@RequiredArgsConstructor
public class BoardController {

    @Value("${org.ruu.bootthymeleafjpa.upload.path}")
    private String uploadPath;

    private final BoardService boardService;

    @GetMapping("/list")
    @Operation(summary = "리스트")
    public void list(
        PageRequestDTO pageRequestDTO,
        Model model) {

        log.info("List에 진입");
        PageResponseDTO<FindAllBoardDTO> responseDTO = boardService.listWithAll(pageRequestDTO);
        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/register")
    public String registerGet(){
        return "board/register";
    }

    @Operation(summary = "저장")
    @PostMapping("/register")
    public String registerPost(
        @Valid BoardDTO boardDTO,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes) {

        log.info("board POST register......");
        if (bindingResult.hasErrors()) {
            log.info("has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }

        log.info(boardDTO);

        Long bno = boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute("result", bno);

        return "redirect:/board/list";

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping({"/read", "/modify"})
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model){
        BoardDTO boardDTO = boardService.readOne(bno);

        log.info(boardDTO);
        model.addAttribute("dto",boardDTO);
    }
    @Operation(summary = "수정")
    @PreAuthorize("principal.username == #boardDTO.writer")
    @PostMapping("/modify")
    public String modify( PageRequestDTO pageRequestDTO,
        @Valid BoardDTO boardDTO,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes){

        log.info("modify ...." + boardDTO);
        if(bindingResult.hasErrors()){
            log.info("eroors....");

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            redirectAttributes.addAttribute("bno", boardDTO.getBno());

            return "redirect:/board/modify?"+ pageRequestDTO.getLink();

        }
        boardService.modify(boardDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("bno", boardDTO.getBno());

        return "redirect:/board/read";
    }
    @Operation(summary = "삭제")
    @PreAuthorize("principal.username == #boardDTO.writer")
    @PostMapping("/remove")
    public String remove(BoardDTO boardDTO,
        RedirectAttributes redirectAttributes) throws IOException {
        List<String> fileNames = boardDTO.getFileNames();
        log.info("delete....");
        boardService.remove(boardDTO.getBno());

        log.info(boardDTO.getFileNames());
        if(fileNames != null && fileNames.size() > 0){
           removeFiles(fileNames);
        }

        redirectAttributes.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }

    private void removeFiles(List<String> fileNames) {
        for(String fileName : fileNames){
            Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);

            String resourceName = resource.getFilename();

            try{
                String contentType = Files.probeContentType(resource.getFile().toPath());
                System.out.println("ContentType이 궁금해!!:" +contentType);
                resource.getFile().delete();

                if(contentType.startsWith("image")){
                    File thumbnailFile = new File(uploadPath + File.separator + "s_" + fileName);

                    thumbnailFile.delete();
                }

            }catch(IOException e){
                log.info(e.getMessage());
            }
        }
    }
}
