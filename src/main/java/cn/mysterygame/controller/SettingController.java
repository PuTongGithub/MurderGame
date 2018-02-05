package cn.mysterygame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mysterygame.entity.Clue;
import cn.mysterygame.entity.Play;
import cn.mysterygame.entity.Script;
import cn.mysterygame.service.ClueService;
import cn.mysterygame.service.PlayService;
import cn.mysterygame.service.ScriptService;

@RestController
@RequestMapping("/setting")
public class SettingController {

	@Autowired
	PlayService playService;
	@Autowired
	ScriptService scriptService;
	@Autowired
	ClueService clueService;
	
	@PostMapping("/addPlay")
	public String addPlay(Play play) {
		playService.insert(play);
		return "success";
	}
	
	@PostMapping("/addScript")
	public String addScript(Script script) {
		scriptService.insert(script);
		return "success";
	}
	
	@PostMapping("/addClue")
	public String addClue(Clue clue) {
		clueService.insert(clue);
		return "success";
	}
}
