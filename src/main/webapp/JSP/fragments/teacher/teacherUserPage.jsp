<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/styles.css">
<script src=https://cdn.tailwindcss.com></script>
<nav>
    <%@ include file="teacherNavbar.jsp" %>
</nav>
</head>
<body>

<h1><b>My Teacher Page</b></h1>


<%@ include file="teacherData.jsp" %>

<%@ include file="teacherAllStudentsCoursesTeachers.jsp" %>

<%@ include file="teacherAllStudents.jsp" %>

<%@ include file="teacherAllCourses.jsp" %>

</body>
</html>