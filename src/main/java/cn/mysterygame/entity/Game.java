package cn.mysterygame.entity;

import java.util.Date;

public class Game {
	private Integer gameId;
	private Integer playId;
	private Integer hostUserId;
	private Integer gameStatus;
	private Integer voteRound;
	private Integer clueRound;
	private Integer clueType;
	private Date openTime;
	
	public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    
    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }
    
    public Integer getHostUserId() {
        return hostUserId;
    }

    public void setHostUserId(Integer hostUserId) {
        this.hostUserId = hostUserId;
    }
    
    public Integer getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Integer gameStatus) {
        this.gameStatus = gameStatus;
    }
    
    public Integer getVoteRound() {
        return voteRound;
    }

    public void setVoteRound(Integer voteRound) {
        this.voteRound = voteRound;
    }
    
    public Integer getClueRound() {
        return clueRound;
    }

    public void setClueRound(Integer clueRound) {
        this.clueRound = clueRound;
    }
    
    public Integer getClueType() {
        return clueType;
    }

    public void setClueType(Integer clueType) {
        this.clueType = clueType;
    }
    
    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }
}
