package cn.mysterygame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.PositionMapper;
import cn.mysterygame.entity.Position;

@Service
public class PositionService {

	@Autowired
	private PositionMapper positionDao;
	
	public void insert(Position position) {
		positionDao.insertSelective(position);
	}
}
