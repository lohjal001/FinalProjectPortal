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

        //This method should pick up query from csv file, send it to the correct jsp userpage depending on the user type that has logged in
        //Cannot reach data yet... and its not working in the POST method (?)

        try {
            UserBean usersBean = (UserBean) req.getSession().getAttribute("UserBean"); //getting the login info saved in bean

            if (usersBean.getUserType().equals(UserBean.USER_TYPE.student)) {
                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("studentCourseInfo");
                req.setAttribute("data", data);
                req.getSession().setAttribute("UserBean", usersBean);
                req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);

            } else {
                LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("teacherCourseInfo");
                usersBean.setData(data); //not sure of we should use req.setAttribute or userBean.setData, is it the exact same?
                req.getSession().setAttribute("UserBean", usersBean);
                req.getRequestDispatcher("JSP/fragments/teacher/teacherUserPage.jsp").forward(req, resp);
            }

            //System.out.println();
            //req.getRequestDispatcher("JSP/userPage.jsp").forward(req,resp);
            //req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);


        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/error.jsp"); //make jsp error opage

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

}
}
/*
Userpage servlet should contain
- Student user connected to JSP file with student courses
- Teacher user connected to JSP file courses/students/student courses/teacher courses
- Teacher admin connected to JSP file with all tables and CRUD privilages on everything
 */