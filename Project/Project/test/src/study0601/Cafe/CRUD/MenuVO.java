package study0601.Cafe.CRUD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO {	
	 String num;
	 String cate;
	 String name;
	 String price;
}
