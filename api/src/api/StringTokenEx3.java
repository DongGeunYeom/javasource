package api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenEx3 {
	public static void main(String[] args) {
		// 사용자로부터 문자열을 입력받아 공백으로 분리된 어절이 몇 개인가 출력
		// ex) 오늘은 화요일 입니다. => 3
		// exit 문자를 입력하면 반복문 종료
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("문자열을 입력해주세요.");
			String str1 = sc.nextLine();
			
			if(str1.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			} else {
				StringTokenizer st1 = new StringTokenizer(str1);
				System.out.println("공백으로 분리된 어절 수 : "+st1.countTokens());
			}
			
		}
		
		
		
		
		
		
	}

}
