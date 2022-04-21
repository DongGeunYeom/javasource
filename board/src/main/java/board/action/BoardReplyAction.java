package board.action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardReplyService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardReplyAction implements Action {

	private String path; // /qList.do
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// qna_board_reply.jsp 넘기는 값 가져오기(댓글 + 원본글의 re_값)
		// 댓글
		BoardDTO replyDto = new BoardDTO();
		replyDto.setName(request.getParameter("name"));
		replyDto.setTitle(request.getParameter("title"));
		replyDto.setContent(request.getParameter("content"));
		replyDto.setPassword(request.getParameter("password"));
		
		// 원본글
		replyDto.setReRef(Integer.parseInt(request.getParameter("re_ref")));
		replyDto.setReSeq(Integer.parseInt(request.getParameter("re_seq")));
		replyDto.setReLev(Integer.parseInt(request.getParameter("re_lev")));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 페이지 나누기
		String page = request.getParameter("page");
		String amount = request.getParameter("amount");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"), "utf-8"); 

		BoardReplyService service = new BoardReplyService();
		boolean result = service.reply(replyDto);
		
		if(!result) {
			path = "/qReplyView.do?bno="+bno+"&page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}else { 
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}
		
		return new ActionForward(path, false);
	}
}
