package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		String view = "WEB-INF/view/memo.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// メモを入れる配列を作る
		List<String> memoList = new ArrayList<String>();
		// 文字コードを指定
//		List<String> nextList = (List<String>)request.getAttribute("nextList");
		request.setCharacterEncoding("UTF-8");
		// formから値を取得
		String memo = request.getParameter("memo");
		// 取得した値を配列に代入
		memoList.add(memo);
		// 配列をJSPに渡す
		request.setAttribute("list", memoList);
		
//		List<String> secondList = (List<String>) request.getAttribute("nextList");
//		System.out.println(nextList);
		doGet(request, response);
	}

}
