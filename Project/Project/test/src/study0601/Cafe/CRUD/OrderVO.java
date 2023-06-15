package study0601.Cafe.CRUD;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {
	 String num;
	 String cate;
	 String name;
	 String price;
	 int cnt ;
	 String date;	
}
