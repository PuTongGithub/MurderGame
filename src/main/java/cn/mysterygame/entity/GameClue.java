package cn.mysterygame.entity;

public class GameClue {
	private Integer gameClueId;
	private Integer gameId;
	private Integer clueId;
	private Integer positionId;
	private Integer userId;

	public Integer getGameClueId() {
        return gameClueId;
    }

    public void setGameClueId(Integer gameClueId) {
        this.gameClueId = gameClueId;
    }
    
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    
    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }
    
    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
