package item.action;

public class ItemActionFactory {

	private static ItemActionFactory iaf;
	
	private ItemActionFactory() {}
	
	public static ItemActionFactory getInstance() {
		if(iaf ==null) {
			iaf = new ItemActionFactory();
		}
		return iaf;
	}
	
	Action action = null;
	public Action action(String cmd) {
	
		if(cmd.equals("/list.do")) {
			action = new ItemListAction("/list.jsp");
		}else if(cmd.equals("/insert.do")) {
			action = new ItemInsertAction("/list.do");
		}
		return action;
	}
}
