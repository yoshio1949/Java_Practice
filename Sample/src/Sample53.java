
public class Sample53 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		long[] bd = new long[] {
				19700101,19750101,19800101,19850101,19900101,0
			};

        for (long v : bd) {
        	if (v != 0) {
        		System.out.println(v);
        	}
        }
        
        System.out.println("----");
        
        long[] bd2 = bd;
        
        for (long v : bd2) {
        	if (v != 0) {
        		System.out.println(v);
        	}
        }
	}

}
