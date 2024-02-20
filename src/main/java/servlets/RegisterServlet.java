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
import java.util.LinkedList;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    String teacherID;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/JSP/fragments/admin/registerStudent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            resp.setContentType("text/html");
            //hämta data från loginForm


                    //req.getRequestDispatcher("/userPage").forward(req,resp);
                    //  resp.sendRedirect(req.getContextPath() + "/userPage");


                    //System.out.println(((UserBean)(req.getSession().getAttribute("UserBean"))).getData());



        } catch(Exception e) {
            //add error message
        }
    }
}
