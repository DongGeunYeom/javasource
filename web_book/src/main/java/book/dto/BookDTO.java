package book.dto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class BookDTO {
	private int code;
	private String title;
	private String writer;
	private int price;
	
}
