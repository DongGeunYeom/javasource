package collection;

import java.util.ArrayList;
import java.util.List;

/*  List 인터페이스
 * - 순서가 있음
 * - 데이터 중복 허용함
 * - 구현클래스 : ArrayList, Vector, LinkedList, Stack... 
 * - 배열과 동일(향상된 버전임)
 */

public class ListEx2 {
	public static void main(String[] args) {
		
		// 정수 : int => Integer
		
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("jsp");
		list.add("html");
		list.add("css");
		list.add("mybatis");
		
		System.out.println(list);
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		for(String s:list) {
			System.out.println(s);
		}
		
	}

}
