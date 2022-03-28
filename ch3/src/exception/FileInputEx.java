package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputEx {
	/*
	 * try{} : 단독사용불가
	 * try{}catch(){} 
	 * try{}finally{} 
	 * try{}catch(){}finally{} 
	 * 
	 */

	public static void main(String[] args) {
//		FileInputStream fis = null;
				
//			try {
//				fis = new FileInputStream("file.txt");
//							
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} finally { // 자원해제
//				 try {
//						fis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}	
//		}
		// 자동 리소스 닫기
	try (FileInputStream fis = new FileInputStream("file.txt")){
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
}


