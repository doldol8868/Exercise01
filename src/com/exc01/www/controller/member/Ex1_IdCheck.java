package com.exc01.www.controller.member;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

import com.exc01.www.dao.*;

// 이 클래스는 아이디 체크 요청을 비동기 방식으로 처리할 클래스

@WebServlet("/member/ex1_idCheck.eck")
public class Ex1_IdCheck extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{

		// 데이터 받고
		String sid = req.getParameter("id");
		
		// 데이터베이스에서 조회
		Ex1_MemberDAO mDAO = new Ex1_MemberDAO();
		int cnt = mDAO.getIdCnt(sid);
				
		// 결과를 보내주고
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("{");
		pw.println("	\"cnt\" : " + cnt);
		pw.println("}");
	}
}
/*
json 형식
	{
		"키값" : 데이터,
		"키값" : 데이터,
		...
	}
*/
