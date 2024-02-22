package servlets;

import com.sun.tools.javac.comp.Todo;
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

        UserBean usersBean = req.getSession().getAttribute("userBean") != null ? (UserBean) req.getSession().getAttribute("userBean") : null;

        // UserBean usersBean = (UserBean) req.getSession().getAttribute("userBean");
        try {
            if (usersBean != null && usersBean.getUserType() == UserBean.USER_TYPE.student && usersBean.getStateType() == UserBean.STATE_TYPE.confirmed) {

                LinkedList<String[]> data = null;
                LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("studentCourseInfo", ((UserBean) req.getSession().getAttribute("userBean")).getID());
                for (String[] course : courses) {
                    for (String courseInfo : course) {
                        System.out.print(courseInfo + " ");
                    }
                    System.out.println();
                }
                data = courses;


                //String dataPoint = req.getParameter("dataPoint");
                LinkedList<String[]> dataS = null;
                LinkedList<String[]> classmates = MySQLConnector.getConnector().selectQuery("showClassmates", ((UserBean) req.getSession().getAttribute("userBean")).getID());
                System.out.println(classmates);
                for (String[] students : classmates) {
                    for (String studentInfo : students) {
                        System.out.print(studentInfo + " ");
                    }
                }
                dataS = classmates;



                req.setAttribute("data", data);
                req.setAttribute("courses", courses);
                req.setAttribute("dataS", dataS);
                req.setAttribute("classmates", classmates);
                // usersBean.setData(courses);
                req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);


            } else if (usersBean != null &&
                    usersBean.getUserType() == UserBean.USER_TYPE.teacher &&
                    usersBean.getPrivilageType() == UserBean.PRIVILAGE_TYPE.user &&
                    usersBean.getStateType() == UserBean.STATE_TYPE.confirmed) {

                LinkedList<String[]> data = null; //sätter data lista till 0 så vi kan spara "courses" i den
                LinkedList<String[]> courses = MySQLConnector.getConnector().selectQuery("teacherCourseInfo", ((UserBean) req.getSession().getAttribute("userBean")).getID());

                //TO CHECK IF DATA PRINTS OUT


            } else {
                resp.sendRedirect(req.getContextPath() + "/login");

                System.out.println(); //  to the next line for each course
            }
        }catch (Exception e) {
            System.out.println(" wrong ");
        }
    }


    public static void allStudentsCoursesTeachers(UserBean usersBean,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkedList<String[]> data = null; //sätter data lista till 0 så vi kan spara "andra quries i den
        LinkedList<String[]> allTables = MySQLConnector.getConnector().selectQuery("allStudentsCoursesTeachers", ((UserBean) req.getSession().getAttribute("userBean")).getID());
        data = allTables;
        req.setAttribute("data", data);
        req.setAttribute("allTables", allTables);
        // usersBean.setData(allTables);
        req.getRequestDispatcher("JSP/userPage.jsp").forward(req, resp);

    }

    public static void allCourses() {

    }

    public static void allStudents() {

    }

}