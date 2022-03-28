package classtest;

// java.util : 패키지명

import java.util.Scanner;

// static final : 상수
// 상수 : 대문자로 표현

public class EarthEx {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반지름 "+Earth.EARTH_RADIUS+"km");
		System.out.println("지구의 표면적 "+Earth.EARTH_SURFACE_AREA+"km^2");
	}
	
}
