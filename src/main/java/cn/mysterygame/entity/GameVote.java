package cn.mysterygame.entity;

public class GameVote {
	private Integer gameVoteId;
	private Integer gameId;
	private Integer userId;
	private Integer voteUserId;
	private Integer voteRound;

	public Integer getGameVoteId() {
        return gameVoteId;
    }

    public void setGameVoteId(Integer gameVoteId) {
        this.gameVoteId = gameVoteId;
    }
    
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getVoteUserId() {
        return voteUserId;
    }

    public void setVoteUserId(Integer voteUserId) {
        this.voteUserId = voteUserId;
    }
    
    public Integer getVoteRound() {
        return voteRound;
    }

    public void setVoteRound(Integer voteRound) {
        this.voteRound = voteRound;
    }
}
