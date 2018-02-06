package cn.mysterygame.entity;

public class GameClue {
	private int gameClueId;
	private int gameId;
	private int clueId;
	private int positionId;
	private int userId;

	public int getGameClueId() {
        return gameClueId;
    }

    public void setGameClueId(int gameClueId) {
        this.gameClueId = gameClueId;
    }
    
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public int getClueId() {
        return clueId;
    }

    public void setClueId(int clueId) {
        this.clueId = clueId;
    }
    
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
