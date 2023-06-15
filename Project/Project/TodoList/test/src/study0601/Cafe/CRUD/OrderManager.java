package study0601.Cafe.CRUD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderManager {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	MenuManager mm = new MenuManager();
	List<String> menuList = null;
	List<String> orderList = new ArrayList<String>();
	OrderVO ovo = new OrderVO();

	// =====주문 추가
	public OrderVO add(String numO, int cnt) {
		// TODO Auto-generated method stub
		List<OrderVO> ovoList = new ArrayList<OrderVO>();
		List<MenuVO> voList = mm.getMenuList();

		for (int i = 0; i < voList.size(); i++) {
			if (voList.get(i).getNum().contains(numO)) {

				ovo.setNum("1");
				ovo.setCate(voList.get(i).getCate());
				ovo.setName(voList.get(i).getName());
				ovo.setPrice(voList.get(i).getPrice());

				ovo.setCnt(cnt);

				Calendar calendar = Calendar.getInstance();

				ovo.setDate(formatter.format(calendar.getTime()));
			}
		}

		// 주문내역 write
		Writer writer = null;

		try {
			// 문자 기반 출력 스트림 생성
			writer = new FileWriter("C:/Menu/order.txt", true);

			// 문자열 줄력

			int price = Integer.parseInt(ovo.getPrice());

			writer.write("\r\n" + ovo.getNum() + "," + ovo.getName() + "," + cnt + "," + (price * cnt) + ","
					+ ovo.getDate());

			writer.flush();
			writer.close();

			System.out.println("\n===== 주문완료 =====");

		} catch (IOException e) {
			System.out.println("\n===== catch() :  IOException =====");
			e.printStackTrace();
		} finally {
			// releases all system resources from the streams
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.println("\n===== finally() :  IOException  =====");
				e.printStackTrace();
			}
		}
		return ovo;
	}//

	// ====주문 조회
	public List<OrderVO> getOrderList() {
		// TODO Auto-generated method stub

		List<OrderVO> ovoList = new ArrayList<OrderVO>();
		String filePath = "C:/Menu/order.txt";
		List<String> orderList = null;
		BufferedReader br = null;

		if (!(filePath == null)) {
			orderList = new ArrayList<String>();
			try {
				br = new BufferedReader(new FileReader(filePath));
				String s;

				while ((s = br.readLine()) != null) {

					orderList.add(s);
				}
				br.close();
			} catch (IOException e) {
				System.err.println(e);
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (Exception ex) {
				}
			}
		}
		//주문목록 뽑기 
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = new OrderVO();
			String[] arr = orderList.get(i).split(",");

			ovo.setNum(arr[0]);
			ovo.setName(arr[1]);
			ovo.setCnt(Integer.parseInt(arr[2]));
			ovo.setPrice(arr[3]);
			ovo.setDate(arr[4]);

			ovoList.add(ovo);

		}

		return ovoList;

	}

}//
