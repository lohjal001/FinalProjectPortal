<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Id</th>
            <th>Courses</th>
            <th>YHP</th>
            <th>Description</th>
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
        <table>
        <tr>
            <th>You</th>
            <th>Course</th>
            <th>Registered Students</th>


        </tr>

        <c:forEach items="${classmates}" var="classmatesData">
            <tr>
                <td>${classmatesData[0]}</td>
                <td>${classmatesData[1]}</td>
                <td>${classmatesData[2]}</td>
                <td>${classmatesData[3]}</td>
                <td>${classmatesData[4]}</td>
                <td>${classmatesData[5]}</td>
                <td>${classmatesData[6]}</td>
                <td>${classmatesData[7]}</td>

            </tr>
        </c:forEach>

        </table>

</div>