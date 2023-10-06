package sample;

import java.io.IOException;

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
		// TODO Auto-generated method stub
		// request.jspから送られてきたテキストを受け取りtextという変数に入れる
		
		String nowHour = request.getParameter("nowHour");
		String nowMinute = request.getParameter("nowMinute");
		
		// response.jspで文字列を取得するための準備
		request.setAttribute("nowHour", nowHour);
		request.setAttribute("nowMinute", nowMinute);
		
		// テキストを整数に変換する
		int NowHour = Integer.parseInt(nowHour);
		int NowMinute = Integer.parseInt(nowMinute);
		
		// 通勤時間と到着時刻を定義する
		int commute = 48;
		int ArrivalMinute = NowMinute + commute;
		int ArrivalHour = NowHour;
		
		// 時刻に通勤時間を足す
		if (ArrivalMinute >= 60) {
			ArrivalMinute -= 60;
			ArrivalHour += 1;
		}
		
		if (ArrivalHour >= 24) {
			ArrivalHour -= 24;
		}
		
		// 帰宅時間をテキストに変換する
		String arrivalHour = Integer.valueOf(ArrivalHour).toString();
//		String arrivalMinute = Integer.valueOf(ArrivalMinute).toString();
		String arrivalMinute01 = String.format("%02d", ArrivalMinute);
		
		request.setAttribute("afterHour", arrivalHour);
		request.setAttribute("afterMinute", arrivalMinute01);
		// request.jspを表示する
		request.getRequestDispatcher("response.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
