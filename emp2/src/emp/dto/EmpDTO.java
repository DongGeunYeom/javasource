package emp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

// 접근하고자 하는 테이블의 필드와 동일하게 생성
// exam_emp
//@AllArgsConstructor // 전체 생성자
//@NoArgsConstructor // 디폴트 생성자
//@Setter
//@Getter
//@ToString

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmpDTO {
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
}
