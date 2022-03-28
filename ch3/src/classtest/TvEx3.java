package classtest;

import java.util.Arrays;

public class TvEx3 {
	public static void main(String[] args) {
		// TV 객체를 배열로 생성
		
		// 타입 배열명 [] = new 타입[];
		// int arr[] = new int[5];
		
		TV tvArr[] = new TV[5];
		// tvArr[1], tvArr[2]...
		
		System.out.println(Arrays.toString(tvArr)); 
//		System.out.println(tvArr[0].channelTv); // NullPointerException
		
		// TV객체 생성 후 배열에 담기
//		
//		tvArr[0] = new TV();
//		tvArr[0].channelTv = 10;
//		
//		tvArr[1] = new TV();
//		tvArr[1].channelTv = 11;
//
//		tvArr[2] = new TV();
//		tvArr[2].channelTv = 12;
//
//		tvArr[3] = new TV();
//		tvArr[3].channelTv = 13;
//
//		tvArr[4] = new TV();
//		tvArr[4].channelTv = 14;
//
		int length = tvArr.length; //5
		for(int i = 0; i<length; i++) {
			tvArr[i] = new TV();
			tvArr[i].channelTv = i+ 10;
			}
	
	}	
}



