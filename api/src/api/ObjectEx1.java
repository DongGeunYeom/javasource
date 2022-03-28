package api;

public class ObjectEx1 {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		//equals() : String 문자열 비교시 == 대신에
		//		   : 오버라이딩
		if(obj1.equals(obj2)) { // 주소 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if(obj1 == obj2) { // 주소 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		// java.lang.Object@7d6f77cc
		System.out.println("obj1.toString() "+obj1.toString());
		// java.lang.Object@5aaa6d82
		System.out.println("obj2.toString() "+obj2.toString());
		
		
		Value value1 = new Value(10);
		Value value2 = new Value(10);
		
		System.out.println(value1.equals(value2));
		
		System.out.println(value1.toString());
		System.out.println(value1);
		
	}

}
