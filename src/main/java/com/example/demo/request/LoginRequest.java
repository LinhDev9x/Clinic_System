package com.example.demo.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
	@NotBlank
    private String phone;

    @NotBlank
    private String password;
}
