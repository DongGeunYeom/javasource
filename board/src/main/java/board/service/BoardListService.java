package board.service;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
import board.dto.SearchDTO;
public class BoardListService {
	public List<BoardDTO> getList(SearchDTO searchDto){
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		List<BoardDTO> list = dao.listAll(searchDto);
		
		close(con);
		return list;
	}
}
