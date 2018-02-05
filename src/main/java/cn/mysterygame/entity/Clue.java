package cn.mysterygame.entity;

public class Clue {
	private int clueId;
	private int playId;
	private String cluePosition;
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
    
    public String getCluePosition() {
        return cluePosition;
    }

    public void setCluePosition(String clue_position) {
        this.cluePosition = clue_position;
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
