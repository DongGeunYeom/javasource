package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.AllArgsConstructor;
import member.dto.MemberDTO;

import static member.dao.JdbcUtil.*;

@AllArgsConstructor
public class MemberDAO {
	private Connection con;
	
	// C(회원가입)
	// R(로그인)
	// U(비밀번호변경)
	// D(회원탈퇴)
	
	// 로그인 - 사용자가 입력한 아이디, 비밀번호가 존재하는가
	//			select userid, name from membertbl where userid=? and password=?;
	public MemberDTO isLogin(String userid, String password) {
		MemberDTO logindto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userid, name from membertbl where userid=? and password=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				logindto = new MemberDTO();
				logindto.setUserid(rs.getString(1)); // rs.getString("userid")
				logindto.setName(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return logindto;
	}
	
	// 비밀번호 변경
	// update membertbl set password=? where userid=?;
	// update membertbl set password=? where userid=? and password=?;
	public boolean changePassword(String userid, String cfPassword) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "update membertbl set password=? where userid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cfPassword);
			pstmt.setString(2, userid);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	// delete from membertbl where userid=? and password=?

	public boolean leave(String userid, String password) {
		boolean flag = false;
		PreparedStatement pstmt = null;;
		String sql = "delete from membertbl where userid=? and password=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
	return flag;
	}
	
	public boolean register(MemberDTO dto) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "insert into membertbl values(?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
}
