package subjectHello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// データベースに接続するための情報
		String url = "jdbc:mysql://localhost/study";
		String user = "study";
		String password = "diamond-f";
		
		// データを格納するList
		List<Employee> list = new ArrayList<>();

		// 文字コードを指定
		request.setCharacterEncoding("utf-8");
		// formから値を取得
		String keyword = request.getParameter("keyword");

		if (keyword == null ) {
			// データベースに接続する
			try {
				// JDBCドライバの検出
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				try (Connection con = DriverManager.getConnection(url, user, password); // データベースへの接続
						// データベースへのアクセス
						Statement st = con.createStatement();){
					// SQL文の入力
					ResultSet res = st.executeQuery("SELECT * FROM employee");
					
					while(res.next()) {
						Employee employee = new Employee();
						employee.setEmployeeId(res.getInt("employee_id"));
						employee.setEmployeeName(res.getString("employee_name"));
						employee.setAge(res.getInt("age"));
						employee.setAddress(res.getString("address"));
						employee.setDepartmentId(res.getInt("department_id"));
//					employee.setDate(res.getDate("hire_date"));
						
						
//					String[] data = new String[6];
//					
//					data[0] = res.getString("employee_id");
//					data[1] = res.getString("employee_name");
//					data[2] = res.getString("age");
//					data[3] = res.getString("address");
//					data[4] = res.getString("department_id");
//					data[5] = res.getString("hire_date");
//					list.add(data);
						list.add(employee);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				// JDBCドライバの検出
				Class.forName("com.mysql.cj.jdbc.Driver");

				try (Connection con = DriverManager.getConnection(url, user, password); // データベースへの接続
						// データベースへのアクセス
						Statement st = con.createStatement();){
					// SQL文の入力
					ResultSet res = st.executeQuery("SELECT * FROM employee WHERE employee_name Like '%" + keyword +"%'");
					
					while(res.next()) {
						Employee employee = new Employee();
						employee.setEmployeeId(res.getInt("employee_id"));
						employee.setEmployeeName(res.getString("employee_name"));
						employee.setAge(res.getInt("age"));
						employee.setAddress(res.getString("address"));
						employee.setDepartmentId(res.getInt("department_id"));
						list.add(employee);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
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
		// 文字コードを指定
		request.setCharacterEncoding("utf-8");
		// formから値を取得
		String name = request.getParameter("name");
		// JSPにnameを送る
		request.setAttribute("userName", name);
		
		doGet(request, response);
	}

}
