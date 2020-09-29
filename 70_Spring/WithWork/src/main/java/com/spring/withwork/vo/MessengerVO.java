package com.spring.withwork.vo;

public class MessengerVO {
	private int room_id;

	public MessengerVO() {
		System.out.println(">> MessengerVO() 객체 생성");
	}

	public MessengerVO(int room_id) {
		super();
		this.room_id = room_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	@Override
	public String toString() {
		return "MessengerVO [room_id=" + room_id + "]";
	}
	
	
}
