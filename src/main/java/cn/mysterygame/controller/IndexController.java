package cn.mysterygame.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mysterygame.entity.Clue;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.GameVote;
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
	
	@PostMapping("/getRoleNameByUserId")
	public String getRoleNameByUserId(@CookieValue("gameId") int gameId, int userId) {
		return indexService.getRoleNameByUserId(gameId, userId);
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
	
	@PostMapping("/doVote")
	public Map<String, Object> doVote(@CookieValue("gameId") int gameId, @CookieValue("userId") int userId,
			int voteRound, int voteUserId){
		System.out.println(voteUserId);
		Map<String, Object> map = new HashMap<String, Object>();
		if(indexService.doVote(gameId, userId, voteUserId, voteRound)) {
			map.put("success", true);
			map.put("message", "投票成功！");
		}
		else {
			map.put("success", false);
			map.put("message", "本轮票已投，投票失败！");
		}
		return map;
	}
	
	@PostMapping("/getVotes")
	public List<GameVote> getVotes(@CookieValue("gameId") int gameId) {
		return indexService.getVotes(gameId);
	}
}
