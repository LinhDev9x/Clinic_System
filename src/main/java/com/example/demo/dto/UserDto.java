package com.example.demo.dto;

import java.util.Date;

import com.example.demo.model.User;

import lombok.Data;

@Data
public class UserDto {
	private Integer id;
	private String phone;
	private String fullName;
	private Boolean gender;
	private String email;
	private Date dob;
	private Short status;
	private Date createdAt;
	private Date updatedAt;
	private Short userRole;

	public UserDto(User u) {
		if (u != null) {
			this.id = u.getId();
			this.phone = u.getPhone();
			this.fullName = u.getFullName();
			this.gender = u.getGender();
			this.email = u.getEmail();
			this.dob = u.getDob();
			this.status = u.getStatus();
			this.createdAt = u.getCreatedAt();
			this.updatedAt = u.getUpdatedAt();
			this.userRole = u.getUserRole();
		}
	}

}
