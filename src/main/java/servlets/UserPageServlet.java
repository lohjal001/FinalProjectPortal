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

        //This method should pick up query from csv file, send it to the correct jsp userpage depending on the user type that has logged in
        //both bean and id is stored in sessions (no timed session yet)
        //I cant get it to work, i was able to get the database headers out at one point but now i cant even see them :P

        UserBean usersBean = new UserBean();
        UserBean userBean = (UserBean) req.getSession().getAttribute("UserBean");
        String studentID = (String) req.getSession().getAttribute("studentID");
        //String teacherID = (String) req.getSession().getAttribute("teacherID");


        if (userBean.getUserType().equals(UserBean.USER_TYPE.student)) {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("studentCourseInfo", studentID);
            usersBean.setData(data);
           // req.getSession().setAttribute("UserBean", usersBean);
           // req.getSession().setAttribute("studentID", studentID);
            req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);


        } else {
            LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("teacherCourseInfo");
            usersBean.setData(data);
            req.getSession().setAttribute("UserBean", usersBean);
            req.getRequestDispatcher("JSP/fragments/teacher/teacherUserPage.jsp").forward(req, resp);
        }

        //System.out.println();
        //req.getRequestDispatcher("JSP/userPage.jsp").forward(req,resp);
        //req.getRequestDispatcher("JSP/fragments/student/studentUserPage.jsp").forward(req, resp);
        //RIGHT NOW - student comes here after they submit log in and then gets sent to jsp.. not sure how to get the post method involved :P

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