package api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenEx2 {
	public static void main(String[] args) {
		// 사용자로부터 문자열을 입력받은 후 구분해서 출력
		// 예시) 아빠/엄마/수연/철수/영희
		
		Scanner sc = new Scanner(System.in);
		System.out.print("가족구성원 입력 >> ");
		String str = sc.nextLine();
		
		StringTokenizer strtoken = new StringTokenizer(str,"/");
		
		System.out.println();
		while(strtoken.hasMoreTokens()) {
			System.out.println(strtoken.nextToken());
		}
		
	}

}
