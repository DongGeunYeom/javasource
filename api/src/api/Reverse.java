package api;

public class Reverse {
	public static void main(String[] args) {
		String str = "ABzquartK";
	
		
		//거꾸로 출력
		for(int i = str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i)+" ");
		}
		
		System.out.println();
		
		char[] chArr= str.toCharArray();
		System.out.println(chArr);
		for(int i = chArr.length-1; i>=0; i--) {
			System.out.print(chArr[i]);
		}
		System.out.println();
		
		// StringBuilder reverse
		StringBuilder a = new StringBuilder(str);
			System.out.print(a.reverse());
		
		

	}
}
