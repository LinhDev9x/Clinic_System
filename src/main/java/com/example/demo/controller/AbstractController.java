package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.IUserService;

public abstract class AbstractController {
	
	@Autowired
	protected IUserService userService;
}
