package com.codin.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codin.exception.DeleteException;
import com.codin.service.VoteService;

public class voteCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//투표취소
		String[] votechk = request.getParameterValues("votechk");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String votedate = sdf.format(new Date());
		
		VoteService vs = new VoteService();
		String message = "";
		try {
			for(String id : votechk){
				vs.deleteByIdAndDate(id, votedate);
			}
			message = "투표가 취소되었습니다.";
		} catch (DeleteException e) {
			message = e.getMessage();
		}		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("message.do");
		rd.forward(request, response);
	}

}
