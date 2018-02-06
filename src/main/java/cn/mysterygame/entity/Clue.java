package cn.mysterygame.entity;

public class Clue {
	private Integer clueId;
	private Integer playId;
	private Integer positionId;
	private Integer upperClueId;
	private String content;
	private Integer clueCost;
	private String picUrl;
	
	public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }
    
    public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }
    
    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
    
    public Integer getUpperClueId() {
        return upperClueId;
    }

    public void setUpperClueId(Integer upperClueId) {
        this.upperClueId = upperClueId;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public Integer getClueCost() {
        return clueCost;
    }

    public void setClueCost(Integer clueCost) {
        this.clueCost = clueCost;
    }
    
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
