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

    String studentID = "";
    String teacherID = "";

    private static Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
        // doPost(req, resp);

    } //forwards the request to the JSP file that has the log in form

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doPost method handles the form submission, retrives users inputs from the request, then we query the database based on usertype (student or teacher)
        try {
            //  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:4306/gritacademy", "user", "user");

            resp.setContentType("text/html");
            //hämta data från loginForm
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String userType = req.getParameter("userType");

            //UserBean usersBean = new UserBean();


            //jämför data med databas student o teacher
            if (userType.equals("Student")) {
                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("loginStudent", username, password);

                System.out.println(data.size());


                    if (data.size() > 1) {

                        UserBean usersBean = new UserBean("", UserBean.USER_TYPE.student, UserBean.PRIVILAGE_TYPE.user, UserBean.STATE_TYPE.confirmed);
                        usersBean.setID(data.get(1)[0]);

                        System.out.println("login servlet here2");

                        usersBean.setData(data);
                        req.getSession().setAttribute("userBean", usersBean);
                        req.getSession().setMaxInactiveInterval(420);

                        System.out.println("login servlet here3");

                        req.getRequestDispatcher("/userPage").forward(req, resp);


                    } else {
                        req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
                        req.setAttribute("errorMessage", "Invalid username or password");
                        System.out.println("could not log in");
                        UserBean usersBean = new UserBean();
                       // System.out.println(usersBean.getStateType());
                    }

                } else if (userType.equals("Teacher")) {
                    LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("loginTeacher", username, password);


                    if (data.size() > 1) {

                            UserBean usersBean = new UserBean("", UserBean.USER_TYPE.teacher, UserBean.PRIVILAGE_TYPE.user, UserBean.STATE_TYPE.confirmed);
                            usersBean.setID(data.get(1)[0]);
                            System.out.println("login servlet here2");

                            usersBean.setData(data);
                            req.getSession().setAttribute("userBean", usersBean);
                            req.getSession().setMaxInactiveInterval(420);
                            System.out.println("login servlet here3");


                        req.getRequestDispatcher("/userPage").forward(req, resp);

                    } else {
                        req.setAttribute("errorMessage", "Invalid username or password");
                        req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
                        System.out.println("could not log in");
                    }
                    //after user are logged in, sessions should start

                }
            } catch(Exception e){
            System.out.println("error log in"); //add error message
            req.setAttribute("errorMessage", "Something went wrong, try again");


        }
    }
}
