package emp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectAll2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "javadb";
			String password = "12345";
			
			con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				String sql = "select * from member";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String addr = rs.getString(3);
					String email = rs.getString(4);
					int age = rs.getInt(5);
					
					System.out.printf("%d\t%s\t%s\t%s\t%d\n",id, name, addr, email, age);
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
