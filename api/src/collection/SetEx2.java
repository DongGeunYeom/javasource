package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SetEx2 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		
		for(int i = 0; set1.size() < 6; i++) {
			int num = (int)(Math.random()*45)+1;
			set1.add(num);
		}
		
		System.out.println(set1);
		
		// 정렬 한 후 출력
		
		List<Integer> list = new ArrayList<Integer>(set1);
		Collections.sort(list);
		System.out.println(list);
		
	}
}
