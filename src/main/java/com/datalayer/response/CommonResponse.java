package com.datalayer.response;

import java.util.List;

public class CommonResponse<O> {

	public String status;
	private int code;
	private O data;
	private List<ErrorMessage> errorMessages;

	public CommonResponse(String status, int code) {
		this.status = status;
		this.code = code;
	}

	public CommonResponse(O data) {
		this.status = "SUCCESS";
		this.code = 200;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public O getData() {
		return data;
	}

	public void setData(O data) {
		this.data = data;
	}

	public List<ErrorMessage> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<ErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;
	}

}