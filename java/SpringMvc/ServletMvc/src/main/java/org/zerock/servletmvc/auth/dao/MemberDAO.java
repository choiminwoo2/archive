package org.zerock.servletmvc.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.zerock.servletmvc.auth.domain.MemberEntity;
import org.zerock.servletmvc.todo.dao.ConnectionUtil;

@Log4j2
public class MemberDAO {

    public MemberEntity getWithPassword(String mid, String mpw) throws SQLException {

        String sql = "select mid, mpw, mname from tbl_member where mid = ? and mpw = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemberEntity entity = MemberEntity.builder()
            .mid(resultSet.getString(1))
            .mpw(resultSet.getString(2))
            .mname(resultSet.getString(3))
            .build();

        return entity;
    }

    public void updateUuid(String mid, String uuid) throws Exception {

        String sql = "update tbl_member set uuid = ? where mid = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, mid);
        preparedStatement.executeQuery();
    }

    public MemberEntity selectUUID(String uuid) throws Exception {

        String sql = "select mid, mpw, mname, uuid from tbl_member where uuid = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, uuid);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        MemberEntity memberEntity = MemberEntity.builder()
            .mid(resultSet.getString(1))
            .mpw(resultSet.getString(2))
            .mname(resultSet.getString(3))
            .uuid(resultSet.getString(4))
            .build();

        return memberEntity;

    }
}
