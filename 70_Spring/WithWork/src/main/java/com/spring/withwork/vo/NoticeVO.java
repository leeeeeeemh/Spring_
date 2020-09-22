package com.spring.withwork.vo;

import java.sql.Blob;
import java.sql.Date;

public class NoticeVO {
	private int m_num;
	private int room_id;
	private Date time;
	private String message;
	private Blob attfile;
	private String content;
	private String g_name;
	private String role;
	
	public NoticeVO() {
		System.out.println(">> NoticeVO() 객체 생성");
	}

	public NoticeVO(int m_num, int room_id, Date time, String message, Blob attfile, String content, String g_name,
			String role) {
		super();
		this.m_num = m_num;
		this.room_id = room_id;
		this.time = time;
		this.message = message;
		this.attfile = attfile;
		this.content = content;
		this.g_name = g_name;
		this.role = role;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Blob getAttfile() {
		return attfile;
	}

	public void setAttfile(Blob attfile) {
		this.attfile = attfile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "NoticeVO [m_num=" + m_num + ", room_id=" + room_id + ", time=" + time + ", message=" + message
				+ ", attfile=" + attfile + ", content=" + content + ", g_name=" + g_name + ", role=" + role + "]";
	}

	
	
}
