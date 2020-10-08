package com.spring.withwork.vo;

public class MemberVO {
	private int m_num;
	private int c_num;
	private int g_num;
	private String authority;
	private String role;
	private int d_num;
	
	public MemberVO() {
		System.out.println(">> MemberVO() 객체 생성");
	}

	public MemberVO(int m_num, int c_num, int g_num, String authority, String role, int d_num) {
		super();
		this.m_num = m_num;
		this.c_num = c_num;
		this.g_num = g_num;
		this.authority = authority;
		this.role = role;
		this.d_num = d_num;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getG_num() {
		return g_num;
	}

	public void setG_num(int g_num) {
		this.g_num = g_num;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getD_num() {
		return d_num;
	}

	public void setD_num(int d_num) {
		this.d_num = d_num;
	}

	@Override
	public String toString() {
		return "MemberVO [m_num=" + m_num + ", c_num=" + c_num + ", g_num=" + g_num + ", authority=" + authority
				+ ", role=" + role + ", d_num=" + d_num + "]";
	}
	
	
}
