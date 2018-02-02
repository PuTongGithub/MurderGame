package cn.mysterygame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.UserMapper;
import cn.mysterygame.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userDao;
	
	public List<User> selectByUsername(String username) {
		return userDao.selectByUsername(username);
	}
	
	public void insert(User user) {
		userDao.insertSelective(user);
	}
}
