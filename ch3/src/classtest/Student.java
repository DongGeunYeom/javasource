package classtest;

/* 코딩 컨벤션 : 코딩을 할 때 읽고 이해하기 쉽도록 정한 규칙
 * 
 *  camelcase (단어가 두 개 합쳐졌을 때, 뒷 단어의 시작을 대문자로)
 *  snakecase : student_name
 *  
 *  변수명 : 변수 이름은 소문자로 시작 // studentName
 *  클래스명 : 클래스 이름은 대문자로 시작
 * 
 */

// 접근제어자(public, pivate)
// class 
// 클래스명(클래스 이름은 대문자로 시작)

public class Student {
		// 속성(특성) : 필수는 아님 - 멤버변수(property)
		// 기능(동작) : 필수는 아님 - 멤버 메소드
	
		//  ex) 속성 - 학번(20221010), 이름, 주소 , 핸드폰
		//

		int studentId;
		String studentName;
		String address;
		String mobile;
		
		// 기능 - 핸드폰 번호를 변경한다. 주소를 변경한다.
		void changeMobile() {}
		void changeAddress() {}
		
		
}
