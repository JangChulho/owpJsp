package com.codin.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codin.exception.FindException;
import com.codin.service.MemberService;
import com.codin.vo.Member;

public class dupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디 중복확인
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		boolean dupchk = true;
		try {
			ms.findById(id);
		} catch (FindException e) {
			dupchk = false;
		}
		PrintWriter out = response.getWriter();
		out.print(dupchk);
	}

}
