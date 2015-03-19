package com.codin.service;

import java.util.ArrayList;

import com.codin.dao.VoteDAO;
import com.codin.dao.VoteDAOOracle;
import com.codin.exception.AddException;
import com.codin.exception.DeleteException;
import com.codin.exception.FindException;
import com.codin.vo.Vote;

public class VoteService {
	private VoteDAO dao;
	public VoteService(){
		dao = new VoteDAOOracle();
	}
	//Vote 아이디와 날짜로 검색
	public Vote findById(String id, String votedate) throws FindException{
		return dao.findById(id, votedate);
	}
	//Vote 추가
	public void add(Vote v) throws AddException{
		dao.add(v);
	}
	//Vote 날짜로 검색
	public ArrayList<Vote> findByDate(String votedate) throws FindException{
		return dao.findByDate(votedate);
	}
	//Vote 해당날짜 일치시 삭제
	public void deleteByDate(String votedate) throws DeleteException{
		dao.deleteByDate(votedate);
	}
	//Vote 아이디와 날짜 일치시 삭제
	public void deleteByIdAndDate(String id, String votedate) throws DeleteException{
		dao.deleteByIdAndDate(id, votedate);
	}
}
