package condition;

public class TestForEx1 {

	public static void main(String[] args) {
		// 역별 찍기 연습
		
		for(int i=1; i<=5; i++) {
			for(int j=5; j>=1; j--) {
				System.out.print(j<=i ? '*' : ' ');
			}
			System.out.println();
		}
	}

}
