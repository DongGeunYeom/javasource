package classtest;

public class SubscriberInfoEx {

	public static void main(String[] args) {

		SubscriberInfo sub1 = new SubscriberInfo();
		// 초기화 작업 필요
		sub1.userId = "meronot";
		sub1.userName = "홍길동";
		sub1.userPassword = "12341234";
			
		// 리턴타입이 void인 경우 호출만
		sub1.changeAddress("구로구"); // null => 구로구
		
		// 가입자 정보 출력
		objectPrint(sub1);
//		System.out.println("아이디 : "+sub1.userId);
//		System.out.println("이름: "+sub1.userName);
//		System.out.println("비밀번호 : "+sub1.userPassword);
//		System.out.println("전화번호 : "+sub1.userNumber);
//		System.out.println("주소 : "+sub1.userAddress);
//		
		System.out.println();
		
		SubscriberInfo sub2 = new SubscriberInfo("성춘향", "sung1234", "qwerty");
		objectPrint(sub2);
//		System.out.println("아이디 : "+sub2.userId);
//		System.out.println("이름: "+sub2.userName);
//		System.out.println("비밀번호 : "+sub2.userPassword);
//		System.out.println("전화번호 : "+sub2.userNumber);
//		System.out.println("주소 : "+sub2.userAddress);
		
		System.out.println();
		
		SubscriberInfo sub3 = new SubscriberInfo("이몽룡", "mong1234", "ichlibedich", "010-3333-3333", "서울시 해운대구");
		objectPrint(sub3);
//		System.out.println("아이디 : "+sub3.userId);
//		System.out.println("이름: "+sub3.userName);
//		System.out.println("비밀번호 : "+sub3.userPassword);
//		System.out.println("전화번호 : "+sub3.userNumber);
//		System.out.println("주소 : "+sub3.userAddress);
		
		
		}	
	static void objectPrint(SubscriberInfo sub) {
		// 가입자 정보 출력
		System.out.println("아이디 : "+sub.userId);
		System.out.println("이름: "+sub.userName);
		System.out.println("비밀번호 : "+sub.userPassword);
		System.out.println("전화번호 : "+sub.userNumber);
		System.out.println("주소 : "+sub.userAddress);
	}

}