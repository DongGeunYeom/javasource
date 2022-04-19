package board.dao;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDTO;

public class BoardDAO {
	private Connection con;

	public BoardDAO(Connection con) {
		super();
		this.con = con;
	}
	
	// CRUD
	// 게시글 삽입, 삭제, 수정(게시글 수정, 조회수 수정), 조회, 전체조회

	// 게시글 삽입
	public boolean insertArticle(BoardDTO insertDto) {
		boolean flag = false;
		String sql = "insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) "
				+ "values(board_seq.nextval,?,?,?,?,?,board_seq.currval,?,?)";
		PreparedStatement pstmt = null;
		
		try {	
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getName());
			pstmt.setString(2, insertDto.getPassword());
			pstmt.setString(3, insertDto.getTitle());
			pstmt.setString(4, insertDto.getContent());
			pstmt.setString(5, insertDto.getAttach());
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	// 게시글 전체조회
	public List<BoardDTO> listAll(){
		List<BoardDTO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select bno,name,title,regdate,readcount from board order by bno desc";
		
		try {	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setRegDate(rs.getDate("regdate"));
				
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
	
	// 게시글 조회
	public BoardDTO showView(int bno){
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select bno,name,title,content,attach from board where bno=?";
		
		try {	
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return dto;
	}
	
	// 조회수 업데이트
	public boolean hitUpdate(int bno) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql ="update board set readcount = readcount+1 where bno=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	// 게시글 삭제
	public boolean delete(int bno, String password) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "delete from board where bno=? and password=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) flag = true;		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return flag;
	}
	
	// 게시글 수정
	public boolean update(BoardDTO updateDto) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			
			if(updateDto.getAttach()!=null) {
				sql = "update board set title=?, content=?, attach=? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, updateDto.getTitle());
				pstmt.setString(2, updateDto.getContent());
				pstmt.setString(3, updateDto.getAttach());
				pstmt.setInt(4, updateDto.getBno());
				pstmt.setString(5, updateDto.getPassword());
			} else {
				sql = "update board set title=?, content=? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, updateDto.getTitle());
				pstmt.setString(2, updateDto.getContent());
				pstmt.setInt(3, updateDto.getBno());
				pstmt.setString(4, updateDto.getPassword());
			}
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
