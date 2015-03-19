package com.codin.dao;

import java.util.ArrayList;

import com.codin.exception.AddException;
import com.codin.exception.DeleteException;
import com.codin.exception.FindException;
import com.codin.vo.Vote;

public interface VoteDAO {
	Vote findById(String id, String votedate) throws FindException;
	void add(Vote v) throws AddException;
	ArrayList<Vote> findByDate(String votedate) throws FindException;
	void deleteByDate(String votedate) throws DeleteException;
	void deleteByIdAndDate(String id, String votedate) throws DeleteException;
}
