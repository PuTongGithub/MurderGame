package cn.mysterygame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.ClueMapper;
import cn.mysterygame.dao.GameClueMapper;
import cn.mysterygame.dao.GameMapper;
import cn.mysterygame.dao.GameRoleMapper;
import cn.mysterygame.dao.PlayMapper;
import cn.mysterygame.dao.ScriptMapper;
import cn.mysterygame.dao.UserMapper;
import cn.mysterygame.entity.Clue;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameClue;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.Script;
import cn.mysterygame.entity.User;

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
	@Autowired
	UserMapper userDao;
	@Autowired
	ClueMapper clueDao;
	@Autowired
	GameClueMapper gameClueDao;
	
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
			
			//已知线索分发
			Script script = scriptDao.selectById(scriptId);
			String[] positionsStrings=script.getKnownCluePosition().split("/");
			for (String positionString : positionsStrings) {
				int positionId = Integer.valueOf(positionString);
				List<Clue> clues = clueDao.selectByPositionId(positionId);
				for (Clue clue : clues) {
					GameClue gameClue = new GameClue();
					gameClue.setClueId(clue.getClueId());
					gameClue.setGameId(gameId);
					gameClue.setPositionId(positionId);
					gameClue.setUserId(userId);
					gameClueDao.insertSelective(gameClue);
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clueSendOut(int gameId, int userId, int scriptId) {
		//to do
	}
	
	public void userStatusChange(int userId, int gameId) {
		User user = userDao.selectByUserId(userId);
		user.setUserStatus(1);
		user.setGameId(gameId);
		userDao.updateByUserId(user);
	}
}
