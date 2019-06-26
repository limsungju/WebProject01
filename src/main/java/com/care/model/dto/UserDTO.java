package com.care.model.dto;

// 사용자 관리
public class UserDTO {
	private String userid; // 아이디
	private String upw; // 비밀번호
	private String uname; // 이름
	private int upoint; // 포인트
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", upw=" + upw + ", uname=" + uname + ", upoint=" + upoint + "]";
	}
	
	
	
}
