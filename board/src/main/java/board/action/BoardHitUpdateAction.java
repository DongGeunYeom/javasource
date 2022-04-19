package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardHitUpdateService;
import board.service.BoardViewService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardHitUpdateAction implements Action {
	
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// bno 가져오기
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// hit service 작업 => 조회수 업데이트
		BoardHitUpdateService hitService = new BoardHitUpdateService();
		hitService.readUpdate(bno);
	
		path += "?bno="+bno;
		
		return new ActionForward(path, true);
	}

}
