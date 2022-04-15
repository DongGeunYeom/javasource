package item.service;

import static item.dao.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import item.controller.ItemDAO;
import item.dao.JdbcUtil;
import item.dto.ItemDTO;

public class ItemListService {
	
	public List<ItemDTO> listAll(){
		
		Connection con = getConnection();
		ItemDAO dao = new ItemDAO(con);
		List<ItemDTO> list = dao.getList();
	
		close(con);
		return list;
	}
}
