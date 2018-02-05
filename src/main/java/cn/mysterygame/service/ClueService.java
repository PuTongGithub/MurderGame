package cn.mysterygame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.ClueMapper;
import cn.mysterygame.entity.Clue;

@Service
public class ClueService {

	@Autowired
	private ClueMapper clueDao;
	
	public void insert(Clue clue) {
		clueDao.insertSelective(clue);
	}
}
