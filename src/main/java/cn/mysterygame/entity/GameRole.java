package cn.mysterygame.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameRole {
	private int gameRoleId;
	private int gameId;
	private int scriptId;
	private int userId;
	private int clueCoins;
    
    public int getGameRoleId() {
        return gameRoleId;
    }

    public void setGameRoleId(int gameRoleId) {
        this.gameRoleId = gameRoleId;
    }
	
	public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public int getScriptId() {
        return scriptId;
    }

    public void setScriptId(int scriptId) {
        this.scriptId = scriptId;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getClueCoins() {
        return clueCoins;
    }

    public void setClueCoins(int clueCoins) {
        this.clueCoins = clueCoins;
    }
}
