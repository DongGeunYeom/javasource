package board.action;

public class BoardActionFactory {

	private static BoardActionFactory baf;
	
	private BoardActionFactory() {}
	
	public static BoardActionFactory getInstance() {
		if(baf ==null) {
			baf = new BoardActionFactory();
		}
		return baf;
	}
	
	Action action = null;
	public Action action(String cmd) {
	
		if(cmd.equals("/qWrite.do")) {
			action = new BoardInsertAction("/qList.do");
		}else if(cmd.equals("/qList.do")) {
			action = new BoardListAction("/view/qna_board_list.jsp");
		}
		return action;
	}
}
