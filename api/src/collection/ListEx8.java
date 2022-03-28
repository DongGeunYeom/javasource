package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListEx8 {

	public static void main(String[] args) {
		// Scanner를 사용하여 5개의 실수 값을 사용자로부터 받아서 ArrayList에 저장한 후 검색하여
		// 가장 큰 수 출력
		// 예시)
		// 입력값 : 3.14, 2.1, -5.5, 99.9, 33.7 => "3.14, 2.1, -5.5, 99.9, 33.7"
		// 출력값 : 가장 큰 수는 99.9
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> flo = new ArrayList<Double>();
		String input = sc.nextLine();
		
		System.out.println(flo);
		
		StringTokenizer token = new StringTokenizer(input); //기본값이 공백
		
		while(token.hasMoreTokens()) {
			flo.add(Double.parseDouble(token.nextToken()));
		}
		
		// Collections.sort(flo); Collections.max()
		System.out.println("가장 큰 수는 "+Collections.max(flo));
		
		
		
		
	}

}
