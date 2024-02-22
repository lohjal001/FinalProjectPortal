<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Town</th>
            <th>Phone</th>
            <th>Email</th>

        </tr>

            <c:forEach items="${allStudents}" var="allS">
                <tr>
                        <td>${allS[0]}</td>
                        <td>${allS[1]}</td>
                        <td>${allS[2]}</td>
                        <td>${allS[3]}</td>
                        <td>${allS[4]}</td>
                        <td>${allS[5]}</td>
                </tr>
            </c:forEach>

    </table>
</div>