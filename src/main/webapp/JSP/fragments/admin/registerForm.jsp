<link rel="stylesheet" href="/styles.css">
<html>
<form id="registerForm" action="/register" method="post">
   <label for="fname">First name:</label>
   <input type="text" id="fname" name="fname"><br>
   <label for="lname">Last name:</label>
   <input type="text" id="lname" name="lname"><br>
   <label for="town">Town:</label>
   <input type="text" id="town" name="town" required><br>
   <label for="email">Email:</label>
   <input type="text" id="email" name="email" required><br>
   <label for="phone">Phone:</label>
   <input type="text" id="phone" name="phone" required><br>
   <label for="username">Username:</label>
   <input type="text" id="username" name="username" required><br>
   <label for="password">Password:</label>
   <input type="password" id="password" name="password" required><br>
   <label for="privilege_type">Privilege Type:</label>
   <select id="privilege_type" name="privilege_type">
   <option value="user">User</option>
   <option value="admin">Admin</option>
   </select>
   <input type="submit" name="register" value="Register">
   </form>
</html>