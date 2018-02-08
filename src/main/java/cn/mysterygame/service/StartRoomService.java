package cn.mysterygame.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.GameMapper;
import cn.mysterygame.dao.GameRoleMapper;
import cn.mysterygame.dao.PlayMapper;
import cn.mysterygame.dao.ScriptMapper;
import cn.mysterygame.dao.UserMapper;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.Script;
import cn.mysterygame.entity.User;

@Service
public class StartRoomService {

	@Autowired
	private UserMapper userDao;
	@Autowired
	private PlayMapper playDao;
	@Autowired
	private ScriptMapper scriptDao;
	@Autowired
	private GameMapper gameDao;
	@Autowired
	private GameRoleMapper gameRoleDao;
	
	public List<Play> getPlays(){
		return playDao.selectAll();
	}
	
	public int start(int userId, int playId) {
		//Game初始化
		Game game = new Game();
		game.setPlayId(playId);
		game.setHostUserId(userId);
		game.setGameStatus(1);
		//以固定格式获取当前时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(new Date()); 
		Timestamp nowTimestamp = Timestamp.valueOf(time); 
		game.setOpenTime(nowTimestamp);
		gameDao.insertSelective(game);
		//获取gameId，变更game状态
		Integer gameId = gameDao.selectGameId(game);
		game.setGameId(gameId);
		game.setGameStatus(2);
		gameDao.updateByPrimaryKeySelective(game);
		
		//GameRole初始化
		List<Script> scripts = scriptDao.selectByPlayId(playId);
		for (Script script : scripts) {
			GameRole role = new GameRole();
			role.setGameId(gameId);
			role.setScriptId(script.getScriptId());
			gameRoleDao.insertSelective(role);
		}
		
		//GameClue初始化,在想到更好的搜证方法之前，先采用手工分发
		/*List<Clue> clues = clueDao.selectByPlayId(playId);
		for (Clue clue : clues) {
			GameClue gameClue = new GameClue();
			gameClue.setGameId(gameId);
			gameClue.setClueId(clue.getClueId());
			gameClue.setPositionId(clue.getPositionId());
			gameClueDao.insertSelective(gameClue);
		}*/
		
		return gameId;
	}
	
	public void updateUserStatus(int userId, int userStatus, int gameId) {
		User user = new User();
		user.setUserId(userId);
		user.setUserStatus(userStatus);
		user.setGameId(gameId);
		userDao.updateByUserId(user);
	}
}
