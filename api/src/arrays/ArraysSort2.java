package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort2 {

	public static void main(String[] args) {
		Integer arr[] = {37, 21, 59, 99, 88, 77, 15, 78, 62, 74};
		
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr));
		// sort(int[]) in the type Arrays is not applicable for the arguments (int[], Comparator.reverseOrder())
		// sort(T[] a, Compa~)
		// T, E, K, V : 객체를 의미
		
		
		}
	}


