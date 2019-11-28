package com.exc01.www.controller;

import javax.servlet.http.*;
/*
	이 인터페이스는 .cls로 오는 요청을 처리할 클래스들의 기준이 되는 인터페이스다.
	객체지향 이론에 따라서
	이 인터페이스에 작성된 함수는 클래스에서 구현할 경우 반드시 오버라이드 해야할 것이고
	이 인터페이스 변수로 구현한 클래스를 받을 경우
	함수 실행은 구현한 클래스의 오버라이드된 함수를 실행을 할 것이다.
*/

public interface Ex1_MainController {
	String execute(HttpServletRequest req, HttpServletResponse resp);
	
	/*
		이 함수를 .cls 로 요청이 왔을 경우 실행해줘야 할 함수.
		요청마다 처리해야 할 내용이 다르기 때문에
		틀을 만드는 이 인터페이스에서는 함수의 내용은 작성할 필요가 없고
		상속받아서 구현한 경우에 그 요청에 해당하는 처리 내용을 작성해야 한다.
	*/
}
