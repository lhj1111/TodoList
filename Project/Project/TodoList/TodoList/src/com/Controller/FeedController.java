package com.Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.VO.TodoVO;

public class FeedController {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendar = Calendar.getInstance();
	String date = formatter.format(calendar.getTime());

	FileController fc = new FileController();

	// ===오늘 할일 추가
	public void insert(String content, int lastNum) {
		// TODO Auto-generated method stub

		fc.fileInsert(content, lastNum);

	}//

	// ===오늘 할일 조회
	public List<TodoVO> todayRead() {
		// TODO Auto-generated method stub

		List<TodoVO> voList = fc.fileRead();
		List<TodoVO> todayList = new ArrayList<TodoVO>();

		
		for (int i = 0; i < voList.size(); i++) {

			if (voList.get(i).getDate().contains(date)) {

				todayList.add(voList.get(i));

			}

		}
		return todayList;
	}

	// 마지막 데이터의 시퀀스 번호 얻기
	public int getLastNum() {
		// TODO Auto-generated method stub

		List<TodoVO> voList = fc.fileRead();
		int lastIndex = voList.size() - 1;

		int lastNum = voList.get(lastIndex).getNum();

		return lastNum;
	}

	// ===오늘 할일 수정
	public void update(int updateNum, String contentUp) {
		// TODO Auto-generated method stub
		fc.fileUpdate(updateNum, contentUp);

	}

	// ===오늘 할일 삭제
	public void delete(int deleteNum) {
		// TODO Auto-generated method stub

		fc.fileDelete(deleteNum);

	}

	// ===오늘 할일 체크
	public void check(int checkNum, String checkContent, String checkDate, String checkYN) {
		// TODO Auto-generated method stub

		fc.fileCheck(checkNum, checkContent, checkDate, checkYN);

	}

}//
