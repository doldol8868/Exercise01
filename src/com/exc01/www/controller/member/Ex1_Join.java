package com.exc01.www.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exc01.www.controller.Ex1_MainController;

public class Ex1_Join implements Ex1_MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/com/exc01/www/member/ex1_join.jsp";
		System.out.println(view);
		
		// 로그인 했는지 세션으로 확인
		HttpSession session = req.getSession();
		String sid = (String)session.getAttribute("SID");
		
		return view;
	}
}
