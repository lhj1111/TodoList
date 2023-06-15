package study0601.Cafe.CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

	public void begin() {
		// TODO Auto-generated method stub

		MenuManager mm = new MenuManager();
		Scanner sc = new Scanner(System.in);

		boolean loop = true;
		while (loop) {
			// try {

			System.out.println("\n======= [메뉴 관리] ========");
			System.out.println("1. 메뉴 조회");
			System.out.println("2. 메뉴 추가");
			System.out.println("3. 메뉴 수정");
			System.out.println("4. 메뉴 삭제");

			System.out.println("9. 종료");
			System.out.print("메뉴를 선택하세요 =>");
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[메뉴조회]");
				List<MenuVO> menuList = mm.getMenuList();

				for (int i = 0; i < menuList.size(); i++) {
					System.out.println("    " + menuList.get(i).getNum() + ". " 
							+ menuList.get(i).getCate() + " : "
							+ menuList.get(i).getName() + " "
							+ menuList.get(i).getPrice()+"(원)");
				}
				break;

			case "2":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[메뉴 추가]");

				System.out.print("메뉴번호를 입력하세요 =>");
				String numC = sc.nextLine();

				System.out.print("메뉴 카테고리를 입력하세요 (커피/에이드/케이크) =>");
				String cateC = sc.nextLine();

				System.out.print("메뉴명을 입력하세요. =>");
				String nameC = sc.nextLine();

				System.out.print("가격을 입력하세요 =>");
				String priceC = sc.nextLine();
				mm.addMenu(numC, cateC, nameC, priceC);

				break;
			case "3":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[메뉴수정]");

				System.out.print("메뉴번호를 입력하세요 =>");
				String numU = sc.nextLine();

				System.out.print("메뉴 카테고리를 입력하세요 (커피/에이드/케이크) =>");
				String cateU = sc.nextLine();

				System.out.print("메뉴명을 입력하세요. =>");
				String nameU = sc.nextLine();
				sc.nextLine();

				System.out.print("가격을 입력하세요 =>");
				String priceU = sc.nextLine();

				mm.updateMenu(numU, cateU, nameU, priceU);

				break;
			case "4":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[메뉴삭제]");
				System.out.print("메뉴 번호를 입력하세요 =>");
				String numD = sc.nextLine();

				mm.deleteMenu(numD);
				break;

			case "9":
				System.out.println();
				System.out.println("==========================");
				System.out.println("[종료]");
				System.out.println("프로그램을 종료합니다.");
				loop = false;
				break;

			default:
				System.out.println("잘못 선택하셨습니다.");
				break;
			}
			// } catch (Exception e) {

			// }

		} // while

		sc.close();

		System.out.println("Scanner Closed.");

	}

}//
