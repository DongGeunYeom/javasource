package item.service;

import static item.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import item.dao.ItemDAO;
import item.dto.ItemDTO;

public class ItemSearchService {
	public List<ItemDTO> getList(String name, String category){
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		
		List<ItemDTO> list = dao.searchList(name, category);
		
		close(con);
		return list;	
	}
}
