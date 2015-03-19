package com.codin.vo;

public class Vote {
	private String id;
	private String votedate;
	private String selectmem;	
	public Vote(){}
	public Vote(String id, String votedate, String selectmem) {
		super();
		this.id = id;
		this.votedate = votedate;
		this.selectmem = selectmem;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVotedate() {
		return votedate;
	}
	public void setVotedate(String votedate) {
		this.votedate = votedate;
	}
	public String getSelectmem() {
		return selectmem;
	}
	public void setSelectmem(String selectmem) {
		this.selectmem = selectmem;
	}
}
