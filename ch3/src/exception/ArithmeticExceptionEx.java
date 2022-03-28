package exception;

public class ArithmeticExceptionEx {

	public static void main(String[] args) {

		int num1 =5, num2 = 0;
		// java.lang.ArithmeticException: / by zero
		
		try { // 예외가 발생할 만한 코드
			System.out.println(num1/num2);

		} catch (Exception e) { // 예외가 발생하면 처리
//			System.out.println("예외발생");
			e.printStackTrace();
		}
		

	}

}
