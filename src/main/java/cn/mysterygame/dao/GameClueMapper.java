package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.GameClue;

public interface GameClueMapper {
	public void insertSelective(GameClue gameClue);

	public List<GameClue> selectByGameUser(int gameId, int userId);
}
