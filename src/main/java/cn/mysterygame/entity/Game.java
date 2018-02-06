package cn.mysterygame.entity;

import java.util.Date;

public class Game {
	private int gameId;
	private int playId;
	private int hostUserId;
	private int gameStatus;
	private int voteRound;
	private int clueRound;
	private int clueType;
	private Date openTime;
	
	public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }
    
    public int getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(int hostUserId) {
        this.hostUserId = hostUserId;
    }
    
    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }
    
    public int getVoteRound() {
        return voteRound;
    }

    public void setVoteRound(int voteRound) {
        this.voteRound = voteRound;
    }
    
    public int getClueRound() {
        return clueRound;
    }

    public void setClueRound(int clueRound) {
        this.clueRound = clueRound;
    }
    
    public int getClueType() {
        return clueType;
    }

    public void setClueType(int clueType) {
        this.clueType = clueType;
    }
    
    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }
}
