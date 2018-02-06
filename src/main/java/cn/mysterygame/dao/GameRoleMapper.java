package cn.mysterygame.dao;

import cn.mysterygame.entity.GameRole;

public interface GameRoleMapper {
	public GameRole selectByGameUser(int gameId, int userId);
	
	public void insertSelective(GameRole gameRole);
}
