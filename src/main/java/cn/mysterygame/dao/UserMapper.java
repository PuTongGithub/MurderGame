package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.User;

public interface UserMapper {
	public List<User> selectByUsername(String username);
	
	public void insertSelective(User user);
}
