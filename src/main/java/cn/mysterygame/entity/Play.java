package cn.mysterygame.entity;

public class Play {
	private int playId;
	private String playName;
	private String playIntro;
	private int playerNumberMin;
	private int playerNumberMax;
	private int playType;
	private String hostGuide;
	private String theTruth;

	public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
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
    
    public int getPlayerNumberMin() {
        return playerNumberMin;
    }

    public void setPlayerNumberMin(int playerNumberMin) {
        this.playerNumberMin = playerNumberMin;
    }
    
    public int getPlayerNumberMax() {
        return playerNumberMax;
    }

    public void setPlayerNumberMax(int playerNumberMax) {
        this.playerNumberMax = playerNumberMax;
    }
    
    public int getPlayType() {
        return playType;
    }

    public void setPlayType(int playType) {
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
