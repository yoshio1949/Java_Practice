package education.oop.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Console {

	private PrintStream out = System.out;
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	
	// 初期表示
	public void init() {
	
		out.println("#######################################");
		out.println("模擬アプリケーション");
		out.println("1. 注文受付システム");
		out.println("2. 貨物追跡サービス");
		out.println("3. 終了");
		out.println("業務を選択してください。 => ");
		
		try {
			String reply = in.readLine();
			if ("1".equalsIgnoreCase(reply)) {
				// 注文受付システムが選択された場合の処理を呼び出す
			} else if ("2".equalsIgnoreCase(reply)) {
				// 貨物追跡サービスが選択された場合の処理を呼び出す
			} else if ("3".equalsIgnoreCase(reply)) {
				// 終了が選択された場合の処理を呼び出す
				finalize();
			} else {
				// メニューを再表示
				init();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 注文受付システムが選択された場合の処理
	// 貨物追跡サービスが選択された場合の処理
	protected void runCargoTracking() {
		
		out.println("貨物追跡サービス");
		out.println();
		out.print("お問い合わせ番号を入力してください。 => ");
		
		try {
			String queryNo = in.readLine();
			CargoTracking tracker = null;
			
			String state = tracker.track(queryNo);
			
			out.print("お問い合わせ番号:" + queryNo);
			out.println("配送状況");
			out.println(state);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 終了が選択された場合の処理
	protected void finalize() {
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
