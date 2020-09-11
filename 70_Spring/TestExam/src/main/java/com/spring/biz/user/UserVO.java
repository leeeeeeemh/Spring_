package com.spring.biz.user;

public class UserVO {
	private String id;
	private String name;
	private String password;
	private String email;
	private String nikname;
	
	public UserVO() {}

	public UserVO(String id, String name, String password, String email, String nikname) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.nikname = nikname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNikname() {
		return nikname;
	}

	public void setNikname(String nikname) {
		this.nikname = nikname;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", nikname="
				+ nikname + "]";
	}
	
	
}