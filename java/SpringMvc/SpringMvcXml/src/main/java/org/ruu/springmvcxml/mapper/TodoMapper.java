package org.ruu.springmvcxml.mapper;

import java.util.List;
import org.ruu.springmvcxml.domain.TodoEntity;
import org.ruu.springmvcxml.dto.PageRequestDTO;

public interface TodoMapper {
    String getTime();

    void insert(TodoEntity todoEntity);

    List<TodoEntity> selectAll();

    TodoEntity selectOne(Long tno);

    List<TodoEntity> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
