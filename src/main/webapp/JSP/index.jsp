<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
    body{
        background-color: #DBDBD1;
    }
    h1{
        color: black;
        font-family: "Times New Roman", serif;
        font-size: xx-large;
    }
</style>

<link rel="stylesheet" type="text/css" href="/styles.css">

<%@ include file="fragments/header.jsp" %>
<body>
<nav>
    <div class="banner">

        <%@ include file="fragments/navbar.jsp" %>

    </div>
</nav>


<h1>Welcome to Grit Academy Portal</h1>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>