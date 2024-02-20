<link rel="stylesheet" href="/styles.css">
<navbar id="studentNavbar">
    <banner>
        <div class="banner">
        </div>
    </banner>
    <div class='navbar'>
        <nav>
            <ul>
                <li><a href="/">HOME</a></li>
                <li><a href="/courses">COURSES</a></li>
                <li><a href="/login">LOGIN</a></li>
                <li><a href="/userPage">USERPAGE</a></li>
            </ul>
                    <form action="/userPage" method="post">
                        <select id="user_type" name="courseId">
                            <c:forEach items="${courses}" var="dataPunkt">
                                <option value="${dataPunkt[0]}">${dataPunkt[1]}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" id="studentSubmit" name="studentSubmitButton" value="Show Details">
                        <button onclick=location.href='/userPage'>Go Back</button>
                    </form>
        </nav>
    </div>
</navbar>