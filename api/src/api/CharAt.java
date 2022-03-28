package api;

public class CharAt {
	public static void main(String[] args) {
		
		String str1 = "자바 프로그래밍";
		
		// index => 0부터 시작
		
		for(int i = 0; i<str1.length(); i++) {
			if(i % 2 == 0) {
				System.out.print(str1.charAt(i));
			}
		}

		System.out.println();
		
		String str2 = "Hello!! Java";
		char chArr[] = new char[str2.length()];
		// str2 문자열을 char 배열로 생성하고 출력하기
		for(int j = 0; j<str2.length(); j++) {
			chArr[j] += str2.charAt(j); 
			}
		
		System.out.println(chArr);
		
		// 문자열에 '프' 문자가 들어있는지 확인
		// 문자가 들어있음, 없음
		boolean flag = false;
		for(int q = 0; q<str1.length(); q++) {
			if(str1.charAt(q) == '프') {
				flag = true;
				break;
			}
			
		}
		System.out.println(flag?"문자가 들어있음" : "없음");

	}
	
}


