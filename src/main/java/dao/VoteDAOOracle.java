package com.codin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.codin.exception.AddException;
import com.codin.exception.DeleteException;
import com.codin.exception.FindException;
import com.codin.vo.Vote;

public class VoteDAOOracle implements VoteDAO {	
	//MySql DB 연결
	private DataSource ds;
	public VoteDAOOracle(){
		try {
			Context ctx = new InitialContext();			
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MysqlDS");
		} catch (NamingException e){
			e.printStackTrace();
		}
	}
	//DB 자원 반납
	private void close(Connection con, Statement stmt, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Vote id와 날짜로 검색
	@Override
	public Vote findById(String id, String votedate) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			//Connection 얻기
			con = ds.getConnection();			
			String selectById = "SELECT * FROM vote WHERE ID = ? AND VOTEDATE = ?";
			//쿼리 지정
			pstmt = con.prepareStatement(selectById);
			//물음표 값 지정
			pstmt.setString(1, id);
			pstmt.setString(2, votedate);
			//쿼리 결과 저장
			rs = pstmt.executeQuery();
			if(rs.next()){				
				return new Vote(rs.getString("id"),
									rs.getString("votedate"),
									rs.getString("selectmem"));																		
			}else{
				throw new FindException("투표를 아직 하지 않았습니다.");
			}
		}catch(Exception e){
			throw new FindException(e.getMessage());
		}finally{
			//DB 자원 반납
			close(con, pstmt, rs);
		}
	}
	@Override
	public void add(Vote v) throws AddException {
		Connection con = null;
		PreparedStatement pstmt = null;	
				
		try{
			//Connection 얻기
			con = ds.getConnection();
			String insert = "INSERT INTO vote(ID, VOTEDATE, SELECTMEM) "
							+ "VALUES(?,?,?)";
			//쿼리 지정
			pstmt = con.prepareStatement(insert);
			//물음표 값 지정
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getVotedate());
			pstmt.setString(3, v.getSelectmem());			
			int rowcnt = pstmt.executeUpdate();
			System.out.println(rowcnt+"행이 삽입되었습니다.");
		}catch(Exception e){
			System.out.println("저장오류:" + e.getMessage());
			throw new AddException("이미 투표를 하셨습니다.");		
		}finally{
			//DB 자원 반납
			close(con, pstmt, null);
		}			
	}
	//Vote 날짜로 검색
	@Override
	public ArrayList<Vote> findByDate(String votedate) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Vote> list = new ArrayList<Vote>();
		
		try{
			//Connection 얻기
			con = ds.getConnection();
			String selectByDate = "SELECT * FROM vote WHERE VOTEDATE = ?";
			//쿼리 지정
			pstmt = con.prepareStatement(selectByDate);
			//물음표 값 지정
			pstmt.setString(1, votedate);
			//쿼리 결과 저장
			rs = pstmt.executeQuery();
			
			while(rs.next()){					
				list.add(new Vote(rs.getString("id"),
									rs.getString("votedate"),
									rs.getString("selectmem")));				
			}
			if(list.size()==0){
				throw new FindException("오늘은 투표한 기록이 없습니다.");
			}
		}catch(Exception e){
			throw new FindException(e.getMessage());
		}finally{
			//DB 자원 반납
			close(con, pstmt, rs);
			return list;
		}		
	}
	//Vote 해당날짜와 일치시 삭제
	@Override
	public void deleteByDate(String votedate) throws DeleteException {
		Connection con = null;
		PreparedStatement pstmt = null;
				
		try {
			//Connection 얻기
			con = ds.getConnection();
			String delete = "DELETE FROM vote WHERE votedate = ?";
			//쿼리 지정
			pstmt = con.prepareStatement(delete);
			//물음표 값 지정
			pstmt.setString(1, votedate);
			int rowCnt = pstmt.executeUpdate();
			if(rowCnt==0){				
				throw new DeleteException("투표 초기화에 실패했습니다.");
			}
		} catch (Exception e) {			
			throw new DeleteException(e.getMessage());
		}	finally{
			//DB 자원 반납
			close(con, pstmt, null);
		}		
	}
	//Vote 아이디와 날짜 일치시 삭제
	@Override
	public void deleteByIdAndDate(String id, String votedate)
			throws DeleteException {
		Connection con = null;
		PreparedStatement pstmt = null;
				
		try {
			//Connection 얻기
			con = ds.getConnection();
			String delete = "DELETE FROM vote WHERE id = ? AND votedate = ?";
			//쿼리 지정
			pstmt = con.prepareStatement(delete);
			//물음표 값 지정
			pstmt.setString(1, id);
			pstmt.setString(2, votedate);
			int rowCnt = pstmt.executeUpdate();
			if(rowCnt==0){				
				throw new DeleteException("투표 취소가 완료되지 않았습니다.");
			}
		} catch (Exception e) {			
			throw new DeleteException(e.getMessage());
		}	finally{
			//DB 자원 반납
			close(con, pstmt, null);
		}		
	}
}
