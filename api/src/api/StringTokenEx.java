package api;

import java.util.StringTokenizer;

public class StringTokenEx {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("This is a test.");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		System.out.println();
		
		StringTokenizer st1 = new StringTokenizer("This/is/a/test.","/");
		
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
		System.out.println();
		String exp = "1,김천재,100,100,100|2,박수재,95,80,90|3,이자바,80,90,90";
		StringTokenizer st2 = new StringTokenizer(exp,"|,");
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
	
	
	}
}
