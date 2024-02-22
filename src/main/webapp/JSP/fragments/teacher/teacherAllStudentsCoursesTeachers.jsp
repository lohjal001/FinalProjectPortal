<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <h1>All students in all courses</h1>

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

            <c:forEach items="${allTables}" var="SCTData">
                <tr>
                        <td>${SCTData[0]}</td>
                        <td>${SCTData[1]}</td>
                        <td>${SCTData[2]}</td>
                        <td>${SCTData[3]}</td>
                        <td>${SCTData[4]}</td>
                        <td>${SCTData[5]}</td>
                        <td>${SCTData[6]}</td>
                        <td>${SCTData[7]}</td>
                        <td>${SCTData[8]}</td>
                        <td>${SCTData[9]}</td>

                </tr>
            </c:forEach>

    </table>
