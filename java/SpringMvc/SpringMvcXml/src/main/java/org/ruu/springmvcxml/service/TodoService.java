package org.ruu.springmvcxml.service;

import java.util.List;
import org.ruu.springmvcxml.dto.PageRequestDTO;
import org.ruu.springmvcxml.dto.PageResponseDTO;
import org.ruu.springmvcxml.dto.TodoDTO;

public interface TodoService {

    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();

    TodoDTO getTodoByTno(Long tno);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO requestDTO);
}
