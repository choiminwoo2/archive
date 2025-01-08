<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-22
  Time: 오전 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
</head>
<body class="bg-gray-100">
<!-- 네비게이션 -->
<nav class="bg-gray-800 text-white p-4">
    <div class="container mx-auto flex justify-between items-center">
        <h1 class="text-2xl font-bold">내 사이트</h1>
        <ul class="flex space-x-4">
            <li><a href="#" class="hover:text-gray-300">홈</a></li>
            <li><a href="#" class="hover:text-gray-300">게시판</a></li>
            <li><a href="#" class="hover:text-gray-300">문의하기</a></li>
        </ul>
    </div>
</nav>

<!-- 헤더 -->
<header class="bg-gray-200 text-gray-700 py-8">
    <div class="container mx-auto text-center">
        <h1 class="text-3xl font-bold">게시글 등록</h1>
    </div>
</header>
<!-- 본문 -->
<section class="container mx-auto px-4 py-8">
    <!-- 게시글 등록 폼 -->
    <form action="/todo/register" method="post"  class="max-w-lg mx-auto flex flex-col">
        <div class="mb-4">
            <label for="title" class="block text-gray-700 font-bold mb-2">제목</label>
            <input type="text" id="title" name="title" class="w-full px-3 py-2 border rounded-md" placeholder="제목을 입력하세요">
        </div>
        <div class="mb-4">
            <label for="date" class="block text-gray-700 font-bold mb-2">날짜</label>
            <input type="date" id="date" name="dueDate" class="w-full px-3 py-2 border rounded-md">
        </div>
        <div class="mb-4">
            <label for="writer" class="block text-gray-700 font-bold mb-2">작성자</label>
            <input type="text" id="writer" name="writer" class="w-full px-3 py-2 border rounded-md" placeholder="작성자를 입력하세요">
        </div>
        <div class="mb-4 flex items-center">
            <input type="checkbox" id="finished" name="finished" class="mr-2">
            <label for="finished" class="text-gray-700 font-bold">완료</label>
        </div>
        <div class="flex justify-end">
            <button type="reset" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mr-2">초기화</button>
            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">등록</button>
        </div>
    </form>
    <script>
        const serverValidResult = {}
        <c:forEach items="${errors}" var="error">
        serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
        </c:forEach>
        console.log(serverValidResult)
    </script>
</section>

<!-- 푸터 -->
<footer class="bg-gray-800 text-white py-4 fixed bottom-0 w-full">
    <div class="container mx-auto text-center">
        &copy; 2024 내 사이트. All Rights Reserved.
    </div>
</footer>
</body>
</html>
