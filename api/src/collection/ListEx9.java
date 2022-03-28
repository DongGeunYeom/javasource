package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListEx9 {
	public static void main(String[] args) {
		// 한 어린이의 키를 2015 ~ 2021 년 사이에 
		// 1년 단위로 입력받아 ArrayList에 저장
		// 가장 키가 많이 자란 연도 출력하기
		// 예시)
		// 입력값 : 120 122 125 130 139 145 149 
		// 출력값 : 2019
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		ArrayList<Integer> height = new ArrayList<Integer>();
		StringTokenizer chk = new StringTokenizer(input);
		while(chk.hasMoreTokens()) {
			height.add(Integer.parseInt(chk.nextToken()));
		}
		
		System.out.println(height);
		
		int between = 0 , pos = 0;
		for(int i =0; i<height.size()-1; i++) {
			int diff = height.get(i+1) - height.get(i);
			if(between < diff) {
				between = diff;
				pos = i+1;
			}
		}
	System.out.println("가장 키가 많이 자란 연도는 "+(pos+2015)+" 년 "+between+"cm");

	}

}
