package com.spring.jdbc.entities;

import java.sql.Timestamp;

public class TimestampEntity {

	private int id;// id is autogen
	private String data;
	private Timestamp cur_timestamp;

	public TimestampEntity(int id, String data, Timestamp cur_timestamp) {
		super();
		this.id = id;
		this.data = data;
		this.cur_timestamp = cur_timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Timestamp getCur_timestamp() {
		return cur_timestamp;
	}

	public void setCur_timestamp(Timestamp cur_timestamp) {
		this.cur_timestamp = cur_timestamp;
	}

	@Override
	public String toString() {
		return "ExampleTimestamp [id=" + id + ", data=" + data + ", cur_timestamp=" + cur_timestamp + "]";
	}

	public TimestampEntity(String data, Timestamp cur_timestamp) {
		super();
		this.data = data;
		this.cur_timestamp = cur_timestamp;
	}

	public TimestampEntity() {
		super();
	}

}
