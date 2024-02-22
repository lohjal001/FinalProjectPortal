<navbar id="teacherNavbar">
    <div class='navbar'>
        <nav>
                <a href="/">HOME</a><br>
                <a href="/courses">COURSES</a><br>
                <a href="/login">LOGIN</a><br>
               <a href="/register">REGISTER</a><br>
                <a href="/userPage">USERPAGE</a>
    </div>

        <select id="user_type" name="courseId">
            <c:forEach items="${courses}" var="dataPoint">
                <option value="${dataPoint[0]}">${dataPoint[1]}</option>
            </c:forEach>
        </select>

        <li><form action="/logout" method="POST"><input type="submit" name="logout" value="LOGOUT"></form></li>

    </nav>
</navbar>