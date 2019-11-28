package com.exc01.www.controller.member;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.exc01.www.dao.*;
import com.exc01.www.vo.*;
import com.exc01.www.controller.*;

public class Ex1_JoinExec implements Ex1_MainController {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		// 1. 데이터 받기
		String tid = req.getParameter("id");
		String tpw = req.getParameter("pw");
		String tname = req.getParameter("name");
		String tmail = req.getParameter("mail");
		String tel = req.getParameter("tel");
		
		// VO에 담기
		Ex1_MemberVO vo = new Ex1_MemberVO();
		vo.setId(tid);
		vo.setPw(tpw);
		vo.setName(tname);
		vo.setMail(tmail);
		vo.setTel(tel);
		
		// 2. 데이터베이스 작업
		int cnt = new Ex1_MemberDAO().addMemb(vo);
		
		// 3. 결과에 따라 처리
		String view = "Ex1_Main";
		
		if(cnt == 1) { // 회원가입 성공
			req.getSession().setAttribute("SID", tid);
			
			try {
				resp.sendRedirect(view);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 실패
			view = "/com/exc01/www/member/ex1_join.jsp";
			try {
				resp.sendRedirect(view);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return view;
	}
	
}
