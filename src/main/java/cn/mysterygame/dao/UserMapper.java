package cn.mysterygame.dao;

import cn.mysterygame.entity.User;

public interface UserMapper {
	public User selectByUsername(String username);
	
	public void insertSelective(User user);
	
	public void updateByUserId(User user);
}
