package classtest;

public class Numbers {
	int num[];

	
	public Numbers(int[] num) {
		super();
		this.num = num;
	}
	
	// 합계
	// 리턴 int
	int sum() {
		int total = 0;
		for(int i = 0; i<num.length; i++) {
			total += num[i];
		}
		return total;
	}
	
	
	// 평균
	// double
	double average() {
		return (double)sum() / num.length;
	}

}
