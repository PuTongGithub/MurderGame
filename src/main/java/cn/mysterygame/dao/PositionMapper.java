package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.Position;

public interface PositionMapper {
	public void insertSelective(Position position);
	
	public List<Position> selectByPlayId(int playId);
}
