package cn.mysterygame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.PlayMapper;
import cn.mysterygame.entity.Play;

@Service
public class PlayService {

	@Autowired
	private PlayMapper playDao;
	
	public void insert(Play play) {
		playDao.insertSelective(play);
	}
}
