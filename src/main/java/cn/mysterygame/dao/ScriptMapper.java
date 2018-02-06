package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.Script;

public interface ScriptMapper {
	public void insertSelective(Script script);
	
	public List<Script> selectByPlayId(int playId);
}
