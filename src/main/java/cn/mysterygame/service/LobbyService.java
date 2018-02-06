package cn.mysterygame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.GameMapper;
import cn.mysterygame.dao.GameRoleMapper;
import cn.mysterygame.entity.GameRole;

@Service
public class LobbyService {
	@Autowired
	private GameMapper gameDao;
	
	@Autowired
	private GameRoleMapper gameRoleDao;
	
	public int findRoom(int gameId) {
		Integer status = gameDao.selectGameStatusById(gameId);
		if(status == null) {
			return -1;
		}
		else {
			return status.intValue();
		}
	}
	
	public GameRole findUserInRoom(int gameId, int userId) {
		return gameRoleDao.selectByGameUser(gameId, userId);
	}
}
