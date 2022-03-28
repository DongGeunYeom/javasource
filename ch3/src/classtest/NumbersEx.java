package classtest;

public class NumbersEx {

	public static void main(String[] args) {
		
//		int arr[] = {15, 35 ,25, 99, 26, 33};
//		Numbers num1 = new Numbers(arr);
		
		Numbers num1 = new Numbers(new int[] {15, 35, 25, 99, 26, 33});
		
		System.out.println("합계 : "+num1.sum());
		System.out.println("평균 : "+num1.average());
		System.out.printf("평균 : %.2f",num1.average());
		

	}

}
