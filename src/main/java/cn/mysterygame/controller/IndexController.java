package cn.mysterygame.controller;

import java.util.List;

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
import cn.mysterygame.entity.Script;
import cn.mysterygame.service.IndexService;

@RestController
@RequestMapping("/game/index")
public class IndexController {

	@Autowired
	IndexService indexService;
	
	@PostMapping("/getName")
	public String getName(int userId) {
		return indexService.getName(userId);
	}
	
	@PostMapping("/getGame")
	public Game getGame(@CookieValue("gameId") int gameId) {
		return indexService.getGame(gameId);
	}
	
	@PostMapping("/getRoles")
	public List<GameRole> getRoles(@CookieValue("gameId") int gameId){
		return indexService.getRoles(gameId);
	}
	
	@PostMapping("/getRoleName")
	public String getRoleName(int scriptId) {
		return indexService.getRoleName(scriptId);
	}
	
	@PostMapping("/getScript")
	public Script getScript(@CookieValue("gameId") int gameId, @CookieValue("userId") int userId) {
		return indexService.getScript(gameId, userId);
	}
	
	@PostMapping("/getPlay")
	public Play getPlay(@CookieValue("gameId") int gameId) {
		return indexService.getPlay(gameId);
	}
	
	@PostMapping("/getPositions")
	public List<Position> getPositions(@CookieValue("gameId") int gameId) {
		return indexService.getPositions(gameId);
	}
	
	@PostMapping("/getClues")
	public List<Clue> getClues(@CookieValue("gameId") int gameId, @CookieValue("userId") int userId){
		return indexService.getClues(gameId, userId);
	}
}
