package com.dev.vo;

import java.sql.Date;

public class BoardVO {
	private int b_id;
	private String m_id;
	private String b_title;
	private String b_content;
	private Date b_date;

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int i) {
		this.b_id = i;
	}

	public String getId() {
		return m_id;
	}

	public void setId(String id) {
		this.m_id = id;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	@Override
	public String toString() {
		return "BoardVO [b_id=" + b_id + ", id=" + m_id + ", b_title=" + b_title + ", b_content=" + b_content
				+ ", b_date=" + b_date + "]";
	}

}
