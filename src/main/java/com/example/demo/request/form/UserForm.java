package com.example.demo.request.form;

import lombok.Data;

@Data
public class UserForm {
	private String phone;
	private String password;
	private Short userRole;
}
