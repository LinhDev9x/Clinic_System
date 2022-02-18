package com.example.demo.service.implement;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.request.form.UserForm;
import com.example.demo.service.IUserService;
import com.example.demo.util.PasswordUtil;

@Service
public class UserService extends AbstractService implements IUserService {

	@Override
	public UserDto insertUser(UserForm userForm) {
		// TODO Auto-generated method stub
		try {
			if (userForm != null) {
				User user = new User();
				user.setPhone(userForm.getPhone());
				user.setPassword(PasswordUtil.createHash(userForm.getPassword()));
				user.setUserRole(userForm.getUserRole());
				user.setCreatedAt(Calendar.getInstance().getTime());
				user.setUpdatedAt(Calendar.getInstance().getTime());
				user = userRepository.save(user);
				if (user != null && user.getId() > 0)
					return new UserDto(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public UserDto getUserById(int id) {
		// TODO Auto-generated method stub
		try {
			if (id > 0) {
				Optional<User> optional = userRepository.findById(id);
				if (optional.isPresent())
					return new UserDto(optional.get());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
