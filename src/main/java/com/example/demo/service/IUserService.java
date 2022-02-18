package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.request.form.UserForm;

public interface IUserService {
	UserDto insertUser(UserForm userForm);
	UserDto getUserById(int id);
}
