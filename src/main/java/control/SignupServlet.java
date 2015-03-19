package com.codin.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codin.exception.AddException;
import com.codin.service.MemberService;
import com.codin.vo.Member;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPw");
		String name = request.getParameter("userName");
		String gender = request.getParameter("userSex");
		String phone = request.getParameter("userPhoneNumber");
		MemberService ms = new MemberService();
		String message = "";
		try {
			ms.add(new Member(id,pwd,name,gender,phone));
			message = "Codin9Cafe에 가입해 주셔서 감사합니다.";
		} catch (AddException e) {
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("message.do");
		rd.forward(request, response);
	}

}
