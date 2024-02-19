<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

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

<h1>"heyyyyy student user page"</h1>

 <table>
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Course</th>
                <th>Points</th>
                <th>Description</th>
                <th>Teacher</th>


            </tr>
        </thead>
        <tbody>

<c:forEach items="${UserBean.data }" var="dataPoint">
    <tr>
        <td>${dataPoint[0]}</td>
        <td>${dataPoint[1]}</td>
        <td>${dataPoint[2]}</td>
        <td>${dataPoint[3]}</td>
        <td>${dataPoint[4]}</td>
    </tr>
</c:forEach>
</body>
</table>
</body>
</html>