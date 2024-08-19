package org.ruu.springmvcxml.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ruu.springmvcxml.domain.TodoEntity;
import org.ruu.springmvcxml.dto.PageRequestDTO;
import org.ruu.springmvcxml.dto.PageResponseDTO;
import org.ruu.springmvcxml.dto.TodoDTO;
import org.ruu.springmvcxml.mapper.TodoMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    @Override
    public void register(TodoDTO todoDTO) {

        log.info("[Service] insertService ");

        TodoEntity todoEntity = TodoEntity.builder()
            .title(todoDTO.getTitle())
            .dueDate(todoDTO.getDueDate())
            .writer(todoDTO.getWriter())
            .build();
        System.out.println(todoDTO);
        todoMapper.insert(todoEntity);
        log.info("[Service] resigster is Success");
    }

    @Override
    public List<TodoDTO> getAll() {

        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
            .map(entity -> TodoDTO.builder()
                .tno(entity.getTno())
                .title(entity.getTitle())
                .finished(entity.isFinished())
                .dueDate(entity.getDueDate())
                .writer(entity.getWriter())
                .build())
            .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO getTodoByTno(Long tno) {

        TodoEntity entity = todoMapper.selectOne(tno);
        return TodoDTO.builder()
            .tno(entity.getTno())
            .writer(entity.getWriter())
            .finished(entity.isFinished())
            .title(entity.getTitle())
            .dueDate(entity.getDueDate())
            .build();
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO requestDTO) {

        List<TodoEntity> entities = todoMapper.selectList(requestDTO);
        List<TodoDTO> dtoList = entities.stream()
            .map(todo -> TodoDTO.builder()
                .tno(todo.getTno())
                .writer(todo.getWriter())
                .dueDate(todo.getDueDate())
                .finished(todo.isFinished())
                .title(todo.getTitle())
                .build()
            ).collect(Collectors.toList());
        int total = todoMapper.getCount(requestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll().
            dtoList(dtoList)
            .pageRequestDTO(requestDTO)
            .total(total)
            .build();

        return pageResponseDTO;
    }
}
