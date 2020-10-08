package com.spring.withwork.vo;

import java.sql.Date;

public class NoticeVO {
	private int m_num;
	private int room_id;
	private String time;
	private String message;
	private String attfile;
	private String content;
	private int g_num;
	private String role;
	private String g_name;
	private int cm_num;
	
	public NoticeVO() {
		System.out.println(">> NoticeVO() 객체 생성");
	}

	public NoticeVO(int m_num, int room_id, String time, String message, String attfile, String content, int g_num,
			String role, String g_name, int cm_num) {
		super();
		this.m_num = m_num;
		this.room_id = room_id;
		this.time = time;
		this.message = message;
		this.attfile = attfile;
		this.content = content;
		this.g_num = g_num;
		this.role = role;
		this.g_name = g_name;
		this.cm_num = cm_num;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	@Override
	public String toString() {
		return "NoticeVO [m_num=" + m_num + ", room_id=" + room_id + ", time=" + time + ", message=" + message
				+ ", attfile=" + attfile + ", content=" + content + ", g_num=" + g_num + ", role=" + role + ", g_name="
				+ g_name + ", cm_num=" + cm_num + "]";
	}

	
	
}
