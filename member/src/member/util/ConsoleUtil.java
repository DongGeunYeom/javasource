package member.util;

import java.util.List;
import java.util.Scanner;

import member.dto.MemberDTO;

public class ConsoleUtil {
	
	public MemberDTO getNewMember(Scanner sc) {
		System.out.println("member 정보  입력");
		System.out.println("====================");
		System.out.print("1. Name >> ");
		String name = sc.nextLine(); 
		System.out.print("2. Address >> ");
		String addr = sc.nextLine(); 
		System.out.print("3. Email >> ");
		String email = sc.nextLine(); 
		System.out.print("4. Age >> ");
		int age = Integer.parseInt(sc.nextLine()); 
	
		return new MemberDTO(name, addr, email, age);
	}
	
	public void printAddSuccessMessage() {
		System.out.println("member 정보 추가 성공");
	}
	
	public void printAddFailMessage() {
		System.out.println("member 정보 추가 실패");
	}
	
	// list 출력
	public void printListMessage(List<MemberDTO> list) {
		System.out.println();
		System.out.println("******** member List ********");
		System.out.println("----------------------------------");
		System.out.println("id\tname\taddr\temail\tage");
		System.out.println("----------------------------------");
		
		for(MemberDTO dto : list) {
			System.out.printf("%d\t%s\t%s\t%s\t%d\n", dto.getId(), dto.getName(), dto.getAddr(), dto.getEmail(), dto.getAge());
		}
		System.out.println();
	}
	
	public int printModifyMessage(Scanner sc) {
		System.out.println("---- 수정항목 선택 ----");
		System.out.println("1. 주소");
		System.out.println("2. 이메일");
		System.out.print(">> ");
		
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}
	
	public String printModifyValueMessage(Scanner sc) {
		System.out.println("수정 내용 입력");
		System.out.print(">> ");
		String input = sc.nextLine();
		return input;
	}
	
	public int printModifyIdMessage(Scanner sc) {
		System.out.println("아이디 입력");
		System.out.print(">> ");
		int id= Integer.parseInt(sc.nextLine());
		return id;
	}
	
	public void printModifySuccessMessage() {
		System.out.println("member 정보 수정 성공");
	}
	
	public void printModifyFailMessage() {
		System.out.println("member 정보 수정 실패");
	}
	
	public int printRemoveMessage(Scanner sc) {
		System.out.println("삭제할 아이디 정보 입력");
		System.out.print(">> ");
		int id = Integer.parseInt(sc.nextLine());
		return id;
	}
	
	public void printRemoveSuccessMessage() {
		System.out.println("member 정보 삭제 성공");
	}
	
	public void printRemoveFailMessage() {
		System.out.println("member 정보 삭제 실패");
	}
	
	
}
