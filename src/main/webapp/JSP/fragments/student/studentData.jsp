<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Id</th>
            <th>Courses</th>
            <th>YHP</th>
            <th>Description</th>
             <th>student</th>
            <th>teachers</th>


        </tr>

            <c:forEach items="${courses}" var="courseData">
                <tr>
                        <td>${courseData[0]}</td>
                        <td>${courseData[1]}</td>
                        <td>${courseData[2]}</td>
                        <td>${courseData[3]}</td>
                        <td>${courseData[4]}</td>
                        <td>${courseData[5]}</td>

                </tr>
            </c:forEach>

    </table>
</div>