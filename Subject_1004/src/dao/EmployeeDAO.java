package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	//接続用の情報をフィールドに定数として定義
	private static final String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/study";
	private static final String USER = "study";
	private static final String PASSWORD = "diamond-f";
	
	//DB接続を行うメソッド
	//DB接続用定義を基にDBへ接続し、戻り値としてコネクション情報を返す
	private static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
		} catch(Exception e) {
			throw new IllegalStateException(e);
		}
	}
	public List<Employee> findAll() {
		//変数宣言
		Connection con = null;
		Statement st = null;
		
		//配列宣言
		List<Employee> list = new ArrayList<>();
		
		//SQL文作成
		String sql = "SELECT * FROM employee";
		try {
			//DBに説億
			con = EmployeeDAO.getConnection();
			st = con.createStatement();
			
			//SQL文発行
			ResultSet rs = st.executeQuery(sql);
			
			//けんさく結果をArrayListに格納
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				int department_id = rs.getInt("department_id");
				Date date = rs.getDate("date");
//				list.add(new Employee(id,name, age, address, department_id, date));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try{st.close();}catch(SQLException ignore) {}
			}
			if (con != null) {
				try{st.close();}catch(SQLException ignore) {}
			}
		}
		return list;
	}
}
