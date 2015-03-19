package com.codin.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codin.exception.FindException;
import com.codin.service.MemberService;
import com.codin.vo.Member;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPw");		
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");
		MemberService ms = new MemberService();
		String message = "";
		try {
			Member m = ms.login(id, pwd);
			session.setAttribute("loginInfo", m);
			if(m.getId().equals("admin")){					
				message = "관리자님 반갑습니다.";
			}else{
				message = m.getName()+"님 환영합니다.";
			}	
		} catch (FindException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("message.do");
		rd.forward(request, response);	
	}

}
