package cn.mysterygame.dao;

import java.util.List;

import cn.mysterygame.entity.GameVote;

public interface GameVoteMapper {
	public void insertSelective(GameVote gameVote);
	
	public List<GameVote> selectByGameId(int gameId);
	
	public GameVote findUser(int gameId, int userId, int voteRound);
}
