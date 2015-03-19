package com.codin.dao;

import java.util.ArrayList;

import com.codin.exception.AddException;
import com.codin.exception.FindException;
import com.codin.vo.Member;

public interface MemberDAO {
	Member findById(String id) throws FindException;
	void add(Member m) throws AddException;
	ArrayList<Member> findByDate(String votedate) throws FindException;
}
