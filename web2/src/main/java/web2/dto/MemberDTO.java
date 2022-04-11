package web2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

// member테이블과 똑같이 작성
public class MemberDTO {
	private int id;
	private String name;
	private String addr;
	private String email;
	private int age;
	
	public MemberDTO(String name, String addr, String email, int age) {
		super();
		this.name = name;
		this.addr = addr;
		this.email = email;
		this.age = age;
	}
}
