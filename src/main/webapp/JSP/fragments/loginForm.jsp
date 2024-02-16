<form id="loginForm" action="/login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <input type="submit" id="loginSubmit" name="loginSubmit">
    <select id="user_type" name="userType">
        <option value="Student">Student</option>
        <option value="Teacher">Teacher</option>
    </select>
    <input type="submit" id="loginForm" name="LogInForm">
</form>