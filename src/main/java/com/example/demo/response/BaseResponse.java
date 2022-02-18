package com.example.demo.response;

import lombok.Data;

@Data
public class BaseResponse {
	protected int responseStatusCode;
	protected String responseStatusMessage;
	protected Object content;
}
