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

    <table2>

        <c:forEach items="${classmates}" var="classmates">
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
                <td>${courseData[10]}</td>
                <td>${courseData[11]}</td>
                <td>${courseData[12]}</td>
                <td>${courseData[13]}</td>


            </tr>
        </c:forEach>

    </table2>
</div>