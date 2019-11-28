package com.exc01.www.dao;

import java.sql.*;

import com.exc01.www.sql.*;
import com.exc01.www.vo.*;
import DB.*;

public class Ex1_MemberDAO {
	// DataSource 를 관리할 변수 선언
	DBCP db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Ex1_MemberSQL mSQL = null;
	Ex1_MemberVO mVO = null;

	public Ex1_MemberDAO() {
		// DBCP 초기화
		db = new DBCP();
		// MemberSQL 초기화
		mSQL = new Ex1_MemberSQL();
	}
	
	// 로그인 데이터베이스 전담 처리 함수
	public int getLogin(String sid, String spw) {
		int cnt = 0;
		// 1. 커넥션 얻어오고
		con = db.getCon();
		
		// 2. sql 가져오고
		String sql = mSQL.getSQL(mSQL.GET_LOGIN);
		
		// 3. PreparedStatement 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 4. 질의명령 완성하고
			pstmt.setString(1, sid);
			pstmt.setString(2, spw);
			
			// 5. 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			// 한 줄 내리고
			rs.next();
			
			// 6. 데이터 꺼내고
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 회원가입 전담 처리 함수
	public int addMemb(Ex1_MemberVO vo) {
		int cnt = 0;
		
		// 할 일
		// 커넥션 얻어오고
		con = db.getCon();
		
		// 질의 명령 얻어오고
		String sql = mSQL.getSQL(mSQL.ADD_MEMB);
		
		// PreparedStatement 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getMail());
			pstmt.setString(5, vo.getTel());
			
			// 질의명령 보내고 함수의 반환값 받고
			// executeUpdate() 는 실행되면 변경된 데이터의 수를 반환해 준다.
			// Insert 명령에서는 데이터가 추가되면 1을
			// 추가에 실패하면 0을 반환해준다.
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 반환값 내보내고
		return cnt;
	}
	
	// 아이디 체크 전담 처리 함수
	public int getIdCnt(String sid) {
		int cnt = 0;
		
		con = db.getCon(); // 커넥션 얻어오기
		
		String sql = mSQL.getSQL(mSQL.SEL_ID_CK); // 질의 명령 가져오기
		
		pstmt = db.getPSTMT(con, sql); // PreparedStatement 가져오기
		
		try { 
			pstmt.setString(1, sid); // 질의명령 완성
			
			rs = pstmt.executeQuery(); // 질의명령 보내고 결과 받기
			
			rs.next();
			cnt = rs.getInt("cnt");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
