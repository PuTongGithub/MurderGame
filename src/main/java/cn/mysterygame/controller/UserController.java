package cn.mysterygame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mysterygame.entity.User;
import cn.mysterygame.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/insert")
	public void insert(User user) {
		userService.insert(user);
	}
	
	@GetMapping("/api/findByUsername")
	public List<User> selectByUsername(String username) {
		return userService.selectByUsername(username);
	}
}
