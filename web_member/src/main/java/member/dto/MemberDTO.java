package member.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class MemberDTO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
	
}
