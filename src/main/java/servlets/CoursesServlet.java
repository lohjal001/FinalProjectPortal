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

@WebServlet("/courses")
public class CoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LinkedList data = MySQLConnector.getConnector().selectQuery("allCourses");
        UserBean usersBean = new UserBean();
        usersBean.setData(data);

        req.getSession().setAttribute("UserBean", usersBean);
        System.out.println(((UserBean)(req.getSession().getAttribute("UserBean"))).getData());

        req.getRequestDispatcher("JSP/courses.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
