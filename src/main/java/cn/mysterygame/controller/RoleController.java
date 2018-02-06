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

import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.Script;
import cn.mysterygame.service.RoleService;

@RestController
@RequestMapping("/game/role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@PostMapping("/getPlay")
	public Play getPlay(@CookieValue("gameId") int gameId) {
		return roleService.getPlay(gameId);
	}
	
	@PostMapping("/getRoles")
	public List<Script> getRoles(@CookieValue("gameId") int gameId){
		return roleService.getRoles(gameId);
	}
	
	@PostMapping("/getStatus")
	public List<GameRole> getStatus(@CookieValue("gameId") int gameId){
		return roleService.getStatus(gameId);
	}
	
	@PostMapping("/confirm")
	public Map<String, Object> confirm(@CookieValue("gameId") int gameId,
			@CookieValue("userId") int userId, int scriptId,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		if(roleService.roleConfirm(gameId, userId, scriptId)) {
			map.put("success", true);
			map.put("message", "选择成功！");
			
			roleService.userStatusChange(userId, gameId);
			Cookie cookie = new Cookie("userStatus", String.valueOf(1));
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			cookie = new Cookie("gameId", String.valueOf(gameId));
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			response.addCookie(cookie);
			
			roleService.clueSendOut(gameId, userId, scriptId);
		}
		else {
			map.put("success", false);
			map.put("message", "该角色已被选！");
		}
		return map;
	}
}
