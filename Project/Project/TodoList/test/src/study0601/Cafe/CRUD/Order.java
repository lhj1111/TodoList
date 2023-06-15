package study0601.Cafe.CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

	CafeApp app = new CafeApp();
	MenuManager mm = new MenuManager();
	OrderManager om = new OrderManager();
	List<String> orderList = new ArrayList<String>();

	public void begin() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		boolean loop = true;
		while (loop) {
			// try {

			System.out.println("\n======= [주문 관리] ========");
			System.out.println("1. 메뉴 조회");
			System.out.println("2. 주문");
			System.out.println("3. 주문 조회");

			System.out.println("9. 종료");
			System.out.print("메뉴를 선택하세요 =>");
			String order = sc.nextLine();

			switch (order) {
			case "1":
				List<MenuVO> menuList = mm.getMenuList();

				for (int i = 0; i < menuList.size(); i++) {
					System.out.println("    " + menuList.get(i).getNum() + ". " + menuList.get(i).getCate() + " : "
							+ menuList.get(i).getName() + " " + menuList.get(i).getPrice() + "(원)");
				}
				break;

			case "2":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[주문]");
				
				List<OrderVO> ovoList = new ArrayList<OrderVO>();

				boolean addOrder = true;

				while (addOrder) {
					
					System.out.print("메뉴번호를 입력하세요 =>");
					String numO = sc.nextLine();

					System.out.print("주문 개수를 입력하세요 =>");
					int cnt = sc.nextInt();

					OrderVO ovo = om.add(numO, cnt);
					ovoList.add(ovo);

					System.out.println("주문을 추가하시겠습니까?");
					System.out.println("    1.추가");
					System.out.println("    2.주문종료");
					System.out.print("선택 =>");
					sc.nextLine();
					String choice = sc.nextLine();
					
					if(choice=="1") {
						addOrder=true;
						
					}else{
						System.out.println("    주문목록");
						
						int totalPrice=0;
						for (OrderVO o : ovoList) {
							System.out.println("     주문번호 "
						+ovo.getNum()+". "
						+ovo.getName()+" | "
						+"금액:"+ovo.getPrice()+" | "
						+ovo.getDate());							
						totalPrice+=Integer.parseInt(ovo.getPrice());
						}
						System.out.println("    *총 금액:"+totalPrice);
						addOrder=false;
						break;
					}

				}//while

				break;
			case "3":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[주문조회]");

				List<OrderVO> ol = om.getOrderList();

				for (int i = 0; i < ol.size(); i++) {
					System.out.println(
							"    주문목록"+
							"    " + ol.get(i).getNum() + ". " 
							+ol.get(i).getName() + " | "
							+ol.get(i).getCnt()+"(개)"						
							+ol.get(i).getPrice()+"(원)"
							+ol.get(i).getDate());
				}
			

				break;

			case "9":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[종료]");
				System.out.println("주문 관리 업무를 종료합니다.");
				loop = false;
				break;

			default:
				System.out.println("잘못 선택하셨습니다.");
				break;
			}
			// } catch (Exception e) {

			// }

		} // while

		app.begin();

	}

}
