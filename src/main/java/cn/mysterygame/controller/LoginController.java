package cn.mysterygame.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.mysterygame.entity.User;
import cn.mysterygame.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userServise;

	@PostMapping("/signIn")
	public Map<String, Object> signIn(HttpServletResponse response, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		Map<String, Object> map = new HashMap<>();
		doSignIn(username, password, response, map);
		return map;
	}

	private void doSignIn(String username, String password, HttpServletResponse response, Map<String, Object> map) {
		User user = userServise.selectByUsername(username);
		if (user == null) {
			map.put("success", "false");
			map.put("message", "用户名或密码错误！");
		} else if (user.getPassword().equals(password)) {
			Cookie cookie = new Cookie("userId", String.valueOf(user.getUserId()));
			cookie.setMaxAge(86400);
			cookie.setPath("/");
			response.addCookie(cookie);
			map.put("success", "success");
			map.put("message", "登陆成功！");
		} else {
			map.put("success", "false");
			map.put("message", "用户名或密码错误！");
		}
	}

	@PostMapping("/signUp")
	public Map<String, Object> signUp(HttpServletResponse response, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		Map<String, Object> map = new HashMap<>();
		doSignUp(username, password, response, map);
		return map;
	}

	private void doSignUp(String username, String password, HttpServletResponse response, Map<String, Object> map) {
		User user = userServise.selectByUsername(username);
		if (user != null) {
			map.put("success", "false");
			map.put("message", "用户名已存在！");
		} else {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			userServise.insert(newUser);
			user = userServise.selectByUsername(username);
			Cookie cookie = new Cookie("userId", String.valueOf(user.getUserId()));
			cookie.setMaxAge(86400);
			cookie.setPath("/");
			response.addCookie(cookie);
			map.put("success", "success");
			map.put("message", "登陆成功！");
		}
	}
}
