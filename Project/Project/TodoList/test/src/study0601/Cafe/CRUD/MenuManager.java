package study0601.Cafe.CRUD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class MenuManager {

	// ====메뉴조회====
	public List<MenuVO> getMenuList() {
		List<MenuVO> voList = new ArrayList<MenuVO>();
		String filePath = "C:/Menu/menu.txt";
		List<String> menuList = null;
		BufferedReader br = null;

		if (!(filePath == null)) {
			menuList = new ArrayList<String>();
			try {
				br = new BufferedReader(new FileReader(filePath));
				String s;

				while ((s = br.readLine()) != null) {

					menuList.add(s);
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
		//문서에서 뽑아온 리스트 vo로 묶기
		for (int i = 0; i < menuList.size(); i++) {
			MenuVO vo = new MenuVO();
			String[] arr = menuList.get(i).split(",");

			vo.setNum(arr[0]);
			vo.setCate(arr[1]);
			vo.setName(arr[2]);
			vo.setPrice(arr[3]);

			voList.add(vo);

		}

		return voList;
	}

	// ===메뉴 추가===
	public void addMenu(String numC, String cateC, String nameC, String priceC) {
		// TODO Auto-generated method stub
		Writer writer = null;
		MenuVO vo = new MenuVO(numC, cateC, nameC, priceC);

		try {

			// 문자 기반 출력 스트림 생성
			writer = new FileWriter("C:/Menu/menu.txt", true); // 기존 문서에 이어쓰기

			// 문자열 줄력
			writer.write("\r\n" + numC + "," + cateC + "," + nameC + "," + priceC);

			writer.flush();
			writer.close();

			System.out.println("\n===== 메뉴 추가완료 =====");

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

	}//

	// ===메뉴삭제====
	public void deleteMenu(String numD) {
		// TODO Auto-generated method stub

		String filePath = "C:/Menu/menu.txt";
		List<String> menuList = null;
		BufferedReader br = null;

		if (!(filePath == null)) {
			menuList = new ArrayList<String>();
			try {
				br = new BufferedReader(new FileReader(filePath));
				String s;

				while ((s = br.readLine()) != null) {
					menuList.add(s);
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
		// 메뉴 번호 확인 후 삭제

		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).contains(numD + ",")) {
				menuList.remove(i);
			}
		}

		// 삭제된 문서 write
		Writer writer = null;

		try {
			// 문자 기반 출력 스트림 생성
			writer = new FileWriter("C:/Menu/menu.txt");

			// 문자열 줄력
			for (String menu : menuList) {
				writer.write(menu + "\r\n");
			}

			writer.flush();
			writer.close();

			System.out.println("\n===== 메뉴 삭제완료 =====");

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

	}//

	// ==== 메뉴 수정 ====
	public void updateMenu(String numU, String cateU, String nameU, String priceU) {
		// TODO Auto-generated method stub
		String filePath = "C:/Menu/menu.txt";
		List<String> menuList = null;
		BufferedReader br = null;
		String updateMenu = numU + "," + cateU + "," + nameU + "," + priceU;

		if (!(filePath == null)) {
			menuList = new ArrayList<String>();
			try {
				br = new BufferedReader(new FileReader(filePath));
				String s;

				while ((s = br.readLine()) != null) {
					menuList.add(s);
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

		// 번호 확인 -> 삭제 후 수정본 넣기
		for (int i = 0; i < menuList.size(); i++) {

			if (menuList.get(i).contains(numU + ",")) {
				menuList.remove(i);
				menuList.add(i, updateMenu);
			}
		}

		// 수정본 write
		Writer writer = null;

		try {
			// 문자 기반 출력 스트림 생성
			writer = new FileWriter("C:/Menu/menu.txt");

			// 문자열 줄력
			for (String menu : menuList) {
				writer.write(menu + "\r\n");
			}

			writer.flush();
			writer.close();

			System.out.println("\n===== 메뉴 삭제완료 =====");

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
	}

}//
