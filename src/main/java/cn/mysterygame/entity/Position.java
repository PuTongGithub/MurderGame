package cn.mysterygame.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Position {
	private int positionId;
	private int playId;
	private String content;
	private int clueRound;
    
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    
    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public int getClueRound() {
        return clueRound;
    }

    public void setClueRoundt(int clueRound) {
        this.clueRound = clueRound;
    }
}
