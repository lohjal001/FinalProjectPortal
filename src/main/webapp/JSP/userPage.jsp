<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="/styles.css">

<html>
<style>
    body{
        background-color: #DBDBD1;
    }
    table {
        width: 70%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 5px;
    }
</style>

<%@ include file="fragments/header.jsp" %>

<body>
<nav>
    <div class="banner">

        <%@ include file="fragments/navbar.jsp" %>

    </div>
</nav>


<%@ include file="fragments/footer.jsp" %>

</body>
</html>