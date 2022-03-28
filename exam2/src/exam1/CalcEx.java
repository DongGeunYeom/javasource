package exam1;

import java.util.Scanner;

public class CalcEx {
	public static void main(String[] args) {
		
		Calc clac;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Input Num1 : ");
		int a = Integer.parseInt(scanner.nextLine());
			
		System.out.print("Input Num2 : ");
		int b = Integer.parseInt(scanner.nextLine());
			
		System.out.print("Input operator : ");
		String oper = scanner.nextLine();
		switch(oper) {
			case "+":
				clac = new Add();
				clac.setValue(a, b);
				System.out.println(clac.calculate());	
				break;
				
			case "-":
				clac = new Sub();
				clac.setValue(a, b);
				System.out.println(clac.calculate());	
				break;
				
			case "*":
				clac = new Mul();
				clac.setValue(a, b);
				System.out.println(clac.calculate());	
				break;
				
			case "/":
				clac = new Div();
				clac.setValue(a, b);
				System.out.println(clac.calculate());	
				break;
				
			}
			scanner.close();
	}

}
