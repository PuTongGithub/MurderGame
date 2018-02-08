package cn.mysterygame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.ClueMapper;
import cn.mysterygame.dao.GameClueMapper;
import cn.mysterygame.dao.GameMapper;
import cn.mysterygame.dao.GameRoleMapper;
import cn.mysterygame.dao.GameVoteMapper;
import cn.mysterygame.dao.PlayMapper;
import cn.mysterygame.dao.PositionMapper;
import cn.mysterygame.dao.ScriptMapper;
import cn.mysterygame.dao.UserMapper;
import cn.mysterygame.entity.Clue;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameClue;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.GameVote;
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
	@Autowired
	GameClueMapper gameClueDao;
	@Autowired
	ClueMapper clueDao;
	@Autowired
	GameVoteMapper gameVoteDao;
	
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
	
	public List<Clue> getClues(int gameId, int userId){
		List<Clue> clues = new ArrayList<>();
		List<GameClue> gameClues = gameClueDao.selectByGameUser(gameId, userId);
		for (GameClue gameClue : gameClues) {
			clues.add(clueDao.selectByClueId(gameClue.getClueId()));
		}
		return clues;
	}
	
	public boolean doVote(int gameId, int userId, int voteUserId, int voteRound) {
		if(gameVoteDao.findUser(gameId, userId, voteRound) != null) {
			return false;
		}
		GameVote gameVote = new GameVote();
		gameVote.setGameId(gameId);
		gameVote.setUserId(userId);
		gameVote.setVoteRound(voteRound);
		gameVote.setVoteUserId(voteUserId);
		gameVoteDao.insertSelective(gameVote);
		return true;
	}
	
	public List<GameVote> getVotes(int gameId){
		return gameVoteDao.selectByGameId(gameId);
	}
	
	public String getRoleNameByUserId(int gameId, int userId) {
		GameRole role = gameRoleDao.selectByGameUser(gameId, userId);
		return getRoleName(role.getScriptId());
	}
}
