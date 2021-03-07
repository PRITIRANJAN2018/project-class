package com.ashokit.ExceptionHandler;

import java.util.Date;

public class ApiError {

	private Integer errorcode;
	private String errordesp;
	private Date date;

	public ApiError() {

	}

	public ApiError(Integer errorcode, String errordesp, Date date) {
		super();
		this.errorcode = errorcode;
		this.errordesp = errordesp;
		this.date = date;
	}

	public Integer getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrordesp() {
		return errordesp;
	}

	public void setErrordesp(String errordesp) {
		this.errordesp = errordesp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
