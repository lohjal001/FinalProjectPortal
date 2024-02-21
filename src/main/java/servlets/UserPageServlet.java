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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean userBean = req.getSession().getAttribute("userBean") != null ? (UserBean) req.getSession().getAttribute("userBean") : null;


        System.out.println(userBean);
        if (userBean != null && userBean.getUserType().equals(UserBean.USER_TYPE.student) && userBean.getStateType().equals((UserBean.STATE_TYPE.confirmed))) {
            LinkedList<String[]> data = null;
            LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("studentCourseInfo", ((UserBean) req.getSession().getAttribute("UserBean")).getID());


            System.out.println("userpage servlet got here1");

            if (req.getParameter("studentSubmitButton") != null) {
                data = MySQLConnector.getConnector().selectQuery("studentCourseInfo", req.getParameter("courseId"));
                System.out.println("userpage servlet got here2");
            } else {
                data = courses;
            }

            req.setAttribute("data", data);
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);
            req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);
            System.out.println("userpage servlet got here3");


            System.out.println("got here");


        } else if (userBean != null && userBean.getUserType().equals(UserBean.USER_TYPE.teacher) && userBean.getStateType().equals((UserBean.STATE_TYPE.confirmed))) {

            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("teacherCourseInfo");
            req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

        } else {
            req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);
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