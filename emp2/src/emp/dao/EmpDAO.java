package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import emp.dto.EmpDTO;

import static emp.dao.JdbcUtil.*;


// CRUD 메소드
public class EmpDAO {

	private Connection con;
	
	public EmpDAO(Connection con) {
		super();
		this.con = con;
	}

	// 전체조회
	public List<EmpDTO> getList() {
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from exam_emp";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// rs에 담긴 sql 실행 결과를 list 담아서 리턴
			while(rs.next()) {
				//행의 각 컬럼들을 가져와서 EmpDTO 객체로 만들기
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				
				// list에 추가
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	// 사원조회
	
	public EmpDTO getRow(int empno) {
		
		EmpDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, hiredate, deptno from exam_emp where empno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			// String sql 중 '?' 에 대한 처리
			pstmt.setInt(1, empno); // 1은 첫 번째 나오는 ?
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//			
			dto = new EmpDTO();
			dto.setEmpno(rs.getInt("empno"));
			dto.setEname(rs.getString("ename"));
			dto.setJob(rs.getString("job"));
			dto.setHiredate(rs.getDate("hiredate"));
			dto.setDeptno(rs.getInt("deptno"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				close(rs);
				close(pstmt);
			}
		return dto;
	}
	
	// 정보 수정
	public boolean update(int empno, int mgr) {
		PreparedStatement pstmt = null;
		String sql = "update exam_emp set mgr=? where empno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mgr); // 1은 첫 번째 나오는 ?
			pstmt.setInt(2, empno); // 2은 두 번째 나오는 ?
			
			int result = pstmt.executeUpdate();
			
			if(result > 0 ) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				close(pstmt);
		}
		return false;
	}
	
	public boolean delete(int empno) {
		PreparedStatement pstmt = null;
		String sql = "delete from exam_emp where empno=?";
			
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno); 		
			int result = pstmt.executeUpdate();
			
			if(result > 0 ) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);	
		}
		return false;
	}	
	
	public boolean insert(EmpDTO insertDto) {
		PreparedStatement pstmt = null;
		String sql = "insert into exam_emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) ";
		sql += "values(?,?,?,?,sysdate,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, insertDto.getEmpno()); 		
			pstmt.setString(2, insertDto.getEname()); 		
			pstmt.setString(3, insertDto.getJob()); 		
			pstmt.setInt(4, insertDto.getMgr()); 		
			pstmt.setInt(5, insertDto.getSal()); 		
			pstmt.setInt(6, insertDto.getComm()); 		
			pstmt.setInt(7, insertDto.getDeptno()); 		
				
			int result = pstmt.executeUpdate();
	
			if(result > 0 ) {
				return true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				close(pstmt);	
			}
		return false;
	}	
	
}
