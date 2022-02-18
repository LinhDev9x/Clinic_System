package com.example.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.UserRepository;

public abstract class AbstractService {
	
	@Autowired
	protected UserRepository userRepository;
}
