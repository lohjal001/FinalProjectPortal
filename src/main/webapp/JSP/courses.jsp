<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="/styles.css">

<html>
<%@ include file="fragments/header.jsp" %>

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
<c:forEach items="${UserBean.data }" var="dataPoint">
    <tr>
        <td>${dataPoint[0]}</td>
        <td>${dataPoint[1]}</td>
        <td>${dataPoint[2]}</td>
    </tr>
</c:forEach>
 </table>
</body>
</html>