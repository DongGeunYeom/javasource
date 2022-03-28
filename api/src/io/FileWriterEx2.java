package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class FileWriterEx2 {

	public static void main(String[] args) {
		// 사용자로부터 데이터 입력받기 : Scanner
		// output1.txt 파일 생성
		// 입력받은 데이터를 파일 출력 : output1.txt
		
		File f = new File("d:\\temp\\output1.txt");
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		try (Writer writer = new FileWriter(f);
				Scanner sc = new Scanner(System.in)){
			
			System.out.println("데이터 입력(q를 입력하면 종료) >> ");
			String str = "";
			while(!(str = sc.nextLine()).equalsIgnoreCase("q")) {
					writer.write(str+"\r\n");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
