package org.zerock.servletmvc.todo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.Cleanup;
import org.zerock.servletmvc.todo.domain.TodoEntity;

public class TodoDAO {

  public String getTime() throws SQLException {

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

    resultSet.next();
    return resultSet.getString(1);
  }

  public void insert(TodoEntity entity) throws SQLException {
    String sql = "insert into tbl_todo (title, dueDate, finished) values (?, ?, ?)";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, entity.getTitle());
    preparedStatement.setDate(2, Date.valueOf(entity.getDueDate()));
    preparedStatement.setBoolean(3, entity.isFinished());
    preparedStatement.executeUpdate();
  }

  public TodoEntity findByTitle(String title) throws SQLException {
    String sql = "select * from tbl_todo where title = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, title);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
    TodoEntity entity = null;
    while (resultSet.next()) {
      entity = TodoEntity.builder()
          .tno(resultSet.getLong("tno"))
          .title(resultSet.getString("title"))
          .dueDate(resultSet.getDate("dueDate").toLocalDate())
          .finished(resultSet.getBoolean("finished"))
          .build();
    }
    return entity;
  }

  public List<TodoEntity> selectAll() throws SQLException {
    String sql = "select * from tbl_todo";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

    List<TodoEntity> list = new ArrayList<>();
    while (resultSet.next()) {
      list.add(
          TodoEntity.builder()
              .tno(resultSet.getLong("tno"))
              .title(resultSet.getString("title"))
              .dueDate(resultSet.getDate("dueDate").toLocalDate())
              .finished(resultSet.getBoolean("finished"))
              .build()
      );
    }
    return list;
  }

  public int getCount() throws SQLException {
    String sql = "select count(tno) as cnt from tbl_todo";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();

    return resultSet.getInt(1);
  }

  public TodoEntity selectOne(Long tno) throws SQLException {
    String sql = "select * from tbl_todo where tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setLong(1, tno);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

    resultSet.next();

    return TodoEntity.builder()
        .tno(resultSet.getLong("tno"))
        .title(resultSet.getString("title"))
        .dueDate(resultSet.getDate("dueDate").toLocalDate())
        .finished(resultSet.getBoolean("finished"))
        .build();
  }

  public void deleteOne(Long tno) throws SQLException {
    String sql = "delete from tbl_todo where tno = ?";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setLong(1, tno);
    preparedStatement.executeUpdate();
  }

  public void updateOne(TodoEntity entity) throws SQLException {
    String sql = "update tbl_todo set title = ?, dueDate = ?, finished = ? where tno = ?";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, entity.getTitle());
    preparedStatement.setDate(2, Date.valueOf(entity.getDueDate()));
    preparedStatement.setBoolean(3, entity.isFinished());
    preparedStatement.setLong(4, entity.getTno());
    preparedStatement.executeUpdate();
  }
}
