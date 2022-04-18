package item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static item.dao.JdbcUtil.*;

import item.dto.ItemDTO;

public class ItemDAO {
	private Connection con;
	
	public ItemDAO(Connection con) {
		super();
		this.con = con;
	}

	// CRUD
	public List<ItemDTO> getList(){
		List<ItemDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select num, category, name, psize, price, register_at from item";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setName(rs.getString("name"));
				dto.setPsize(rs.getString("psize"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegisterAt(rs.getDate("register_at"));
				
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
	
	public boolean insert(ItemDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "insert into item(num, category, name, content, psize, price) "
		        + "values(item_seq.nextval, ?, ?, ?, ? ,?)";
		boolean flag = false;
		
		try {
			pstmt = con.prepareStatement(sql);
	
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPsize());
			pstmt.setInt(5, dto.getPrice());
		
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}

	public boolean delete(int num) {
		PreparedStatement pstmt = null;
		String sql = "delete from item where num=?";
		
		boolean flag = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	public boolean update(int num, String psize, int price) {
		PreparedStatement pstmt = null;
		String sql = "update item set psize=?, price=? where num=?";
		
		boolean flag = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, psize);
			pstmt.setInt(2, price);
			pstmt.setInt(3, num);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	public List<ItemDTO> searchList(String name, String category) {
		List<ItemDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from item where name=? and category=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, category);	
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCategory(rs.getString("category"));
				dto.setName(rs.getString("name"));
				dto.setPsize(rs.getString("psize"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegisterAt(rs.getDate("register_at"));
					
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
}
