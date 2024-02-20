<link rel="stylesheet" href="/styles.css">
<form id="registerForm" action="/register" method="post">
   <label for="fname">First name:</label>
   <input type="text" id="fname" name="fname"></input><b>
   <label for="lname">Last name:</label>
   <input type="text" id="lname" name="lname"></input><b>
   <label for="town">Town:</label>
   <input type="text" id="town" name="town" required></input><br>
   <label for="email">Email:</label>
   <input type="text" id="email" name="email" required></input><br>
   <label for="phone">Phone:</label>
   <input type="text" id="phone" name="phone" required></input><br>
   <label for="username">Username:</label>
   <input type="text" id="username" name="username" required></input><br>
   <label for="password">Password:</label>
   <input type="password" id="password" name="password" required></input><br>
   <label for="privilege_type">Privilege Type:</label>
   <select id="privilege_type" name="privilege_type">
   <option value="user">User</option>
   <option value="admin">Admin</option>
   </select>
   <input type="submit" name="register" value="Register"></input>
   </form>
