package classtest;

// 접근제어자(public, pivate)
// class 
// 클래스명(클래스 이름은 대문자로 시작)

public class Student2 {
		// 속성(특성) : 필수는 아님 - 멤버변수(property)
		// 기능(동작) : 필수는 아님 - 멤버 메소드
		// 생성자 : default 생성자, 인자를 받는 생성자
		//			   접근제한자(public, private, package) 클래스명(){}
		// 인자(인수-argument) : 괄호 안에 들어있는 변수 지칭
	
		//  ex) 속성 - 학번(20221010), 이름, 주소 , 핸드폰

		int studentId;
		String studentName;
		String address;
		String mobile;
		
		// 생성자(constructor) : 초기화 담당, 객체를 생성하면서 필요한 사전작업 담당
		// 	생성자 오버로딩 :  여러 개 올 수 있음(단, default 생성자는 무조건 하나, 인자를 받는 생성자를 여러 개 설정 가능)
		// 객체를 생성할 때 자동 호출
		public Student2() { // default 생성자(무조건 하나만 존재)
			System.out.println("Student2 객체 생성");
		}
		
		public Student2(int studentId, String studentName) {  
			System.out.println("인자를 받는 Student2 객체 생성(1)");
			// 인자를 받는 생성자
			// this : 객체 자기 자신
			this.studentId = studentId;
			this.studentName = studentName;
		}
		
		public Student2(String studentName, int studentId) {  
			System.out.println("인자를 받는 Student2 객체 생성(1-2)");
			this.studentId = studentId;
			this.studentName = studentName;
		}
		
		public Student2(int studentId, String studentName, String address) {  
			System.out.println("인자를 받는 Student2 객체 생성(2)");
			this.studentId = studentId;
			this.studentName = studentName;
			this.address = address;
		}
		
		public Student2(int studentId, String studentName,String address, String mobile) {
			System.out.println("인자를 받는 Student2 객체 생성(3)");
			this.studentId = studentId;
			this.studentName = studentName;
			this.address = address;
			this.mobile = mobile;
		}
		
		
			
		// 기능 - 핸드폰 번호를 변경한다. 주소를 변경한다.
		void changeMobile() {}
		void changeAddress() {}
		
		
}
