<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<nav>
    <%@ include file="teacherNavbar.jsp" %>
</nav>

<body>
<h1>My Teacher Page</h1>

<input type="submit" name="allStudents" value="Show All Students">
<input type="submit" name="allTeachers" value="Show All Teachers">
<input type="submit" name="allSCTSubmit" value="Show All Students/Courses/Teachers">



<%@ include file="teacherData.jsp" %>


<<<<<<< Updated upstream
<form id="submitAllTables" action="/userPage" method="post">
<input type="submit" name="allSCTSubmit" value="Show All Students/Courses/Teachers">
</form>

<%@ include file="teacherAllStudentsCoursesTeachers.jsp" %>

<form id="submitAllStudents" action="/userPage" method="post">
<input type="submit" name="allStudents" value="Show All Students">
</form>

<%@ include file="teacherAllStudents.jsp" %>


<form id="submitAllTeachers" action="/userPage" method="post">
<input type="submit" name="allTeachers" value="Show All Teachers">
</form>

<%@ include file="teacherAllCourses.jsp" %>

=======
<%@ include file="teacherAllStudentsCoursesTeachers.jsp" %>
<%@ include file="teacherAllStudents.jsp" %>
<%@ include file="teacherAllCourses.jsp" %>


>>>>>>> Stashed changes

</body>
</html>