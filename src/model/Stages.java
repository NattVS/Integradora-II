package model;

public class Stages {
    private String stageName;
    private boolean stageStatus;

    public Stages(String stageName, boolean stageStatus) {
        this.stageName = stageName;
        this.stageStatus = stageStatus;
    }
    
    public void setActive(boolean stageStatus) {
        this.stageStatus = stageStatus;
    }

    public String getStageName() {
        return stageName;
    }

    public boolean getStageStatus() {
        return stageStatus;
    }
}

