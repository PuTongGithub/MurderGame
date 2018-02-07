package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.Clue;

public interface ClueMapper {
	public void insertSelective(Clue clue);
	
	public List<Clue> selectByPlayId(int playId);
	
	public Clue selectByClueId(int clueId);
}
