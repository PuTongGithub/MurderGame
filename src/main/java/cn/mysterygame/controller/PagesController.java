package cn.mysterygame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

	@GetMapping(value = { "/", "/login.html" })
	public String login() {
		return "login";
	}
	
	@GetMapping(value = { "/setting.html" })
	public String setting() {
		return "setting";
	}
	
	@GetMapping(value = { "/game/index.html" })
	public String index() {
		return "game/index";
	}
	
	@GetMapping(value = { "/game/lobby.html" })
	public String lobby() {
		return "game/lobby";
	}
	
	@GetMapping(value = { "/game/startRoom.html" })
	public String startRoom() {
		return "game/startRoom";
	}
}
