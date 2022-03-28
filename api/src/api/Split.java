package api;

import java.util.Arrays;

public class Split {
	public static void main(String[] args) {
//		String str1 = "dog,cat,bear";
//		String [] arr = str1.split(",");
////		System.out.println(Arrays.toString(arr));
//		
//		for(String s:arr) {
//			System.out.println(s);
	
			String str2 = "dog cat bear";
			String [] arr1 = str2.split(" ");
			System.out.println(Arrays.toString(arr1));
			
			for(String a:arr1) {
				System.out.println(a);
		}
	
	}
}	
