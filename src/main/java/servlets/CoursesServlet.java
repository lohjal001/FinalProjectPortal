package servlets;

import models.MySQLConnector;
import models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

//servlets are processing requests and stores the data in java beans variables, servlets forwards request to JSP for presentation, jsp page retrives data from java bean


@WebServlet("/courses")
public class CoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
        LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("allCourses");
        UserBean usersBean = new UserBean();
        usersBean.setData(data);

        req.getSession().setAttribute("UserBean", usersBean);

        System.out.println(((UserBean)(req.getSession().getAttribute("UserBean"))).getData());

        req.getRequestDispatcher("JSP/courses.jsp").forward(req,resp);


        }catch (Exception e){
            System.out.println("error");

        }
        //error should send to an error page, add error.jsp file
            //req.setAttribute("error", e.getMessage());
          //  req.getRequestDispatcher("error.jsp").forward(req, resp);

        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
