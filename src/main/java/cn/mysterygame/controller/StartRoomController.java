package cn.mysterygame.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mysterygame.entity.Play;
import cn.mysterygame.service.StartRoomService;

@RestController
@RequestMapping("/game/startRoom")
public class StartRoomController {

	@Autowired
	StartRoomService startRoomService;
	
	@PostMapping("/getPlays")
	public List<Play> getPlays(){
		return startRoomService.getPlays();
	}
	
	@PostMapping("/start")
	public Map<String, Object> start(@CookieValue("userId") int userId, int playId, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int gameId = startRoomService.start(userId, playId);
		startRoomService.updateUserStatus(userId, 2, gameId);
		
		Cookie cookie = new Cookie("userId", String.valueOf(userId));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		cookie = new Cookie("userStatus", String.valueOf(2));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		cookie = new Cookie("gameId", String.valueOf(gameId));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		map.put("success", true);
		map.put("message", "创建房间成功！");
		return map;
	}
}
