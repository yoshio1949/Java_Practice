package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateMemo
 */
@WebServlet("/CreateMemo")
public class CreateMemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//DBに接続するための情報をフィールドに定数として定義
	public static final String URL = "jdbc:mysql://localhost/memo";
	public static final String USER = "study";
    public static final String PASSWORD = "diamond-f";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//データを格納するリスト
		ArrayList<String[]> list = new ArrayList<String[]>();
		
		//DBに接続する
		try {
			//JDBCドライバの検出
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//DBへのアクセス
			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				//DBへのアクセス
				Statement st = conn.createStatement();){
				//SQL文の入力
				ResultSet res = st.executeQuery("SELECT * FROM memo ORDER BY memo_id DESC");
				
				while(res.next()) {
					String[] data = new String[3];
					data[0] = res.getString("memo_id");
					data[1] = res.getString("memo_text");
					data[2] = res.getString("date");
					list.add(data);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//JSPに送るためのデータを格納
		request.setAttribute("data", list);
		
		String view = "WEB-INF/view/memo.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF8");
		
		//requestオブジェクトから取得
		String memo = request.getParameter("memo_text");
		
		//メモが空文字でなければ処理を続ける
		if (!memo.equals("")) {
			//データベース接続情報管理
			Connection conn = null;
			
			//SQL情報管理
			PreparedStatement ps = null;
			
			try {
				//JDBCドライバのインストール
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//DB接続
				conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
				
				//SQL文（追加処理）の作成と実行
				String sql = "INSERT INTO memo(memo_text,date) VALUES(?,now())";
				ps = conn.prepareStatement(sql);
				ps.setString(1, memo);
				ps.executeUpdate();
			} catch (Exception e) {
				//何もしない。本来は例外処理を書く
				//↓エラー文を段階的に表示してくれる
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}
}
