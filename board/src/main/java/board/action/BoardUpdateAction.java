package board.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardUpdateService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardUpdateAction implements Action {
	private String path; // "/qView.do"
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UploadUtil util = new UploadUtil();
		HashMap<String, String> dataMap = util.uploadFile(request);
		int bno = Integer.parseInt(dataMap.get("bno"));
		
		// dataMap에서 값 가져오기
		BoardDTO updateDto = new BoardDTO();
		updateDto.setBno(bno);
		updateDto.setTitle(dataMap.get("title"));
		updateDto.setContent(dataMap.get("content"));
		updateDto.setPassword(dataMap.get("password"));
		updateDto.setAttach(dataMap.get("attach")); // 파일첨부를 했다면 값이 들어와 있고, 안했다면 null
		
		//서비스 호출
		BoardUpdateService service = new BoardUpdateService();
		boolean result = service.modify(updateDto);
		
		// 결과에 따라 페이지 이동 => 성공 : qView.do, 실패 : qModify.do
		if(!result) {
			path ="/qModify.do?bno="+bno;
		}else {
			path += "?bno="+bno; // "/qView.do?bno=3"
		}
		return new ActionForward(path, true);
	}
}
