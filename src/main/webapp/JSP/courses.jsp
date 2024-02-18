<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@ include file="fragments/header.jsp" %>
<style>
    table {
        width: 70%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 5px;
    }
</style>
<body>
<%@ include file="fragments/navbar.jsp" %>

 <table>
        <thead>
            <tr>
                <th>Course</th>
                <th>Points</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>

<c:forEach items="${UserBean.data }" var="dataPoint">
    <tr>
        <td>${dataPoint[0]}</td>
        <td>${dataPoint[1]}</td>
        <td>${dataPoint[2]}</td>
    </tr>
</c:forEach>
</body>
</table>

<%@ include file="fragments/footer.jsp" %>


</body>
</html>