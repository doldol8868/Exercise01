package main;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/Ex1_Main")
public class Ex1_MainCont extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("############## Ex1_maincont");
		String view = "/main/ex1_main.jsp";
		req.getRequestDispatcher(view).forward(req, resp);
	}
}
