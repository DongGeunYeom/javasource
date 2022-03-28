package api;

public class StringBuilderEx {
	public static void main(String[] args) {
		// String 클래스와 다른점은 mutable(가변) : append, insert, delete
		// StringBuilder : 문자열 클래스, 싱글 스레드
		// StringBuffer : 문자열 클래스, 멀티 스레드
		
		StringBuilder builder = new StringBuilder("Hello Java");
		builder.append("안녕하세요");
		
		System.out.println(builder);
		
		// builder ="ttt";(안되는 코드)
		
		builder.delete(0, 3);
		
		System.out.println(builder);
		
		builder.insert(2, "t");
		
		System.out.println(builder);
		
		StringBuilder builder1 = new StringBuilder("Hello");
		StringBuilder builder2 = new StringBuilder("Hello");
		
		// equals() 오버라이딩 안되어 있음
		System.out.println(builder1.equals(builder2));
		
		
		String str1 = new String(builder1);
		String str2 = new String(builder2);
		System.out.println(str1.equals(str2));


		
	}

}
