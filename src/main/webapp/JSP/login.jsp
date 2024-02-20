<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<link rel="stylesheet" href="/styles.css">


<%@ include file="fragments/header.jsp" %>
<body>
<nav>
    <div class="banner">

        <%@ include file="fragments/navbar.jsp" %>

    </div>
</nav>
<main>
    <%@ include file="fragments/loginForm.jsp" %>

</main>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>