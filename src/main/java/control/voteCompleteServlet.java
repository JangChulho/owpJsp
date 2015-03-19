package com.codin.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codin.exception.AddException;
import com.codin.service.VoteService;
import com.codin.vo.Member;
import com.codin.vo.Vote;

public class voteCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//투표완료
		request.setCharacterEncoding("utf-8");
		String[] votechk = request.getParameterValues("votechk");
		String selectmem = votechk[0]+","+votechk[1];
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginInfo");
		String id = m.getId();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String votedate = sdf.format(new Date());
		
		VoteService vs = new VoteService();
		String message = "";
		try {
			vs.add(new Vote(id,votedate,selectmem));
			message = selectmem+" 님께 투표가 완료되었습니다.";
		} catch (AddException e) {			
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("message.do");
		rd.forward(request, response);
	}
}
