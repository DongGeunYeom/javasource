package classtest;

public class SubscriberInfoEx2 {
	public static void main(String[] args) {
		
		// 기본타입(byte, short, char, boolean...)의 초기화는 null을 줄 수 없음
		
		//int a = null;
		String str = null; // null : 값을 할당하지 않았음
		
		TV tv = null;
		
		// SubscriberInfo 객체를 담을 배열 생성
		SubscriberInfo info[] = new SubscriberInfo[5];
		
		// 생성된 배열에 SubscriberInfo 객체 생성 후 담기	
		info[0] = new SubscriberInfo("홍길동", "hong1234", "1q2w3e4r");
		info[1] = new SubscriberInfo("성춘향", "sung4567", "1q2w3e4r", "010-1234-1234", "경기도 남양주시");
		info[2] = new SubscriberInfo("이몽룡", "mong2224", "1q2w3e4r", "010-7777-7777", null);
		info[3] = new SubscriberInfo("이세종", "jong1239", "1q2w3e4r");
		info[4] = new SubscriberInfo("김고종", "gogo1232", "1q2w3e4r");
		
		// 생성된 정보 확인
		print(info);
			
	}
		//참조매개변수
	static void print(SubscriberInfo info[]) {
		// for(타입 변수명 : 배열명)
		for(SubscriberInfo i : info) {
			System.out.println("성명 : "+i.userName);
			System.out.println("아이디 : "+i.userId);
			System.out.println("비밀번호 : "+i.userPassword);
			System.out.println("전화번호 : "+i.userNumber);
			System.out.println("주소 : "+i.userAddress);
		System.out.println();
		
		}
		for(int i = 0; i<info.length;i++) {
			System.out.println("성명 : "+info[i].userName);
			System.out.println("아이디 : "+info[i].userId);
			System.out.println("비밀번호 : "+info[i].userPassword);
			System.out.println("전화번호 : "+info[i].userNumber);
			System.out.println("주소 : "+info[i].userAddress);
			System.out.println();
		}
	}
	

}