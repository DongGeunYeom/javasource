package emp.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "TIGER";
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	// 전체조회
	public List<EmpDTO> getList() {
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		con = getConnection();
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	// 사원조회
	
	public EmpDTO getRow(int empno) {
		
		EmpDTO dto = null;
		String sql = "select empno, ename, job, hiredate, deptno from exam_emp where empno=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			// String sql 중 '?' 에 대한 처리
			pstmt.setInt(1, empno); // 1은 첫 번째 나오는 ?
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//			empno = rs.getInt("empno");
//			String ename = rs.getString("ename");
//			String job = rs.getString("job");
//			Date hiredate = rs.getDate("hiredate");					
//			int deptno = rs.getInt("deptno");
//			
//			dto = new EmpDTO(empno, ename, job, hiredate, deptno);
			
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	// 정보 수정
	public boolean update(int empno, int mgr) {
		String sql = "update exam_emp set mgr=? where empno=?";
		
		try {
			con = getConnection();
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
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean delete(int empno) {
		String sql = "delete from exam_emp where empno=?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno); 		
			int result = pstmt.executeUpdate();
			
			if(result > 0 ) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}	
	
	// 정보 추가
//	public boolean insert(int empno, String ename, String job, int mgr, int sal, int comm, int deptno) {
//		String sql = "insert into exam_emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) ";
//		sql += "values(?,?,?,?,sysdate,?,?,?)";
//		
//		try {
//			con = getConnection();
//			pstmt = con.prepareStatement(sql);
//		
//			pstmt.setInt(1, empno); 		
//			pstmt.setString(2, ename); 		
//			pstmt.setString(3, job); 		
//			pstmt.setInt(4, mgr); 		
//			pstmt.setInt(5, sal); 		
//			pstmt.setInt(6, comm); 		
//			pstmt.setInt(7, deptno); 		
//				
//		int result = pstmt.executeUpdate();
//	
//		if(result > 0 ) {
//			return true;
//		}
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//			try {
//				pstmt.close();
//				con.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//	return false;
//	}	
	
	public boolean insert(EmpDTO insertDto) {
		String sql = "insert into exam_emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) ";
		sql += "values(?,?,?,?,sysdate,?,?,?)";
		
		try {
			con = getConnection();
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
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		return false;
	}	
	
}
