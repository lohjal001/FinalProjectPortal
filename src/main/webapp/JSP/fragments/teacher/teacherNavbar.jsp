<navbar id="teacherNavbar">
    <div class='navbar'>
        <nav>
            <ul>
                <li><a href="/">HOME</a></li>
                <li><a href="/courses">COURSES</a></li>
                <li><a href="/login">LOGIN</a></li>
                <li><a href="/userPage">USERPAGE</a></li>
            </ul>
    </div>

    <div>
        <select id="user_type" name="courseId">
            <c:forEach items="${courses}" var="dataPoint">
                <option value="${dataPoint[0]}">${dataPoint[1]}</option>
            </c:forEach>
        </select>

        <li><form action="/logout" method="POST"><input type="submit" name="logout" value="LOGOUT"></form></li>
    </div>
    </nav>
</navbar>