<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-18
  Time: 오후 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <!-- tailwind css -->
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Title</title>
</head>
<body class="bg-gray-100">
<div class="container mx-auto px-4 py-8">
    <h1 class="text-3xl font-bold mb-4">게시판</h1>
    <!-- 게시물 목록 -->
    <ul class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        <!-- 각 게시물 -->
        <li class="bg-white rounded-lg shadow-md p-4">
            <h2 class="text-lg font-semibold mb-2">게시물 제목</h2>
            <p class="text-gray-600 mb-4">게시물 내용이 여기에 들어갑니다.</p>
            <div class="flex justify-between items-center">
                <span class="text-sm text-gray-500">작성자: John Doe</span>
                <span class="text-sm text-gray-500">2024-02-23</span>
            </div>
        </li>
        <!-- 다른 게시물들도 유사하게 추가 -->
    </ul>
</div>
</body>
</html>
