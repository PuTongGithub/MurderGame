package cn.mysterygame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.GameMapper;
import cn.mysterygame.dao.GameRoleMapper;
import cn.mysterygame.dao.GameVoteMapper;
import cn.mysterygame.dao.PlayMapper;
import cn.mysterygame.dao.UserMapper;
import cn.mysterygame.entity.Game;
import cn.mysterygame.entity.GameRole;
import cn.mysterygame.entity.GameVote;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.User;

@Service
public class HostService {

	@Autowired
	GameMapper gameDao;
	@Autowired
	GameRoleMapper gameRoleDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	GameVoteMapper gameVoteDao;
	@Autowired
	PlayMapper playDao;

	public Game getGame(int gameId) {
		return gameDao.selectByGameId(gameId);
	}
	
	public Play getPlay(int gameId) {
		Game game = getGame(gameId);
		return playDao.selectByPlayId(game.getPlayId());
	}

	public void updateGame(Game game) {
		gameDao.updateByPrimaryKeySelective(game);
	}
	
	public void initVote(int gameId, int voteRound) {
		List<GameRole> roles = gameRoleDao.selectByGameId(gameId);
		for (GameRole role : roles) {
			GameVote gameVote = new GameVote();
			gameVote.setGameId(gameId);
			gameVote.setUserId(role.getUserId());
			gameVote.setVoteRound(voteRound);
			gameVoteDao.insertSelective(gameVote);
		}
	}

	public void sendOutClueCoins(int gameId, int coins) {
		List<GameRole> roles = gameRoleDao.selectByGameId(gameId);
		for (GameRole role : roles) {
			role.setClueCoins(coins);
			gameRoleDao.updateByPrimaryKeySelective(role);
		}
	}

	public void closeGame(int gameId, int hostUserId) {
		User user = userDao.selectByUserId(hostUserId);
		user.setUserStatus(0);
		userDao.updateByUserId(user);
		
		List<GameRole> roles = gameRoleDao.selectByGameId(gameId);
		for (GameRole role : roles) {
			int userId = role.getUserId();
			if (userId != 0) {
				user = userDao.selectByUserId(role.getUserId());
				user.setUserStatus(0);
				userDao.updateByUserId(user);
			}
		}
	}
}
