
public class Sample52 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		long[] bd;
		bd = new long[6];
		
		bd[0] = 19700101;
        bd[1] = 19750101;
        bd[2] = 19800101;
        bd[3] = 19850101;
        bd[4] = 19900101;
        bd[5] = 0;

        for (int i = 0; i < bd.length; i++) {
        	if (bd[i] != 0) {
        		System.out.println(bd[i]);
        	}
        }
	}

}
