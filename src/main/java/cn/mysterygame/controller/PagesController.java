package cn.mysterygame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
	@GetMapping(value = { "/index.html" })
	public String index() {
		return "index";
	}

	@GetMapping(value = { "/", "/login.html" })
	public String login() {
		return "login";
	}
	
	@GetMapping(value = { "/setting.html" })
	public String setting() {
		return "setting";
	}
}
