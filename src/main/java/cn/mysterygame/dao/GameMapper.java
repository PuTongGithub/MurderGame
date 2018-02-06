package cn.mysterygame.dao;

import cn.mysterygame.entity.Game;

public interface GameMapper {
	public void insertSelective(Game game);
	
	public Integer selectGameStatusById(int gameId);
	
	public Integer selectGameId(Game game);
}
