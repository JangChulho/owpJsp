package com.codin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.codin.exception.FindException;
import com.codin.service.MemberService;
import com.codin.vo.Member;

public class voteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재투표인원
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String votedate = sdf.format(new Date());
		
		ArrayList<Member> mlist = new ArrayList<Member>();
		MemberService ms = new MemberService();
		JSONArray jArray = new JSONArray();
		int no = 1;
		try {
			mlist = ms.findByDate(votedate);
			for(Member m : mlist){
				JSONObject obj = new JSONObject();
				obj.put("no", no++);
				obj.put("id", m.getId());
				obj.put("name", URLEncoder.encode(m.getName(),"UTF-8"));
				jArray.add(obj);				
			}
		} catch (FindException e) {			
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(jArray.toJSONString());
	}

}
