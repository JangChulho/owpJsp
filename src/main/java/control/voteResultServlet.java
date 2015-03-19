package com.codin.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codin.exception.FindException;
import com.codin.service.VoteService;
import com.codin.vo.Vote;

public class voteResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//득표수 확인
		String name = request.getParameter("name");
		String[] namelst = name.split(",");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String votedate = sdf.format(new Date());
		
		ArrayList<Vote> vlist = new ArrayList<Vote>();		
		VoteService vs = new VoteService();
		JSONArray jArray = new JSONArray();		
						
		try {
			vlist = vs.findByDate(votedate);			
			String nst = "";
			for(Vote v:vlist){
				nst = nst+v.getSelectmem()+",";				
			}
			String[] nlist = nst.split(",");
			
			for(String n1:namelst){
				int result = 0;
				for (String n2:nlist){
					if(n1.equals(n2)){
						result = result+1;
					}
				}
				JSONObject obj = new JSONObject();
				obj.put("name", URLEncoder.encode(n1,"UTF-8"));
				obj.put("votenum", result);
				jArray.add(obj);
			}		
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.print(jArray.toJSONString());		
	}

}
