<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-16
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<P>list Pages</P>
<h2>${loginInfo}</h2>
<h3>${loginInfo.mname}</h3>
<ul>
    <v:forEach var="todo" items="${list}">
        <li>
            <span><a href="/todo/read?tno=${todo.tno}">${todo.tno}</a></span>
            <span>${todo.title}</span>
            <span>${todo.dueDate}</span>
            <span>${todo.finished ? "DONE" : "NOT YET"}</span>
        </li>
    </v:forEach>
</ul>
<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>
<div>
    <a href="/todo/register">
        <button type="button">등록</button>
    </a>
</div>

</body>
</html>
