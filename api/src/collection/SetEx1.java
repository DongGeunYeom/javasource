package collection;

import java.util.HashSet;
import java.util.Set;

/* Set 
 * 순서가 없음
 * 중복 허용 안함
 * 
 * HashSet, TreeSet

 */

public class SetEx1 {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		
		set1.add("Java");
		set1.add("Jsp");
		set1.add("Jdk");
		set1.add("Servlet");
		set1.add("Oracle");
		set1.add("Oracle");
		
		System.out.println(set1);
	}

}
