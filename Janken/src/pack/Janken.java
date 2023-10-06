package pack;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Janken
 */
@WebServlet("/Janken")
public class Janken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Janken() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = "WEB-INF/view/janken.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer playerHand = Integer.parseInt(request.getParameter("syoubu"));
		ComputerHand computerHand = new ComputerHand();
		
		String resultText = "";
		int pHand = playerHand;
		int cHand = computerHand.getComputerHand();
		int result = (pHand - cHand + 3) % 3;
		String CHand ="";
		// じゃんけんの勝ち負けをジャッジする
		if (result == 0) {
			resultText = "あいこです";
		}
		else if (result == 1) {
			resultText = "あなたの負けです";
		}
		else {
			resultText = "あなたの勝ちです";
		}
		// 相手の手を文字列に直す
		if (cHand == 0) {
			CHand = "グー";
		}
		else if (cHand == 1) {
			CHand = "チョキ";
		}
		else {
			CHand = "パー";
		}
		request.setAttribute("chand", CHand);
		request.setAttribute("result", resultText);
		
		doGet(request, response);
	}

	
	public class ComputerHand {
		// コンピューターの手を取得するためのメソッド
		int getComputerHand() {
			// Randomクラスをインスタンス化
			Random random =new Random();
			// handに0~2のどれかの数値を代入
			int hand = random.nextInt(3);
			// handの値を返す
			return hand;
		}
	}

}
