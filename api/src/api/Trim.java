package api;

public class Trim {
	public static void main(String[] args) {
		String s = "               Hello World       ";
		String s1 = "Hello World";
		System.out.println(s);
		System.out.println(s.trim()); // 양쪽 공백제거
		s = s.trim();
		System.out.println(s.equals(s1));
		
	}

}
