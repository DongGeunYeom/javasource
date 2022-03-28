package condition;

import java.util.Scanner;

public class RockScissorPaper2 {
	public static void main(String[] args) {
		// 가위 : 1, 바위 : 2, 보자기 : 3
		Scanner sc = new Scanner(System.in);
		System.err.println("가위바위보를 시작합니다. 가위 : (1), 바위 : (2), 보자기 : (3) 중에서 하나를 선택해주세요." );
		
		int yourHand = sc.nextInt();
		int comHand = (int)(Math.random() * 3) + 1;
		System.out.println("컴퓨터는 "+comHand+"을(를) 내었습니다. 가위 : (1), 바위 : (2), 보자기 : (3)");
		
		if(yourHand == comHand) {
			System.out.println("비겼습니다.");
			
			
		} else if(yourHand > comHand) {
			if(yourHand == 3 && comHand == 1) {
				System.out.println("당신이 졌습니다.");
			} else {
				System.out.println("당신이 이겼습니다.");
			}
			
			
		} else if(yourHand < comHand) {
			if(yourHand == 1 && comHand == 3)
				System.out.println("당신이 이겼습니다.");
		    } else {
		    	System.out.println("당신이 졌습니다.");
	     	}
		
		
		sc.close();
	}

}
