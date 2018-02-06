package cn.mysterygame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.GameMapper;
import cn.mysterygame.dao.GameRoleMapper;
import cn.mysterygame.dao.PlayMapper;
import cn.mysterygame.dao.PositionMapper;
import cn.mysterygame.dao.ScriptMapper;
import cn.mysterygame.dao.UserMapper;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.Position;
import cn.mysterygame.entity.Script;

@Service
public class IndexService {

	@Autowired
	UserMapper userDao;
	@Autowired
	ScriptMapper scriptDao;
	@Autowired
	GameMapper gameDao;
	@Autowired
	GameRoleMapper gameRoleDao;
	@Autowired
	PlayMapper playDao;
	@Autowired
	PositionMapper positionDao;
	
	public String getName(int userId) {
		return userDao.selectNameById(userId);
	}
	
	public Game getGame(int gameId) {
		return gameDao.selectByGameId(gameId);
	}
	
	public List<GameRole> getRoles(int gameId){
		return gameRoleDao.selectByGameId(gameId);
	}
	
	public String getRoleName(int scriptId) {
		return scriptDao.selectNameById(scriptId);
	}
	
	public Script getScript(int gameId, int userId) {
		GameRole gameRole = gameRoleDao.selectByGameUser(gameId, userId);
		return scriptDao.selectById(gameRole.getScriptId());
	}
	
	public Play getPlay(int gameId) {
		Game game = gameDao.selectByGameId(gameId);
		return playDao.selectByPlayId(game.getPlayId());
	}
	
	public List<Position> getPositions(int gameId){
		Game game = gameDao.selectByGameId(gameId);
		return positionDao.selectByPlayId(game.getPlayId());
	}
}
