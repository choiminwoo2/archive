<jsp:useBean id="dto" scope="request" type="org.zerock.servletmvc.todo.dto.TodoDTO"/>
<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-16
  Time: 오후 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form1" action="/todo/modify" method="post">
    <div>
        <input type="text" name="tno" value="${dto.tno}" readonly/>
    </div>
    <div>
        <input type="text" name="title" value="${dto.title}" readonly/>
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.dueDate}" readonly/>
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly/>
    </div>
    <div>
        <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
        <a href="/todo/list">List</a>
    </div>

</form>
</body>
</html>
