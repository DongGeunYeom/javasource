package board.service;
import static board.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import board.dao.BoardDAO;
import board.dto.BoardDTO;
public class BoardViewService {
	public BoardDTO getView(int bno) {
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		BoardDTO dto = dao.showView(bno);
		
		close(con);
		return dto;
	}
}
