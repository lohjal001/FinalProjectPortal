<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="/styles.css">
<script src=https://cdn.tailwindcss.com></script>



<%@ include file="fragments/header.jsp" %>
</head>
<body>
<nav>
    <div class="banner">

        <%@ include file="fragments/navbar.jsp" %>

    </div>
</nav>
<c:if test="${not empty requestScope.errorMessage}">
    <p style="color: red;">${requestScope.errorMessage}</p>
</c:if>
<main>
    <%@ include file="fragments/loginForm.jsp" %>

</main>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>