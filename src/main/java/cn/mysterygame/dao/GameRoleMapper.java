package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.GameRole;

public interface GameRoleMapper {
	public List<GameRole> selectByGameId(int gameId);
	
	public GameRole selectByGameUser(int gameId, int userId);
	
	public GameRole selectByGameScript(int gameId, int scriptId);
	
	public void insertSelective(GameRole gameRole);
	
	public void updateByPrimaryKeySelective(GameRole gameRole);
}
