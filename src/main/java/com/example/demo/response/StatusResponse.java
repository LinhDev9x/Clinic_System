package com.example.demo.response;

public enum StatusResponse {
	SUCCESS(2000, "SUCCESS"), 
	DATA_NOT_FOUND(7777, "DATA_NOT_FOUND"), 
	FAIL(9999, "FAIL"),
	BAD_REQUEST(4004, "BAD_REQUEST"), 
	ERROR(5000, "ERROR"), 
	NO_CONTENT(2004, "NO_CONTENT"),
	DUPLICATE(4444, "DUPLICATE");
	
	private final int code;
	private final String name;

	private StatusResponse(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
