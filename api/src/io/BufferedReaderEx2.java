package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class BufferedReaderEx2 {
	public static void main(String[] args) {
		
		// 자바 소스 파일을 읽어서 화면에 출력
		// src/io/PerformanceEx2.java
		// 출력문 앞에 번호를 붙여서 화면에 보여주기	
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream("src/io/PerformanceEx2.java"));
			BufferedReader br = new BufferedReader(isr)){
			
			String str = null;
			int i = 1;
			while((str = br.readLine()) != null) {
				System.out.println(i+" "+str);	
				i++;
			}	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
