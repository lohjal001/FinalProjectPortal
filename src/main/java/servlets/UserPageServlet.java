package servlets;

import models.MySQLConnector;
import models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }

        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< Updated upstream
            //This method should pick up query from csv file, send it to the correct jsp userpage depending on the user type that has logged in
            //Cannot reach data yet... and its not working in the POST method (?)


            UserBean usersBean = req.getSession().getAttribute("userBean") != null ? (UserBean) req.getSession().getAttribute("userBean") : null;

=======
            UserBean userBean = req.getSession().getAttribute("userBean") != null ? (UserBean) req.getSession().getAttribute("userBean") : null;
            UserBean usersBean = (UserBean) req.getSession().getAttribute("UserBean"); //getting the login info saved in bean
            System.out.println(usersBean);
            if (usersBean != null && usersBean.getUserType().equals(UserBean.USER_TYPE.student) && usersBean.getStateType().equals((UserBean.STATE_TYPE.confirmed))) {
>>>>>>> Stashed changes

          //  UserBean usersBean = (UserBean) req.getSession().getAttribute("UserBean"); //getting the login info saved in bean

            if (usersBean != null && usersBean.getUserType().equals(UserBean.USER_TYPE.student) && usersBean.getStateType().equals((UserBean.STATE_TYPE.confirmed))) {

                System.out.println("userpage servlet got here1");
                LinkedList<String[]> data = null;
                LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("EnrolledCoursesOverview", ((UserBean) req.getSession().getAttribute("UserBean")).getID());
                if (req.getParameter("studentSubmitButton") != null) {
                    System.out.println("userpage servlet got here2");
                } else {
                    data = courses;
                }

                req.setAttribute("courses", courses);
                req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
                req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);
                //LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("EnrolledCoursesOverview");
                //req.setAttribute("data", data);
<<<<<<< Updated upstream
                //req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);
                System.out.println("userpage servlet got here3");

                
=======

                System.out.println("got here");
>>>>>>> Stashed changes


            } else if (usersBean != null && usersBean.getUserType().equals(UserBean.USER_TYPE.teacher) && usersBean.getStateType().equals((UserBean.STATE_TYPE.confirmed))) {

                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("teacherCourseInfo");
                req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

            } else {
                System.out.println("userpage servlet something went wrong");
               // req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
            }

            //System.out.println();
            //req.getRequestDispatcher("JSP/userPage.jsp").forward(req,resp);
            //req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);
        }
    }


/*
Userpage servlet should contain
- Student user connected to JSP file with student courses
- Teacher user connected to JSP file courses/students/student courses/teacher courses
- Teacher admin connected to JSP file with all tables and CRUD privilages on everything
 */