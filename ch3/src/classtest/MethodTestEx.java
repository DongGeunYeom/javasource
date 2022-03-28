package classtest;

import java.util.Arrays;

public class MethodTestEx {

	public static void main(String[] args) {
	
		
		MethodTest1 obj = new MethodTest1();
		
		System.out.println(obj.sum(1, 2));
	
		char charValue = obj.method1();
		
		int value = charValue +1;
		System.out.println(value);
		
		float result1 = obj.divide1(5.0f, 2.0f);
		System.out.println(result1);		
		
		//array
		int intArr[] = {4,5,6,7};
		int intArr2[] = obj.array(intArr);
		System.out.println(Arrays.toString(intArr2));	
	}

}