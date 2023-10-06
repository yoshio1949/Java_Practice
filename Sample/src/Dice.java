
public class Dice {
//	int[] values = new int[] {
//			3,4,2,1,5,6
//	};
//	int current = 0;
//	int roll() {
//		current++;
//		if (current == 6) current = 0;
//		return values[current];
	java.util.Random r = new java.util.Random();
	int maxNum = 6;
	public int roll() {
		return r.nextInt(maxNum) + 1;
	}
}
