package item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import item.dto.ItemDTO;
import item.service.ItemInsertService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class ItemInsertAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ItemDTO dto = new ItemDTO();
		dto.setCategory(request.getParameter("category"));
		dto.setName(request.getParameter("name"));
		dto.setContent(request.getParameter("content"));
		dto.setPsize(request.getParameter("psize"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		ItemInsertService service = new ItemInsertService();
		boolean result = service.insertItem(dto);
		
		if(!result) {
			path = "/insert.jsp";
		}
		return new ActionForward(path, true);
	}
}
