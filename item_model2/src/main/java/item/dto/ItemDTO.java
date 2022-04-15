package item.dto;
import java.sql.Date;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ItemDTO {
	private int num;
	private String category;
	private String name;
	private String content;
	private String psize;
	private int price;
	private Date registerAt;

}
