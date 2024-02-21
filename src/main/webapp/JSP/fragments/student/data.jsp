<table id="data table">
    <c:forEach items="${data}" var="dataList">
         <tr>
        <c:forEach items="${dataList}" var="dataListan">
                <td>${dataListan}</td>
        </c:forEach>
         </tr>
    </c:forEach>
</table>