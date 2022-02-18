package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.request.form.UserForm;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.StatusResponse;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {

	@PostMapping("/insert")
	public ResponseEntity<?> insertUser(@RequestBody UserForm userForm) {
		BaseResponse response = new BaseResponse();
		// Kiem tra body null hay khong
		if (userForm == null) {
			response.setResponseStatusCode(StatusResponse.BAD_REQUEST.getCode());
			response.setResponseStatusMessage(StatusResponse.BAD_REQUEST.getName());
		} else {
			UserDto result = userService.insertUser(userForm);
			if (result != null) {
				response.setResponseStatusCode(StatusResponse.SUCCESS.getCode());
				response.setResponseStatusMessage(StatusResponse.SUCCESS.getName());
				response.setContent(result);
			} else {
				response.setResponseStatusCode(StatusResponse.FAIL.getCode());
				response.setResponseStatusMessage(StatusResponse.FAIL.getName());
			}
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/get/by/id")
	public ResponseEntity<?> insertUser(@RequestParam Integer id) {
		BaseResponse response = new BaseResponse();
		UserDto result = userService.getUserById(id);
		if (result != null) {
			response.setResponseStatusCode(StatusResponse.SUCCESS.getCode());
			response.setResponseStatusMessage(StatusResponse.SUCCESS.getName());
			response.setContent(result);
		} else {
			response.setResponseStatusCode(StatusResponse.DATA_NOT_FOUND.getCode());
			response.setResponseStatusMessage(StatusResponse.DATA_NOT_FOUND.getName());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
