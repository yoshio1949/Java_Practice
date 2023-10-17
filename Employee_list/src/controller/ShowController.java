package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		//データベースに接続するための情報
    	String url = "jdbc:mysql://localhost/study";
    	String user = "study";
    	String password = "diamond-f";
    	// データを格納するList
    	List<Employee> list = new ArrayList<>();
    	try {
			// JDBCドライバの検出
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password); // データベースへの接続
					// データベースへのアクセス
					Statement st = con.createStatement();){
				// SQL文の入力
				ResultSet res = st.executeQuery("SELECT * FROM employee WHERE employee_id = " + employeeId);

				while(res.next()) {
					Employee employee = new Employee();
					employee.setEmployeeId(res.getInt("employee_id"));
					employee.setEmployeeName(res.getString("employee_name"));
					employee.setAge(res.getInt("age"));
					employee.setAddress(res.getString("address"));
					employee.setDepartmentId(res.getInt("department_id"));
//					employee.setDate(res.getDate("hire_date"));
					list.add(employee);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("list", list);
    	
    	// viewにindex.jspのリンクを代入する
    	String view = "/WEB-INF/view/show.jsp";
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(view);
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
		//データベースに接続するための情報
    	String url = "jdbc:mysql://localhost/study";
    	String user = "study";
    	String password = "diamond-f";
    	
    	try {
    		//JDBCドライバの検出
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		try (Connection con = DriverManager.getConnection(url, user, password);){
    			String sql = "update employee set "
    					+ "employee_name=?, address=?" 
    					+ "where employee_id=" + employeeId  ;
    			PreparedStatement pstmt = con.prepareStatement(sql);
    			pstmt.setString(1, request.getParameter("employeeName"));
    			pstmt.setString(2, request.getParameter("address"));
    			int count = pstmt.executeUpdate();
    			System.out.println(employeeId);
    		} catch(SQLException e) {
    			e.printStackTrace();
    		}
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
//    	response.sendRedirect("/employee-list/employee/" + employeeId);
    	response.sendRedirect("/employee-list/IndexController");
	}

}
