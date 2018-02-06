package cn.mysterygame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.GameMapper;
import cn.mysterygame.dao.GameRoleMapper;
import cn.mysterygame.dao.PlayMapper;
import cn.mysterygame.dao.ScriptMapper;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.Script;

@Service
public class RoleService {
	@Autowired
	PlayMapper playDao;
	@Autowired
	GameMapper gameDao;
	@Autowired
	ScriptMapper scriptDao;
	@Autowired
	GameRoleMapper gameRoleDao;
	
	public Play getPlay(int gameId) {
		Game game = gameDao.selectByGameId(gameId);
		return playDao.selectByPlayId(game.getPlayId());
	}
	
	public List<Script> getRoles(int gameId) {
		Game game = gameDao.selectByGameId(gameId);
		return scriptDao.selectByPlayId(game.getPlayId());
	}
	
	public List<GameRole> getStatus(int gameId){
		return gameRoleDao.selectByGameId(gameId);
	}
	
	public boolean roleConfirm(int gameId, int userId, int scriptId) {
		//to fix:并发风险
		GameRole role = gameRoleDao.selectByGameScript(gameId, scriptId);
		if(role.getUserId()==0) {
			role.setUserId(userId);
			gameRoleDao.updateByPrimaryKeySelective(role);
			//to do:人满验证
			return true;
		}
		else {
			return false;
		}
	}
}
