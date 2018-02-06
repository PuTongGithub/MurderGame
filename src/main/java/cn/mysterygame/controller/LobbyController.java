package cn.mysterygame.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mysterygame.entity.GameRole;
import cn.mysterygame.service.LobbyService;

@RestController
@RequestMapping("/game/lobby")
public class LobbyController {

	@Autowired
	LobbyService lobbyService;

	@PostMapping("/findRoom")
	public Map<String, Object> findRoom(@CookieValue("userId") int userId, int gameId,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int status = lobbyService.findRoom(gameId);
		if (status == -1) {
			map.put("success", false);
			map.put("message", "没有找到游戏房间！");
		} else if (status == 0) {
			map.put("success", false);
			map.put("message", "游戏已关闭！");
		} else if (status == 1) {
			map.put("success", false);
			map.put("message", "游戏尚未开始！");
		} else if (status == 2) {
			setCookie(response, gameId);
			map.put("success", true);
			map.put("message", "进入房间！");
			map.put("url","role.html");
		} else {
			GameRole role = lobbyService.findUserInRoom(gameId, userId);
			if (role != null) {
				setCookie(response, gameId);
				map.put("success", true);
				map.put("message", "进入房间！");
				map.put("url", "index.html");
			} else {
				map.put("success", false);
				map.put("message", "游戏已开始！");
			}
		}
		return map;
	}
	
	private void setCookie(HttpServletResponse response, int gameId) {
		Cookie cookie = new Cookie("gameId", String.valueOf(gameId));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		
	}
}
