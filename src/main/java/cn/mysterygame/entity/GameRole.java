package cn.mysterygame.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameRole {
	private Integer gameRoleId;
	private Integer gameId;
	private Integer scriptId;
	private Integer userId;
	private Integer clueCoins;
    
    public Integer getGameRoleId() {
        return gameRoleId;
    }

    public void setGameRoleId(Integer gameRoleId) {
        this.gameRoleId = gameRoleId;
    }
	
	public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    
    public Integer getScriptId() {
        return scriptId;
    }

    public void setScriptId(Integer scriptId) {
        this.scriptId = scriptId;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getClueCoins() {
        return clueCoins;
    }

    public void setClueCoins(Integer clueCoins) {
        this.clueCoins = clueCoins;
    }
}
