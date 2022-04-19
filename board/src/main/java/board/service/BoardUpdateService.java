package board.service;

import java.sql.Connection;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

import static board.dao.JdbcUtil.*;

public class BoardUpdateService {
	public boolean modify(BoardDTO updateDto) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		boolean result = dao.update(updateDto);
		if (result) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
}