package com.spring.withwork.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NoticeVO {
	private int m_num;
	private int room_id;
	private String time;
	private String message;
	private String attfile;
	private int g_num;
	private String role;
	private String g_name;
	private int cm_num;
	private int cm_num2;
	private int cj_num;
	private int p_num;
	
	//검색조건용 필드 추가
	private String searchMember;
		
	public NoticeVO() {
		System.out.println(">> NoticeVO() 객체 생성");
	}

	public NoticeVO(int m_num, int room_id, String time, String message, String attfile, int g_num,
			String role, String g_name, int cm_num, int cm_num2, int cj_num, int p_num, String searchMember) {
		super();
		this.m_num = m_num;
		this.room_id = room_id;
		this.time = time;
		this.message = message;
		this.attfile = attfile;
		this.g_num = g_num;
		this.role = role;
		this.g_name = g_name;
		this.cm_num = cm_num;
		this.cm_num2 = cm_num2;
		this.cj_num = cj_num;
		this.p_num = p_num;
		this.searchMember = searchMember;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAttfile() {
		return attfile;
	}

	public void setAttfile(String attfile) {
		this.attfile = attfile;
	}

	public int getG_num() {
		return g_num;
	}

	public void setG_num(int g_num) {
		this.g_num = g_num;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getCm_num() {
		return cm_num;
	}

	public void setCm_num(int cm_num) {
		this.cm_num = cm_num;
	}
	
	public int getCm_num2() {
		return cm_num2;
	}

	public void setCm_num2(int cm_num2) {
		this.cm_num2 = cm_num2;
	}

	public int getCj_num() {
		return cj_num;
	}

	public void setCj_num(int cj_num) {
		this.cj_num = cj_num;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	@Override
	public String toString() {
		return "NoticeVO [m_num=" + m_num + ", room_id=" + room_id + ", time=" + time + ", message=" + message
				+ ", attfile=" + attfile + ", g_num=" + g_num + ", role=" + role + ", g_name=" + g_name + ", cm_num="
				+ cm_num + ", cm_num2=" + cm_num2 + ", cj_num=" + cj_num + ", p_num=" + p_num + ", searchMember="
				+ searchMember + "]";
	}
	
	//============================================================

	@JsonIgnore // JSON 데이타 변경하지 않도록 제외 처리
	public String getSearchMember() {
		return searchMember;
	}

	public void setSearchMember(String searchMember) {
		this.searchMember = searchMember;
	}
	
}
