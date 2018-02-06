package cn.mysterygame.entity;

public class Clue {
	private int clueId;
	private int playId;
	private int positionId;
	private int upperClueId;
	private String content;
	private int clueCost;
	private String picUrl;
	
	public int getClueId() {
        return clueId;
    }

    public void setClueId(int clueId) {
        this.clueId = clueId;
    }
    
    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }
    
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    
    public int getUpperClueId() {
        return upperClueId;
    }

    public void setUpperClueId(int upperClueId) {
        this.upperClueId = upperClueId;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public int getClueCost() {
        return clueCost;
    }

    public void setClueCost(int clueCost) {
        this.clueCost = clueCost;
    }
    
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
