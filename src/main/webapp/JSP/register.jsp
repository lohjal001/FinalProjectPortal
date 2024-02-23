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

        <%@ include file="fragments/admin/registerNavbar.jsp" %>


</nav>
<div>
        <form action="/fragments/admin/registerStudent" method="POST"><input type="submit" name="addStudent" value="ADD STUDENT"></form>
        <form action="/fragments/admin/registerTeacher" method="POST"><input type="submit" name="addTeacher" value="ADD TEACHER"></form>

</div>


<%@ include file="fragments/footer.jsp" %>

</body>
</html>