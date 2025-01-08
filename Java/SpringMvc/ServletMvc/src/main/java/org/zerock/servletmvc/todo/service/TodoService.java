package org.zerock.servletmvc.todo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.servletmvc.todo.dao.TodoDAO;
import org.zerock.servletmvc.todo.domain.TodoEntity;
import org.zerock.servletmvc.todo.dto.TodoDTO;
import org.zerock.servletmvc.util.MapperUtil;

@Log4j2
public enum TodoService {
  INSTANCE;

  private TodoDAO dao;
  private ModelMapper modelMapper;

  TodoService() {
    dao = new TodoDAO();
    modelMapper = MapperUtil.INSTANCE.get();
  }

  public void register(TodoDTO todoDTO) throws SQLException {
    TodoEntity entity = modelMapper.map(todoDTO, TodoEntity.class);
    log.info(entity);
    dao.insert(entity);

  }

  public List<TodoDTO> getList() throws SQLException {
    List<TodoEntity> list = dao.selectAll();
    return list.stream()
        .map(entity -> modelMapper.map(entity, TodoDTO.class))
        .collect(Collectors.toList());
  }

  public TodoDTO get(Long tno) throws SQLException {
    return modelMapper.map(dao.selectOne(tno), TodoDTO.class);
  }

  public void modify(TodoDTO dto) throws SQLException {
    log.info("update Todo--------");
    dao.updateOne(modelMapper.map(dto, TodoEntity.class));
    log.info("update SUCCESS");
  }

  public void remove(Long tno) throws SQLException {
    log.info("remove Todo--------");
    dao.deleteOne(tno);
    log.info("remove SUCCESS");
  }
}
