package com.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.VO.TodoVO;

public class FileController {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	String filePath = "C:/Temp/todo/todo.txt";
	Calendar calendar = Calendar.getInstance();
	String date = formatter.format(calendar.getTime());
	String check = "N";

	// ===파일에 텍스트 쓰기
	public void fileInsert(String content, int lastNum) {

		// Writer writer = null;

		BufferedWriter out = null;

		try {

			// 문자 기반 출력 스트림 생성
			// writer = new FileWriter(filePath, true); // 기존 문서에 이어쓰기

			FileOutputStream output = new FileOutputStream(filePath, true);
			OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
			out = new BufferedWriter(writer);

			// 문자열 줄력
			out.write("\r\n" + (lastNum + 1) + "," + content + "," + date + "," + check);

			out.flush();
			out.close();

		

		} catch (IOException e) {
			System.out.println("\n===== catch() :  IOException =====");
			e.printStackTrace();
		} finally {
			// releases all system resources from the streams
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("\n===== finally() :  IOException  =====");
				e.printStackTrace();
			}
		}

	}//

	// 파일 자체를 항상 UTF-8로 간주해서 읽어 들이기
	// BufferedReader reader = new BufferedReader(new FileReader(filepath));
	// BufferedReader reader = new BufferedReader(new InputStreamReader(new
	// FileInputStream(filepath),"UTF8"));

	// ==파일 전체 리스트 => voList
	public List<TodoVO> fileRead() {
		// TODO Auto-generated method stub

		List<TodoVO> voList = new ArrayList<TodoVO>();
		List<String> todoList = null;
		BufferedReader br = null;

		if (!(filePath == null)) {
			todoList = new ArrayList<String>();
			try {
				FileInputStream input = new FileInputStream(filePath);
				InputStreamReader reader = new InputStreamReader(input, "UTF-8");
				br = new BufferedReader(reader);

				String s;

				while ((s = br.readLine()) != null) {

					todoList.add(s);
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
		// 리스트 뽑아서 vo에 저장
		for (int i = 0; i < todoList.size(); i++) {
			TodoVO vo = new TodoVO();
			String[] arr = todoList.get(i).split(",");
			vo.setNum(Integer.parseInt(arr[0]));
			vo.setContent(arr[1]);
			vo.setDate(arr[2]);
			vo.setCheck(arr[3]);
			voList.add(vo);
		}

		return voList;

	}//

	// ===할일삭제====
	public void fileDelete(int deleteNum) {
		// TODO Auto-generated method stub

		List<String> todoList = null;
		BufferedReader br = null;

		if (!(filePath == null)) {
			todoList = new ArrayList<String>();
			try {
				//br = new BufferedReader(new FileReader(filePath));
				
				FileInputStream input = new FileInputStream(filePath);
				InputStreamReader reader = new InputStreamReader(input, "UTF-8");
				br = new BufferedReader(reader);
				
				String s;

				while ((s = br.readLine()) != null) {
					todoList.add(s);
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

		for (int i = 0; i < todoList.size(); i++) {

			if (todoList.get(i).contains(deleteNum + ",")) {
				todoList.remove(i);
			}
		}

		// 삭제된 문서 write
		BufferedWriter out = null;

		try {
			// 문자 기반 출력 스트림 생성

			FileOutputStream output = new FileOutputStream(filePath);
			OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
			out = new BufferedWriter(writer);

			// 문자열 줄력
			for (String todo : todoList) {
				out.write(todo + "\r\n");
			}

			out.flush();
			out.close();

		

		} catch (IOException e) {
			System.out.println("\n===== catch() :  IOException =====");
			e.printStackTrace();
		} finally {
			// releases all system resources from the streams
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("\n===== finally() :  IOException  =====");
				e.printStackTrace();
			}
		}

	}//

	// ====할일 수정====
	public void fileUpdate(int updateNum, String contentUp) {
		// TODO Auto-generated method stub

		List<String> todoList = null;
		BufferedReader br = null;
		String todoUpdate = updateNum + "," + contentUp + "," + date + "," + check;

		if (!(filePath == null)) {
			todoList = new ArrayList<String>();
			try {
				FileInputStream input = new FileInputStream(filePath);
				InputStreamReader reader = new InputStreamReader(input, "UTF-8");
				br = new BufferedReader(reader);

				String s;

				while ((s = br.readLine()) != null) {
					todoList.add(s);
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

		for (int i = 0; i < todoList.size(); i++) {

			if (todoList.get(i).contains(updateNum + ",")) {
				todoList.remove(i);
				todoList.add(i, todoUpdate);
			}
		}

		// 삭제된 문서 write
		BufferedWriter out = null;

		try {
			// 문자 기반 출력 스트림 생성
			FileOutputStream output = new FileOutputStream(filePath);
			OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
			out = new BufferedWriter(writer);

			// 문자열 줄력
			for (String todo : todoList) {
				writer.write(todo + "\r\n");
			}

			out.flush();
			out.close();

			

		} catch (IOException e) {
			System.out.println("\n===== catch() :  IOException =====");
			e.printStackTrace();
		} finally {
			// releases all system resources from the streams
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("\n===== finally() :  IOException  =====");
				e.printStackTrace();
			}
		}

	}//

	// ====todoList 체크====
	public void fileCheck(int checkNum, String checkContent, String checkDate, String checkYN) {
		// TODO Auto-generated method stub
		List<String> todoList = null;
		BufferedReader br = null;

		String todoCheck = checkNum + "," + checkContent + "," + checkDate + "," + checkYN;

		if (!(filePath == null)) {
			todoList = new ArrayList<String>();
			try {
				FileInputStream input = new FileInputStream(filePath);
				InputStreamReader reader = new InputStreamReader(input, "UTF-8");
				br = new BufferedReader(reader);
				String s;

				while ((s = br.readLine()) != null) {
					todoList.add(s);
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

		for (int i = 0; i < todoList.size(); i++) {

			if (todoList.get(i).contains(checkNum + ",")) {
				todoList.remove(i);
				todoList.add(i, todoCheck);
			}
		}

		// 삭제된 문서 write
		BufferedWriter out = null;

		try {
			// 문자 기반 출력 스트림 생성
			FileOutputStream output = new FileOutputStream(filePath);
			OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
			out = new BufferedWriter(writer);

			// 문자열 줄력
			for (String todo : todoList) {
				writer.write(todo + "\r\n");
			}

			out.flush();
			out.close();

			

		} catch (IOException e) {
			System.out.println("\n===== catch() :  IOException =====");
			e.printStackTrace();
		} finally {
			// releases all system resources from the streams
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("\n===== finally() :  IOException  =====");
				e.printStackTrace();
			}
		}

	}//

}//
