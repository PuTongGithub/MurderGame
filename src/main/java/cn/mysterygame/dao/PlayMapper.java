package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.Play;

public interface PlayMapper {
	public void insertSelective(Play play);
	
	public List<Play> selectAll();
	
	public Play selectByPlayId(int playId);
}
