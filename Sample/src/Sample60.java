
public class Sample60 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// 点oオブジェクト
		Point o;
		// 線lineオブジェクト
		Line line;
		// 三角形triangleオブジェクト
		Triangle triangle;
		// 円circleオブジェクト
		Circle circle;
		
		o = new Point();
		line = new Line();
		triangle = new Triangle();
		circle = new Circle();
		
		o.x = 0;
		o.y = 0;
		
		Point point = new Point();
		point.x = 2;
		point.y = 3;
		line.p0 = point;
		point = new Point();
		point.x = 4;
		point.y = 9;
		line.p1 = point;
		
		triangle.p0 = new Point();
		triangle.p0.x = 3;
		triangle.p0.y = 9;
		triangle.p1 = new Point();
		triangle.p1.x = 4;
		triangle.p1.y = 3;
		triangle.p2 = new Point();
		triangle.p2.x = 4;
		triangle.p2.y = 6;
		
		circle.p0 = new Point();
		circle.p0.x = 10;
		circle.p0.y = 10;
		circle.r = 1;
		
		System.out.println(o.x);
		System.out.println(line.p0.y);
		System.out.println(line.p1.x);
		System.out.println(triangle.p2.y);
		System.out.println(circle.r);
	}

}
