package api;

public class StringEx1 {
	public static void main(String[] args) {
		
		// 문자열 만들 때 2가지 방법
		// 문자열 리터럴을 지정
		// String 클래스 생성자 이용
		
		String str1= "Hello";
		String str2= "Hello";
		String str3= new String("Hello");
		String str4= new String("Hello");
		
		System.out.println(str1 == str2); // true because 같은 주소. (주소값 동일지정)
		System.out.println(str3 == str4); // false 다른 주소.
		System.out.println(str3.equals(str4)); 

		// 내용 비교를 위해서는 equals() 메소드 사용
		
	}

}
