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
import com.codin.exception.FindException;
import com.codin.vo.Member;

public class MemberDAOOracle implements MemberDAO{	
	//MySql DB 연결
	private DataSource ds;
	public MemberDAOOracle(){
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
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//Member 아이디로 검색
	@Override
	public Member findById(String id) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = ds.getConnection();
			String selectById = "SELECT * FROM member WHERE ID = ?";
			//쿼리 지정
			pstmt = con.prepareStatement(selectById);
			//물음표 값 지정
			pstmt.setString(1, id);
			//쿼리 결과 저장
			rs = pstmt.executeQuery();
			if(rs.next()){				
				return new Member(rs.getString("id"),
									rs.getString("password"),
									rs.getString("name"),
									rs.getString("gender"),
									rs.getString("phone"));																		
			}else{
				throw new FindException("해당 아이디가 존재하지 않습니다.");
			}
		}catch(Exception e){
			throw new FindException(e.getMessage());
		}finally{
			//DB 자원 반납
			close(con, pstmt, rs);
		}
	}
	//Member 추가
	@Override
	public void add(Member m) throws AddException {
		Connection con = null;
		PreparedStatement pstmt = null;	
				
		try{
			//Connection 얻기
			con = ds.getConnection();
			String insert = "INSERT INTO member(ID, PASSWORD, NAME, GENDER, PHONE) "
							+ "VALUES(?,?,?,?,?)";
			//쿼리 지정
			pstmt = con.prepareStatement(insert);
			//물음표 값 지정
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getPhone());
			int rowcnt = pstmt.executeUpdate();
			System.out.println(rowcnt+"행이 삽입되었습니다.");
		}catch(Exception e){
			System.out.println("저장오류:" + e.getMessage());
			throw new AddException(e.getMessage());		
		}finally{
			//DB 자원 반납
			close(con, pstmt, null);
		}	
	}
	//Member 투표날짜로 검색
	@Override
	public ArrayList<Member> findByDate(String votedate) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		try{
			//Connection 얻기
			con = ds.getConnection();			
			String selectByDate = "SELECT * FROM member WHERE ID IN (SELECT ID FROM vote WHERE VOTEDATE = ?)";
			//쿼리 지정
			pstmt = con.prepareStatement(selectByDate);
			//물음표 값 지정
			pstmt.setString(1, votedate);
			//쿼리 결과 저장
			rs = pstmt.executeQuery();
			while(rs.next()){				
				list.add(new Member(rs.getString("id"),
									rs.getString("password"),
									rs.getString("name"),
									rs.getString("gender"),
									rs.getString("phone")));																		
			}
			if(list.size()==0){
				throw new FindException("오늘은 투표한 인원이 없습니다.");
			}
		}catch(Exception e){
			throw new FindException(e.getMessage());
		}finally{
			//DB 자원 반납
			close(con, pstmt, rs);
			return list;
		}
	}
}
