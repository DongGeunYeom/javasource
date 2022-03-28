package api;

public class ValueOf {
	public static void main(String[] args) {
		
		// 지정된 값을 문자열로 반환
		
		String str1 = String.valueOf(false);
		System.out.println(str1); // "false"
		
		String str2 = String.valueOf('c');
		System.out.println(str2); // "c"
		
		String str3 = String.valueOf(10f);
		System.out.println(str3); // "10f"
		
		String str4 = String.valueOf(10L);
		System.out.println(str4); // "10L"
		
				
		// "false" => boolean 타입
		boolean str11 = Boolean.parseBoolean(str1);
		System.out.println(str11);
		
		// "3" => int 타입 
		int i = Integer.parseInt("3");
		
		// "10.0" => float타입
		float f2 = Float.parseFloat(str3);
		System.out.println(f2);
		
		
		
		

	}

}
