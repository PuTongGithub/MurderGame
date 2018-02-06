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
			map.put("success", false);
			map.put("message", "用户名或密码错误！");
		} else if (user.getPassword().equals(password)) {
			doLogin(user, response);
			map.put("success", true);
			map.put("message", "登陆成功！");
			int status = user.getUserStatus();
			if(status==0) {
				map.put("url", "game/lobby.html");
			}
			else if(status == 1){
				//map.put("url","game/index.html");
			}
			else {
				//map.put("url","game/host.html");
			}
		} else {
			map.put("success", false);
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
			map.put("success", false);
			map.put("message", "用户名已存在！");
		} else {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			userServise.insert(newUser);
			user = userServise.selectByUsername(username);
			doLogin(user, response);
			map.put("success", true);
			map.put("message", "登陆成功！");
			map.put("url", "game/lobby.html");
		}
	}
	
	private void doLogin(User user, HttpServletResponse response) {
		Cookie cookie = new Cookie("userId", String.valueOf(user.getUserId()));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		cookie = new Cookie("userStatus", String.valueOf(user.getUserStatus()));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		cookie = new Cookie("gameId", String.valueOf(user.getGameId()));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
