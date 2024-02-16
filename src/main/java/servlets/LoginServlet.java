package servlets;

import models.MySQLConnector;
import models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println();

        req.getRequestDispatcher("JSP/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //hämta data från loginForm
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");

        //jämför data med databas student o teacher
        if(userType.equals("student")){
            List data = MySQLConnector.getConnector().selectQuery("studentLogin",username,password);
            if(!data.isEmpty())resp.getWriter().print("Logged in!");
            UserBean userBean = new UserBean();
            //userBean.setUserPrivilage(UserBean.PRIVILAGE_TYPE.user);

        } else if (userType.equals("teacher")) {

        }

        //resp.getWriter().print(username+" "+password+" "+userType);
    }
}
