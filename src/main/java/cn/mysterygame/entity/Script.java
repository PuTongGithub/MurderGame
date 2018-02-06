package cn.mysterygame.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Script {
	private Integer scriptId;
	private Integer playId;
	private String roleName;
	private String roleIntro;
	private String content;
	private String knownCluePosition;
	private String goal;
	
	public Integer getScriptId() {
        return scriptId;
    }

    public void setScriptId(Integer scriptId) {
        this.scriptId = scriptId;
    }
	
	public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }
    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getRoleIntro() {
        return roleIntro;
    }

    public void setRoleIntro(String roleIntro) {
        this.roleIntro = roleIntro;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getKnownCluePosition() {
        return knownCluePosition;
    }

    public void setKnownCluePosition(String knownCluePosition) {
        this.knownCluePosition = knownCluePosition;
    }
    
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
