package com.spring.withwork.vo;

public class NoticeVO {
	private int m_num;
	private int room_id;
	private String regdate;
	private String content;
	private String attfile;
	
	public NoticeVO() {}

	public NoticeVO(int m_num, int room_id, String regdate, String content, String attfile) {
		super();
		this.m_num = m_num;
		this.room_id = room_id;
		this.regdate = regdate;
		this.content = content;
		this.attfile = attfile;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttfile() {
		return attfile;
	}

	public void setAttfile(String attfile) {
		this.attfile = attfile;
	}

	@Override
	public String toString() {
		return "NoticeVO [m_num=" + m_num + ", room_id=" + room_id + ", regdate=" + regdate + ", content=" + content
				+ ", attfile=" + attfile + "]";
	}
	
}
