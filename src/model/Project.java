package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Project{
	
	private String name;
	private String clientName;
    private String managerName;
    private String managerNumber;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
    private Stages[] stages;
    private boolean projectActive = true;

	private DateFormat formatter;

	public Project(String name, String clientName, String managerName, String managerNumber, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");
		this.name = name;	
		this.clientName = clientName;
        this.managerName = managerName;
        this.managerNumber = managerNumber;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
        this.stages = new Stages[]  {new Stages("BEGINNING",true),
                                     new Stages("ANALYSIS",false), 
                                     new Stages("DESIGN",false), 
                                     new Stages("EXECUTION",false), 
                                     new Stages("CLOSING & FOLLOW-UP",false), 
                                     new Stages("CONTROL",false)};
	}

	public String getName(){
		return name;
	}
	
	public String getClientName(){
		return clientName;
	}
    public String getManagerName(){
		return managerName;
	}
	
	public String getManagerNumber(){
		return managerNumber;
	}
	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;

	}

    public String[] getStageName() {
        String[] stageNames = {stages[0].getStageName(), stages[1].getStageName(), stages[2].getStageName(), stages[3].getStageName(), stages[4].getStageName(),stages[5].getStageName()};
        return stageNames;
    }

    public String getActiveStage() {
        boolean stageStatus = false;
        String stageName = "";

        for(int i = 0; i < stages.length && !stageStatus ; i++) {
            if(stages[i].getStageStatus()) {
                stageName = stages[i].getStageName();
                stageStatus = true;
            }
        }
        return stageName;
    }

    public boolean getProjectStatus() {
        return projectActive;
    }

    public void getProjectStatus(boolean projectActive) {
        this.projectActive = projectActive;
    }

    public void setProjectStatus (boolean projectActive) {
        this.projectActive = projectActive;
    }

    public boolean closeStage() {
        boolean stillActive = false;
        for(int i = 0; i < stages.length && !stillActive ; i++) {
            //  if there is a stage active and if is not the last one
            if(getActiveStage().equals(stages[i].getStageName()) && i < stages.length-1) {
                stages[i].setActive(false); //End Stage
                stages[i+1].setActive(true); //Start next Stage
                stillActive = true; //Stop iteration
            // else if the stage is the last one and the project is active
            } else if(i == stages.length-1 && getProjectStatus()) {
                stages[i].setActive(false); // end the last stage
                setProjectStatus(false); //Project is inactivated
            }
        }
        return stillActive;
    }

	public String getProjectInfo() throws ParseException{
		return "\nName: " + name + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
	}
}