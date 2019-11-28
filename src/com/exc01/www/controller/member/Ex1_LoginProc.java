package com.exc01.www.controller.member;
// 이 클래스는 로그인 요청이 왔을 때 요청을 처리할 클래스

import javax.servlet.http.*;

import com.exc01.www.controller.Ex1_MainController;
import com.exc01.www.dao.*;


public class Ex1_LoginProc implements Ex1_MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRD", true);
		String view = "/Ex1_Main";
		
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		
		Ex1_MemberDAO mDAO = new Ex1_MemberDAO();
		int cnt = mDAO.getLogin(sid, spw);
		
		if(cnt == 1) { // 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("SID", sid);
		} else { // 로그인 실패
			view = "ex1_login.exq";
		}
		return view;
	}
}
