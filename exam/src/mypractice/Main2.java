package mypractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main2 {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> divisor = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str, " ");
		int e = Integer.parseInt(stk.nextToken());
		
		for(int i = 1; i<=e; i++) {
			if(e % i == 0) {
				divisor.add(i);
			}
		}
			System.out.println(divisor);
		
	}
}
