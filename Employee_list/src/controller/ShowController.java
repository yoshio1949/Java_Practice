package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
/**
 * Servlet implementation class ShowController
 */
@WebServlet(name="ShowController", urlPatterns={"/employee/*", "/ShowController"})
public class ShowController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final String URL = "jdbc:mysql://localhost/study";
    private final String USER = "study";
    private final String PASSWORD = "diamond-f";
    /**y
     * @see HttpServlet#HttpServlet()
     */
    public ShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //URLから社員IDを取得
        String urlId = request.getPathInfo();
        int employeeId = Integer.parseInt(urlId.replace("/", ""));
        // データを格納するList
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM employee WHERE employee_id = " + employeeId);

            while(res.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(res.getInt("employee_id"));
                employee.setEmployeeName(res.getString("employee_name"));
                employee.setAge(res.getInt("age"));
                employee.setAddress(res.getString("address"));
                employee.setDepartmentId(res.getInt("department_id"));
                employee.setDate(res.getDate("hire_date").toLocalDate());
                list.add(employee);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("list", list);
        
        String view = "/WEB-INF/view/show.jsp";
//      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(view);
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //URLから社員IDを取得
        String urlId = request.getPathInfo();
        int employeeId = Integer.parseInt(urlId.replace("/", ""));
        //文字コードを指定
        request .setCharacterEncoding("utf-8");
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "update employee set "
                    + "employee_name=?, address=?" 
                    + "where employee_id=" + employeeId  ;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, request.getParameter("employeeName"));
            pstmt.setString(2, request.getParameter("address"));
            pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if (con != null) {
                    con.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }


//    	response.sendRedirect("/employee-list/employee/" + employeeId);
        response.sendRedirect("/employee-list/IndexController");
    }

}
