package com.datalayer.response;

import com.google.gson.Gson;

public class ErrorMessage {

	private String code;
	private String message;
	private String field;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public ErrorMessage() {
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
