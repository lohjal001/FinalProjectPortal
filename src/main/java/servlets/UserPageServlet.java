package servlets;

import models.MySQLConnector;
import models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println();
        //req.getRequestDispatcher("JSP/userPage.jsp").forward(req,resp);
        req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");

        if (userBean.getUserType().equals(UserBean.USER_TYPE.student)) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("studentCourseInfo");
            UserBean usersBean = new UserBean();
            usersBean.setData(data);
            req.getSession().setAttribute("UserBean", usersBean);
            req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);
            //in student user page there will be a table with courses that student is taking, along with the other students in the same course and which teacher is is

        }

    }
}

/*
Userpage servlet should contain
- Student user connected to JSP file with student courses
- Teacher user connected to JSP file courses/students/student courses/teacher courses
- Teacher admin connected to JSP file with all tables and CRUD privilages on everything
 */