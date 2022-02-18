package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.jwt.JwtAuthenticationEntryPoint;
import com.example.demo.security.jwt.JwtAuthenticationFilter;
import com.example.demo.security.service.CustomUserDetailsService;
import com.example.demo.util.PasswordUtil;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger*/**",
            "/v2/api-docs",
            "/configuration/**",
            "/webjars/**",
            "/auth/login",
            "/user/insert"
    };

	@Autowired
	CustomUserDetailsService userService;
	
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// Get AuthenticationManager bean
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				return null;
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				Boolean correctPass = false;
				try {
					correctPass = PasswordUtil.validatePassword(rawPassword.toString(), encodedPassword);
				} catch (Exception e) {

				}
				return correctPass;
			}
		};
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService) // Cung cáp userservice cho spring security
				.passwordEncoder(passwordEncoder()); // cung cấp password encoder
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http.cors() // Ngăn chặn request từ một domain khác
		 * .and().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().anyRequest
		 * () .authenticated(); // Tất cả các request khác đều cần phải xác thực mới
		 * được truy cập
		 * 
		 * // Thêm một lớp Filter kiểm tra jwt
		 * http.addFilterBefore(jwtAuthenticationFilter(),
		 * UsernamePasswordAuthenticationFilter.class);
		 */
		
		http
        .cors()
        .and()
        .csrf()
        .disable()
        .headers()
        .frameOptions()
        .disable()
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(unauthorizedHandler)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/",
                "/favicon.ico",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.svg",
                "/**/*.jpg",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js")
        .permitAll()
        .antMatchers(AUTH_WHITELIST)
        .permitAll()
        .anyRequest()
        .authenticated();

http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}