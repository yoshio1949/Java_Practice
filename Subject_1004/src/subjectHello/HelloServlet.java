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
		
		// 社員名を格納するList
		List<String> employeeName = new ArrayList<>();
		
		// データベースに接続する
		try {
			// JDBCドライバの検出
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try (Connection con = DriverManager.getConnection(url, user, password); // データベースへの接続
				// データベースへのアクセス
				Statement st = con.createStatement();){
				// SQL文の入力
				ResultSet res = st.executeQuery("SELECT employee_name FROM employee");
				
				while(res.next()) {
					employeeName.add(res.getString("employee_name"));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(employeeName);
		
		request.setAttribute("employeeName", employeeName);
		
		
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
