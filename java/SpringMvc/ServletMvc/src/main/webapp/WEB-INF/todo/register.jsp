<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-16
  Time: 오후 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/todo/register" method="post">
    <div>
        <input type="text" name="title" placeholder="INSERT TITLE"/>
    </div>
    <div>
        <input type="date" name="dueDate"/>
    </div>
    <div>
        <button type="submit">등록</button>
    </div>
</form>
</body>
</html>
