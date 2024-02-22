<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
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

<<<<<<< Updated upstream
            <c:forEach items="${allTables}" var="allSCT">
                <tr>
                        <td>${allSCT[0]}</td>
                        <td>${allSCT[1]}</td>
                        <td>${allSCT[2]}</td>
                        <td>${allSCT[3]}</td>
                        <td>${allSCT[4]}</td>
                        <td>${allSCT[5]}</td>
                        <td>${allSCT[6]}</td>
                        <td>${allSCT[7]}</td>
                        <td>${allSCT[8]}</td>
                        <td>${allSCT[9]}</td>
=======
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
>>>>>>> Stashed changes



                </tr>
            </c:forEach>

    </table>
</div>