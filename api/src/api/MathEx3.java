package api;

public class MathEx3 {
	public static void main(String[] args) {
		// 반복
		// 1~3 까지 난수(임의의 숫자) 3개 생성한 뒤 한 줄에 출력
		// 모두 같은 수가 나올 때까지 반복, 모두 같은 수이면 종료
		
		
		
		
		while(true) {
			int dice1 = (int)(Math.random()*3)+1;
			int dice2 = (int)(Math.random()*3)+1;
			int dice3 = (int)(Math.random()*3)+1;
			if(dice1 == dice2 && dice1 == dice3) {
				System.out.printf("%d\t%d\t%d\n성공",dice1, dice2, dice3);
				break;
			} else {
				System.out.printf("%d\t%d\t%d\n",dice1, dice2, dice3);
			}
			
		}
		
		
	}

}
