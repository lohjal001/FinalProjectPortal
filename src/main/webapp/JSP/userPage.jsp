<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="/styles.css">

<html>
<%@ include file="fragments/header.jsp" %>

<body>
<c:choose>
    <c:when test="${userBean.userType == 'student' && userBean.stateType == 'confirmed'}">
        <%@ include file="fragments/student/studentUserPage.jsp" %>
    </c:when>
    <c:when test="${userBean.userType == 'teacher' && userBean.privilageType == 'user' && userBean.stateType == 'confirmed'}">
        <%@ include file="fragments/teacher/teacherUserPage.jsp" %>
    </c:when>
    <c:when test="${userBean.userType == 'teacher' && userBean.privilageType == 'admin' && userBean.stateType == 'confirmed'}">
        <%@ include file="fragments/admin/adminUserPage.jsp" %>
    </c:when>
</c:choose>
<nav>

        <%@ include file="fragments/navbar.jsp" %>

</nav>


<%@ include file="fragments/footer.jsp" %>

</body>
</html>