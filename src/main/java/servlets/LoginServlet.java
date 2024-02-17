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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println();

        req.getRequestDispatcher("JSP/login.jsp").forward(req,resp);
    } //forwards the request to the JSP file that has the log in form

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doPost method handles the form submission, retrives users inputs from the request, then we query the database based on usertype (student or teacher)

        resp.setContentType("text/html");
        //hämta data från loginForm
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");

        //jämför data med databas student o teacher
        if(userType.equals("student")){
            List data = MySQLConnector.getConnector().selectQuery("loginStudent",username,password);
            if(!data.isEmpty())resp.getWriter().print("Logged in as student!");
            UserBean userBean = new UserBean();
            userBean.setUserPrivilage(UserBean.PRIVILAGE_TYPE.user);



        } else if (userType.equals("teacher")) {
            List data = MySQLConnector.getConnector().selectQuery("loginTeacher",username,password);
            if(!data.isEmpty())resp.getWriter().print("Logged in as teacher!");


            //after user are logged in, sessions should start
        }

        //resp.getWriter().print(username+" "+password+" "+userType);
    }
}
