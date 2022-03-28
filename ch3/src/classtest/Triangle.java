package classtest;

public class Triangle {
	// 속성 : 밑변(정수), 높이(정수)
	// 기능 : 면적을 구한다
	
	int baseLine;
	int height;

	public Triangle(int baseLine, int height) {
		super();
		this.baseLine = baseLine;
		this.height = height;
	}
	
	double getArea() {
//		double area = baseLine * height / 2;
//		return area;
		
		return baseLine * height / 2;
	}

	
	
//	Triangle angle = new Triangle() 
		
}
