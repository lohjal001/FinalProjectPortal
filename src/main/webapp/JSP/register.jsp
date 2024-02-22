<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<link rel="stylesheet" type="text/css" href="/styles.css">

<%@ include file="fragments/header.jsp" %>
<body>
<nav>

        <%@ include file="fragments/navbar.jsp" %>


</nav>

<input type="button" name="add_student" onclick="addStudent"> Register new student</input>
<input type="button" name="add_teacher"> Register new teacher</input>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>