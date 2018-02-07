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

import cn.mysterygame.entity.Clue;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.Position;
import cn.mysterygame.service.HostService;

@RestController
@RequestMapping("/game/host")
public class HostController {
	
	@Autowired
	HostService hostService;

	@PostMapping("/getGame")
	public Game getGame(@CookieValue("gameId") int gameId) {
		return hostService.getGame(gameId);
	}
	
	@PostMapping("/getPlay")
	public Play getPlay(@CookieValue("gameId") int gameId) {
		return hostService.getPlay(gameId);
	}
	
	@PostMapping("/clueStart")
	public Map<String, Object> clueStart(@CookieValue("gameId") int gameId,
			int clueCoins, int clueRound, int clueType){
		Map<String, Object> map = new HashMap<String, Object>();
		//更新game状态
		Game game = hostService.getGame(gameId);
		game.setClueRound(clueRound);
		game.setClueType(clueType);
		game.setGameStatus(4);
		hostService.updateGame(game);
		//分发线索币
		hostService.sendOutClueCoins(gameId, clueCoins);
		
		map.put("success", true);
		map.put("message", "搜证开始！");
		return map;
	}
	
	@PostMapping("/voteStart")
	public Map<String, Object> voteStart(@CookieValue("gameId") int gameId, int voteRound){
		Map<String, Object> map = new HashMap<String, Object>();
		//更新game状态
		Game game = hostService.getGame(gameId);
		game.setVoteRound(voteRound);
		game.setGameStatus(5);
		hostService.updateGame(game);
		//初始化vote状态
		hostService.initVote(gameId, voteRound);
		
		map.put("success", true);
		map.put("message", "投票开始！");
		return map;
	}
	
	@PostMapping("/end")
	public Map<String, Object> end(@CookieValue("gameId") int gameId){
		Map<String, Object> map = new HashMap<String, Object>();
		//更新game状态
		Game game = hostService.getGame(gameId);
		game.setGameStatus(6);
		hostService.updateGame(game);
		
		map.put("success", true);
		map.put("message", "真相发放！");
		return map;
	}
	
	@PostMapping("/close")
	public Map<String, Object> close(@CookieValue("gameId") int gameId,
			@CookieValue("userId") int userId, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		//更新game状态
		Game game = hostService.getGame(gameId);
		game.setGameStatus(0);
		hostService.updateGame(game);
		//更新玩家状态
		hostService.closeGame(gameId, userId);
		//更新组织者cookies
		Cookie cookie = new Cookie("userStatus", String.valueOf(0));
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		map.put("success", true);
		map.put("message", "游戏结束！");
		return map;
	}
	
	@PostMapping("/getClues")
	public List<Clue> getClues(@CookieValue("gameId") int gameId){
		return hostService.getClues(gameId);
	}
	
	@PostMapping("/getPositions")
	public List<Position> getPositions(@CookieValue("gameId") int gameId){
		return hostService.getPositions(gameId);
	}
	
	@PostMapping("/getGameRoles")
	public List<GameRole> getGameRoles(@CookieValue("gameId") int gameId){
		return hostService.getGameRoles(gameId);
	}
	
	@PostMapping("/sendOut")
	public Map<String, Object> sendOut(@CookieValue("gameId") int gameId, int userId,
			int clueId, int positionId){
		Map<String, Object> map = new HashMap<String, Object>();
		if(userId != 0) {
			hostService.sendOut(gameId, userId, clueId, positionId);
		}
		else {
			hostService.sendOutAll(gameId, clueId, positionId);
		}
		
		map.put("success", true);
		map.put("message", "线索分发成功！");
		return map;
	}
}
