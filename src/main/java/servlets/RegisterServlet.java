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
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    String teacherID;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/JSP/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            resp.setContentType("text/html");

            //the privilege type should be set in session in the log in method when teacher admin logs in

            String stateType = (String) req.getSession().getAttribute("stateType");
            String userType = (String) req.getSession().getAttribute("userType");



            if (!stateType.equals("confirmed") && !userType.equals("teacher")) {

                    req.setAttribute("errorMessage", "you dont have privileges to perform this action");
                    req.getRequestDispatcher("JSP/login.jsp").forward(req, resp);

                } else {
                    req.getRequestDispatcher("JSP/register").forward(req, resp);
                    LinkedList<String[]> data = MySQLConnector.getConnector().selectQuery("studentInsert");

                    if (data.size()>1) {
                        System.out.println("here2");

                        UserBean usersBean = new UserBean("", UserBean.USER_TYPE.teacher, UserBean.PRIVILAGE_TYPE.admin, UserBean.STATE_TYPE.confirmed);

                        usersBean.setData(data);
                        req.getSession().setAttribute("UserBean", usersBean);
                        System.out.println("a new student was added to the database");

                } else {
                    System.out.println("NOPE - student was not added to database");
                }



            resp.sendRedirect(req.getContextPath() + "/addstudent"); //redirect back tio soget method so student list will show with new student
        }
            //hämta data från loginForm


                    //req.getRequestDispatcher("/userPage").forward(req,resp);
                    //  resp.sendRedirect(req.getContextPath() + "/userPage");


                    //System.out.println(((UserBean)(req.getSession().getAttribute("UserBean"))).getData());



        } catch(Exception e) {
            //add error message
        }
    }
}
