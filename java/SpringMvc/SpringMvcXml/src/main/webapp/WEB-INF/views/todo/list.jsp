<%--
  Created by IntelliJ IDEA.
  User: wjrdj
  Date: 2024-02-23
  Time: 오후 5:39
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


<div class="max-w-2xl max-h-full mx-auto">

    <div class="bg-white p-6 rounded-md shadow-md mb-4">
        <h1 class="text-3xl font-semibold mb-4 text-center">Paginated Board</h1>
        <!-- Sample Board -->
        <div class="mb-4">
            <!-- Sample Posts -->
            <table class="w-full table-auto">
                <thead>
                <tr>
                    <th class="border-0 border-b-2 border-gray-300 px-4 py-2">번호</th>
                    <th class="border-0 border-b-2 border-gray-300 px-4 py-2">할 일</th>
                    <th class="border-0 border-b-2 border-gray-300 px-4 py-2">작성자</th>
                    <th class="border-0 border-b-2 border-gray-300 px-4 py-2">작성일</th>
                    <th class="border-0 border-b-2 border-gray-300 px-4 py-2">상태</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${responseDTO.dtoList}" var="dto">
                    <tr>
                        <th scope="row" class="border-0 border-b-2 border-gray-300 px-4 py-2"><c:out value="${dto.tno}"/></th>
                        <td class="border-0 border-b-2 border-gray-300 px-4 py-2"><a href="/todo/read?tno=${dto.tno}&${pageRequestDTO.link}"><c:out value="${dto.title}"/></a></td>
                        <td class="border-0 border-b-2 border-gray-300 px-4 py-2"><c:out value="${dto.writer}"/></td>
                        <td class="border-0 border-b-2 border-gray-300 px-4 py-2"><c:out value="${dto.dueDate}"/></td>
                        <td class="border-0 border-b-2 border-gray-300 px-4 py-2 text-green-500"><c:out value="${dto.finished}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </div>

        <!-- Sample Pagination -->
        <ul class="pagination flex justify-center">
            <c:if test="${responseDTO.prev}">
                <li><a data-num="${responseDTO.start - 1}" class="px-4 py-2 bg-gray-800 text-white rounded-l-md hover:bg-gray-700 hover:pointer-events-auto">Previous</a></li>
            </c:if>
            <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                <li><a data-num="${num}" class="px-4 py-2 bg-gray-800 text-white hover:bg-gray-700 hover:pointer-events-auto">${num}</a></li>
            </c:forEach>
            <c:if test="${responseDTO.next}">
                <li><a data-num="${responseDTO.end + 1}" class="px-4 py-2 bg-gray-800 text-white rounded-r-md hover:bg-gray-700 hover:pointer-events-auto">Next</a></li>
            </c:if>
        </ul>
    </div>
    <script>
        document.querySelector(".pagination").addEventListener("click", (e) =>{
          e.preventDefault();
          e.stopPropagation();

          const target = e.target;

          if(target.tagName !== 'A'){
            return
          }
          const num = target.getAttribute("data-num");

          self.location = `/todo/list?page=\${num}`;

        }, false)
    </script>

</div>

</body>
</html>
