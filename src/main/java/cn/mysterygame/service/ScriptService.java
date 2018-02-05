package cn.mysterygame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mysterygame.dao.ScriptMapper;
import cn.mysterygame.entity.Script;

@Service
public class ScriptService {

	@Autowired
	private ScriptMapper scriptDao;
	
	public void insert(Script script) {
		scriptDao.insertSelective(script);
	}
}
