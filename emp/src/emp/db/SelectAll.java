package emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectAll {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "scott";
			String password = "TIGER";
			
			con = DriverManager.getConnection(url, id, password);
			
			if(con != null) {
				String sql = "select * from exam_emp";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int empno = rs.getInt(1);
					String ename = rs.getString(2);
					String job = rs.getString(3);
					int mgr = rs.getInt(4);
					String hiredate = rs.getString(5);
					int sal = rs.getInt(6);
					int comm = rs.getInt(7);
					int deptno = rs.getInt(8);
					
					System.out.printf("%d\t%s\t%s\t%d\t%s\t%d\t%d\t%d\t\n",empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}
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
	

	}

}
