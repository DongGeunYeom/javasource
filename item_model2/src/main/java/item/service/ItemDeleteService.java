package item.service;

import static item.dao.JdbcUtil.*;

import java.sql.Connection;

import item.dao.ItemDAO;

public class ItemDeleteService {
	
	public boolean remove(int num) {
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		boolean result = dao.delete(num);
		
		if(result) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}
}
