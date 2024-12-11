package org.ruu.springmvcxml.controller;

import com.sun.tools.javac.comp.Todo;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.ruu.springmvcxml.dto.PageRequestDTO;
import org.ruu.springmvcxml.dto.TodoDTO;
import org.ruu.springmvcxml.service.TodoService;
import org.ruu.springmvcxml.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    @GetMapping("/register")
    public void registerGet() {

        log.info("GetTodos regis");
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("Post todo regis Requset Data is = " + todoDTO);
        if (bindingResult.hasErrors()) {
            log.info("hasErrors.................");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        todoService.register(todoDTO);
        log.info("/register 성공");

        return "redirect:/todo/list";
    }

    @GetMapping("/read")
    public void read(Long tno, Model model){
        log.info(tno);
        TodoDTO dto = todoService.getTodoByTno(tno);
        model.addAttribute("dto", dto );
    }
    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

}
