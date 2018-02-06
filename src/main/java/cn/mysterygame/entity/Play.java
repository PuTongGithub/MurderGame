package cn.mysterygame.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Play {
	private Integer playId;
	private String playName;
	private String playIntro;
	private Integer playerNumberMin;
	private Integer playerNumberMax;
	private Integer playType;
	private String hostGuide;
	private String theTruth;

	public Integer getPlayId() {
        return playId;
    }

    public void setPlayId(Integer playId) {
        this.playId = playId;
    }
    
    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }
    
    public String getPlayIntro() {
        return playIntro;
    }

    public void setPlayIntro(String playIntro) {
        this.playIntro = playIntro;
    }
    
    public Integer getPlayerNumberMin() {
        return playerNumberMin;
    }

    public void setPlayerNumberMin(Integer playerNumberMin) {
        this.playerNumberMin = playerNumberMin;
    }
    
    public Integer getPlayerNumberMax() {
        return playerNumberMax;
    }

    public void setPlayerNumberMax(Integer playerNumberMax) {
        this.playerNumberMax = playerNumberMax;
    }
    
    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }
    
    public String getHostGuide() {
        return hostGuide;
    }

    public void setHostGuide(String hostGuide) {
        this.hostGuide = hostGuide;
    }
    
    public String getTheTruth() {
        return theTruth;
    }

    public void setTheTruth(String theTruth) {
        this.theTruth = theTruth;
    }
}
