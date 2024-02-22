<link rel="stylesheet" href="/styles.css">
<navbar id="studentNavbar">
    <div class='navbar'>
        <nav>
            <ul>
                <li><a href="/">HOME</a></li>
                <li><a href="/courses">COURSES</a></li>
                <li><a href="/login">LOGIN</a></li>
                <li><a href="/userPage">USERPAGE</a></li>
            </ul>
                </div>

                    <form action="/userPage" method="post">
                        <select id="user_type" name="courseId">
                            <c:forEach items="${courses}" var="dataPoint">
                                <option value="${dataPoint[0]}">${dataPoint[1]}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" id="showClassmates" name="studentSubmitButton" value="Show My Classmates">

                        <button onclick=location.href='/userPage'>Go Back</button>
                        <input type="button" value="Log Out" name="logOut">
                    </form>
        </nav>
</navbar>