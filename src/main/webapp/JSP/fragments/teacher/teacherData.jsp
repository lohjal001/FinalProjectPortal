<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" type="text/css" href="/styles.css">
<script src=https://cdn.tailwindcss.com></script>
        <h1>Your Classes</h1>

    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Course Id</th>
            <th>Course</th>
            <th>YHP</th>
            <th>Description</th>
             <th>Teacher First Name</th>
            <th>Teacher Last Name</th>



        </tr>

            <c:forEach items="${courses}" var="courseData">
                <tr>
                        <td>${courseData[0]}</td>
                        <td>${courseData[1]}</td>
                        <td>${courseData[2]}</td>
                        <td>${courseData[3]}</td>
                        <td>${courseData[4]}</td>
                        <td>${courseData[5]}</td>
                        <td>${courseData[6]}</td>
                        <td>${courseData[7]}</td>
                        <td>${courseData[8]}</td>
                        <td>${courseData[9]}</td>



                </tr>
            </c:forEach>

    </table>
</html>