package book.service;

import static book.dao.JdbcUtil.*;

import java.sql.Connection;

import book.dao.BookDAO;
import book.dto.BookDTO;

public class BookInsertService {
	public boolean insertBook(BookDTO insertDto) {
		
		// db작업
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		boolean flag = dao.insert(insertDto);
		
		if(flag) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return flag;
	}
}
