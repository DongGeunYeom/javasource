package board.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardDTO;
import board.service.BoardReplyService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardReplyAction implements Action {

	private String path; // /qList.do
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UploadUtil util = new UploadUtil();
		HashMap<String, String> dataMap = util.uploadFile(request);
		
		// qna_board_reply.jsp 넘기는 값 가져오기(댓글 + 원본글의 re_값)
		// 댓글
		BoardDTO replyDto = new BoardDTO();
//		replyDto.setName(dataMap.get("name"));
//		replyDto.setTitle(dataMap.get("title"));
//		replyDto.setContent(dataMap.get("content"));
//		replyDto.setPassword(dataMap.get("password"));
//		replyDto.setAttach(dataMap.get("attach"));
		replyDto.setName(request.getParameter("name"));
		replyDto.setTitle(request.getParameter("title"));
		replyDto.setContent(request.getParameter("content"));
		replyDto.setPassword(request.getParameter("password"));
		
		// 원본글
//		replyDto.setReRef(Integer.parseInt(dataMap.get("re_ref")));
//		replyDto.setReSeq(Integer.parseInt(dataMap.get("re_seq")));
//		replyDto.setReLev(Integer.parseInt(dataMap.get("re_lev")));
		replyDto.setReRef(Integer.parseInt(request.getParameter("re_ref")));
		replyDto.setReSeq(Integer.parseInt(request.getParameter("re_seq")));
		replyDto.setReLev(Integer.parseInt(request.getParameter("re_lev")));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardReplyService service = new BoardReplyService();
		boolean result = service.reply(replyDto);
		
		if(!result) {
			path = "/qReplyView.do?bno="+bno;
		}
		return new ActionForward(path, false);
	}
}
