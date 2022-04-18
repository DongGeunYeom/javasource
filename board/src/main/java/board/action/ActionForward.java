package board.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ActionForward {
	// path, 이동방식
	private String path;
	private boolean redirect; // true(sendRedirect), false(forward)
}
