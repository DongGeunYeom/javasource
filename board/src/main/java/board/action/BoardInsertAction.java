package board.action;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardInsertService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardInsertAction implements Action {
	
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UploadUtil util = new UploadUtil();
		HashMap<String, String> dataMap = util.uploadFile(request);
		
		// dataMap에서 값 가져오기
		BoardDTO insertDto = new BoardDTO();
		insertDto.setName(dataMap.get("name"));
		insertDto.setTitle(dataMap.get("title"));
		insertDto.setContent(dataMap.get("content"));
		insertDto.setPassword(dataMap.get("password"));
		insertDto.setAttach(dataMap.get("attach"));
		
		String page = dataMap.get("page");
		String amount = dataMap.get("amount");
		String criteria = dataMap.get("criteria");
		String keyword = URLEncoder.encode(dataMap.get("keyword"), "utf-8"); 
	
		// 서비스 호출
		BoardInsertService service = new BoardInsertService();
		boolean result = service.insert(insertDto);
		
		// 결과에 따라 페이지 이동 => 성공 qList.do, 실패 qna_board_write.jsp
		if(!result) {
			path = "/view/qna_board_write.jsp?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}else {
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}
		return new ActionForward(path, true);
	}

}
