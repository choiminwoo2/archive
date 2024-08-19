<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-23
  Time: 오후 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
</head>
<body class="bg-gray-100">
<div class="max-w-lg mx-auto my-8">
    <div class="bg-white rounded-lg shadow-md p-8">
        <h1 class="text-3xl font-bold mb-4">게시글 상세</h1>
        <div>
            <label for="postNumber"><strong>게시물 번호:</strong></label>
            <input type="text" id="postNumber" name="tno" value="<c:out value="${dto.tno}" />" readonly><br>

            <label for="postTitle"><strong>타이틀명:</strong></label>
            <input type="text" id="postTitle" name="title" value="<c:out value="${dto.title}" />" readonly><br>

            <label for="postWriter"><strong>작성자:</strong></label>
            <input type="text" id="postWriter" name="writer" value="<c:out value="${dto.writer}" />" readonly><br>

            <label for="postDate"><strong>작성일:</strong></label>
            <input type="text" id="postDate" name="dueDate" value="<c:out value="${dto.dueDate}" />" readonly><br>

            <label for="postStatus"><strong>상태:</strong></label>
            <input type="checkbox" id="postStatus" name="finished" ${dto.finished ? "checked" : ""}  /><br>
        </div>
        <div class="mt-4">
            <a href="/posts/{{ dto.postId }}/edit" class="update-btn inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2">수정</a>
            <form action="/posts/{{ dto.postId }}" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');" class="inline-block">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">삭제</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
