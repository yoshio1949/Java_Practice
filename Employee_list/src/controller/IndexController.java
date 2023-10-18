package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    //DB接続用の値を定数に定義
    private static final String URL = "jdbc:mysql://localhost/study";
    private static final String USER = "study";
    private static final String PASSWORD = "diamond-f";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // データを格納するList
        List<Employee> list = new ArrayList<>();

        // 文字コードを指定
        request.setCharacterEncoding("utf-8");
        // formから値を取得
        String keyword = request.getParameter("keyword");

        Connection con = null;
        
        //検索窓に単語が入っていない場合
        if (keyword == null ) {
            try {
                // JDBCドライバの検出
                Class.forName("com.mysql.cj.jdbc.Driver");
                // データベースへの接続
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                // データベースへのアクセス
                Statement st = con.createStatement();
                // SQL文の入力
                ResultSet res = st.executeQuery("SELECT * FROM employee");

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
                //DBに接続されている場合、切断する
                try{
                    if (con != null) {
                        con.close();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement st = con.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM employee WHERE employee_name Like '%" + keyword +"%'");

                while(res.next()) {
                    Employee employee = new Employee();
                    employee.setEmployeeId(res.getInt("employee_id"));
                    employee.setEmployeeName(res.getString("employee_name"));
                    employee.setAge(res.getInt("age"));
                    employee.setAddress(res.getString("address"));
                    employee.setDepartmentId(res.getInt("department_id"));
                    //    					employee.setDate(res.getDate("hire_date"));
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
        }

        request.setAttribute("list", list);

        // viewにindex.jspのリンクを代入する
        String view = "WEB-INF/view/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
