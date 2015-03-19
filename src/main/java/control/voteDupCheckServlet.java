package com.codin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codin.exception.FindException;
import com.codin.service.VoteService;
import com.codin.vo.Member;
import com.codin.vo.Vote;

public class voteDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//투표시간 및 중복확인
		Calendar firstMeetDay = Calendar.getInstance();
		firstMeetDay.set(2015, 0, 7, 19, 0);
		
		Calendar today = Calendar.getInstance();
		
		long diffSec = (today.getTimeInMillis()-firstMeetDay.getTimeInMillis())/1000;
		long diffHour = diffSec/3600;
		long diffDay = diffHour/24;
		long sheetNum = diffDay/7;
		long voteTimeChk = diffSec/3600%24;
		
		Calendar nextMeetDay = Calendar.getInstance();
		nextMeetDay.add(Calendar.DATE, 3);
		nextMeetDay.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);		
		nextMeetDay.set(Calendar.HOUR_OF_DAY, 19);
		nextMeetDay.set(Calendar.MINUTE, 0);
		nextMeetDay.set(Calendar.SECOND, 0);
		
		long todayMilSec = today.getTimeInMillis();
		long nextMeetDayMilSec = nextMeetDay.getTimeInMillis();
		
		if(voteTimeChk < 5 && today.get(Calendar.DAY_OF_WEEK)==4){
			HttpSession session = request.getSession();
			Member m = (Member) session.getAttribute("loginInfo");
			String id = m.getId();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String votedate = sdf.format(new Date());
			
			VoteService vs = new VoteService();
			boolean dupchk = true;		
			try {
				vs.findById(id,votedate);			
			} catch (FindException e) {
				dupchk = false;
			}	
			
			request.setAttribute("sheetNum", sheetNum);		
			
			if(dupchk){			
				RequestDispatcher rd = request.getRequestDispatcher("voteresult.do");		
				rd.forward(request, response);	
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("vote.do");		
				rd.forward(request, response);			
			}
		}else{
			request.setAttribute("todaysec", todayMilSec);
			request.setAttribute("sec", nextMeetDayMilSec);				
			RequestDispatcher rd = request.getRequestDispatcher("nextvotetime.do");		
			rd.forward(request, response);
		}		
	}
}
