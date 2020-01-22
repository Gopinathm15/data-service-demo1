package com.datalayer.request;

import javax.validation.constraints.NotBlank;

public class User {

	@NotBlank(message = "name required")
	private String name;
	@NotBlank(message = "dob required")
	private String dob;
	@NotBlank(message = "account number required")
	private String accountNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
