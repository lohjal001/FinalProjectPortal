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


<c:forEach items="${UserBean.data }" var="dataPunkt">
    <tr>
        <td>${dataPunkt[1]}</td>
        <td>${dataPunkt[2]}</td>
        <td>${dataPunkt[3]}</td>
        <td>${dataPunkt[4]}</td>
    </tr>
</c:forEach>
</table>

<%@ include file="fragments/footer.jsp" %>


</body>
</html>