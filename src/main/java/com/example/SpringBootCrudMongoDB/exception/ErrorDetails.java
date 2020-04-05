package com.example.SpringBootCrudMongoDB.exception;

public class ErrorDetails {
	public ErrorDetails(String status, String detail) {
		super();
		this.status = status;
		this.detail = detail;
	}
	private EmployeeNotFoundException error;
	public EmployeeNotFoundException getError() {
		return error;
	}
	public void setError(EmployeeNotFoundException error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	String status;
	String detail;

}
