package com.exc01.www.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exc01.www.controller.Ex1_MainController;

public class Ex1_LoginForm implements Ex1_MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/com/exc01/www/member/ex1_login.jsp";
		System.out.println(view);
		/*
		boolean bool = (boolean) req.getAttribute("isRD");
		// 만약 이 요청의 결과가 리다이렉트인 경우는
		// 요청객체에 저장된 "isRD"의 데이터를 true 로 변경해주면 될 것이다.
		 
		req.setAttribute("isRD", "true");
		*/
		
		return view;
	}
}
