package com.upload.model;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class UploadVO {
	private Integer file_no;
	private String name;
	private String address;
	private Date birthday;
	private String photo;
	
	public Integer getFile_no() {
		return file_no;
	}
	public void setFile_no(Integer file_no) {
		this.file_no = file_no;
	}
	
	@NotEmpty(message="姓名:請勿空白")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotEmpty(message="地址:請勿空白")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
