package book.service;

import static book.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import book.dao.BookDAO;
import book.dto.BookDTO;

public class BookSearchService {
	public List<BookDTO> list(String criteria, String keyword){
		Connection con = getConnection();
		BookDAO dao =  new BookDAO(con);
		List<BookDTO> list = dao.searchList(criteria, keyword);
		
		close(con);
		
		return list;
	}

}
