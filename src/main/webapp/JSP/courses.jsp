<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="/styles.css">
<script src=https://cdn.tailwindcss.com></script>

<%@ include file="fragments/header.jsp" %>
</head>
<body>
<nav>

    <%@ include file="fragments/navbar.jsp" %>
</nav>
<table>
    <thead>
    <tr>
        <th>Course</th>
        <th>Points</th>
        <th>Description</th>
    </tr>
    </thead>
<c:forEach items="${UserBean.data }" var="coursesData">
    <tr>
        <td>${coursesData[0]}</td>
        <td>${coursesData[1]}</td>
        <td>${coursesData[2]}</td>
    </tr>
</c:forEach>
 </table>
</body>
</html>