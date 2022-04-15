package book.service;

import static book.dao.JdbcUtil.*;

import java.sql.Connection;

import book.dao.BookDAO;

public class BookDeleteService {
	public boolean remove(int code) {
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		boolean flag = dao.delete(code);
		
		if(flag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return flag;
	}
}
