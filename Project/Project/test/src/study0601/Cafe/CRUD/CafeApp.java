package study0601.Cafe.CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CafeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}//

	public void begin() {
		
		Menu menu = new Menu();
		Order order = new Order();
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		while (loop) {
			System.out.println("########## Cafe App ##########");
			System.out.println("1. 메뉴관리");
			System.out.println("2. 주문관리");
			System.out.println("9. 종료");
			
			System.out.print("메뉴를 선택하세요 =>");
			int choice = sc.nextInt();
			sc.nextLine();
			
			if(choice==1) {		
				menu.begin();			
			}else if (choice==2) {
				order.begin();
			}else if (choice == 9) {
				System.out.println("종료합니다.");
				loop=false;
				break;
			}else {
				System.out.println("※다시 선택해주세요.");
			}
		}
		sc.close();
		
		
		
				
	}

}//
