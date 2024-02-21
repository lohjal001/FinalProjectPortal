package servlets;

import models.MySQLConnector;
import models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    String studentID;
    String teacherID;

    private static Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
        doPost(req, resp);

    } //forwards the request to the JSP file that has the log in form

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doPost method handles the form submission, retrives users inputs from the request, then we query the database based on usertype (student or teacher)
        try {
            resp.setContentType("text/html");
            //hämta data från loginForm
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String userType = req.getParameter("userType");

            //UserBean usersBean = new UserBean();


            //jämför data med databas student o teacher
            if (userType.equals("Student")) {
                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("loginStudent", username, password);
                System.out.println("here1");

                if (data.size()>1) {
                 //   studentID = result.getString("id"); // retrieve the student ID from the result
                    //  resp.getWriter().print("Logged in as student!");
                    System.out.println("here2");

                    UserBean usersBean = new UserBean(studentID, UserBean.USER_TYPE.student, UserBean.PRIVILAGE_TYPE.user, UserBean.STATE_TYPE.confirmed);

                    usersBean.setData(data);
                    req.getSession().setAttribute("UserBean", usersBean);
                    req.getSession().setAttribute("studentID", studentID);
                    req.getSession().setMaxInactiveInterval(1);

                    System.out.println("here3");

                    req.getRequestDispatcher("/userPage").forward(req,resp);
                  //  resp.sendRedirect(req.getContextPath() + "/userPage");


                    //System.out.println(((UserBean)(req.getSession().getAttribute("UserBean"))).getData());

                } else if (userType.equals("Teacher")) {
                    LinkedList<String[]> dataT = MySQLConnector.getConnector().selectQuery("loginTeacher");


                    if (dataT.size()>1 && !username.isEmpty() && !password.isEmpty()) {
                        resp.getWriter().print("Logged in as teacher!");
                        //teacherID = result2.getString("id"); //keep the id in session

                        UserBean usersBean = new UserBean(teacherID, UserBean.USER_TYPE.student, UserBean.PRIVILAGE_TYPE.user, UserBean.STATE_TYPE.confirmed);

                        //req.getRequestDispatcher("JSP/fragments/student/teacherUserPage.jsp").forward(req, resp);
                        resp.getWriter().print(username+" "+password+" "+userType);
                        req.getSession().setAttribute("UserBean", usersBean);
                        resp.sendRedirect(req.getContextPath() + "/userPage");

                        //System.out.println(((UserBean)(req.getSession().getAttribute("UserBean"))).getData());
                        //req.getSession().setMaxInactiveInterval(1);

                    } else {
                        req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
                        System.out.println("could not log in");
                        //add error message
                    }
                        //after user are logged in, sessions should start


                    }
                }
            } catch(Exception e) {
            //add error message
        }
    }
}

                /* Den gamla koden - av någon anledning kunde jag inte få koden att jämföra med databasen, vem som helst kunde logga in

              if (userType.equals("Students")) {
               LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("loginStudent", username, password);
              if (!data.isEmpty()) resp.getWriter().print("Logged in as student!");
              resp.sendRedirect(req.getContextPath() + "/userPage");
             // userBean.setUserPrivilage(UserBean.PRIVILAGE_TYPE.user);

            } else if (userType.equals("Teacher")) {
                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("teacherLogin", username, password);
                if (!data.isEmpty()) // for some reason the data is not comparing to the database and anyone can log in
                    resp.getWriter().print("Logged in as teacher!");
                req.getRequestDispatcher("JSP/fragments/teacher/teacherUserPage.jsp").forward(req, resp);

            /*
                //adding for loop to check specifically if username and password are matching //NOPE the data list is not comparing to database here?
                for (String[] row:data){
                    String dbusername = row[6];
                    String dbpassword = row[7];

                    if (username.equals(dbusername) && password.equals(dbpassword)){

             */
