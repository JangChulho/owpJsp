package com.codin.service;

import java.util.ArrayList;

import com.codin.dao.MemberDAO;
import com.codin.dao.MemberDAOOracle;
import com.codin.exception.AddException;
import com.codin.exception.FindException;
import com.codin.vo.Member;

public class MemberService {
	private MemberDAO dao;
	public MemberService(){
		dao = new MemberDAOOracle();		
	}
	//Member 로그인
	public Member login(String id, String password) throws FindException{
		Member c = dao.findById(id);
		if(password.equals(c.getPassword())){
			return c;
		}else{
			throw new FindException("비밀번호가 맞지 않습니다.");
		}
	}
	//Member 추가
	public void add(Member m) throws AddException{
		dao.add(m);
	}
	//Member 아이디로 검색
	public Member findById(String id) throws FindException{
		return dao.findById(id);
	}
	//Member 날짜로 검색
	public ArrayList<Member> findByDate(String votedate) throws FindException{
		return dao.findByDate(votedate);
	}
}
