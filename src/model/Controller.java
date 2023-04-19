package model;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Controller {

	private KnowledgeUnit[] units;
    private Project[] projects;

	public Controller() {
        projects = new Project[10];
		units = new KnowledgeUnit[25];
	}
	
    public boolean RegisterProject(String name, String clientName, String managerName, String managerNumber, double budget, int day, int month, int year, int day2, int month2, int year2) {

		Calendar initialDate = new GregorianCalendar(year,month,day); 
		Calendar finalDate = new GregorianCalendar(year2,month2,day2);

		Project newProject = new Project(name , clientName, managerName, managerNumber, initialDate, finalDate, budget);
		for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = newProject;
                return true;
            }

        }
		return false;
	}

    public String getAllProjects() {
        String msg = "";
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                msg += "\n" + (i+1) +". " + "Name: " + projects[i].getName();
            }
        }
        return msg;
    }

    public int closeStage(int proyectChoice){
        int indicator = 1;
        return indicator;
    }

	public boolean registerKnowledgeUnit(String id, String description, String type, String learnedLessons) {
		KnowledgeUnit capsUnit = new KnowledgeUnit(id,description, type, learnedLessons);
		boolean indicador =false;
		for(int i=0;i<units.length;i++){
			if(units[i]==null && !indicador){
				units[i]= capsUnit;
				indicador =true;
			}	
		}	
		return indicador;
	}

	public String showRegisteredUnits() {
        String msg = "";
        for (int i = 0; i < units.length; i++) {
            if (units[i] != null) {
                msg += units[i].getId() + "\n";
            }
        }
        return msg;
    }

    public void approveKnowledgeUnit(String id, String newStatus) {
        for (int i= 0; i<units.length; i++){
            if (units[i] != null){
                if(units[i].getId().equals(id)){
                    units[i].setStatus(newStatus);
                }
            }   
        }
    }

    public String getAllKnowledgeUnits() {
        String msg = "";
        for (int i = 0; i < units.length; i++) {
            if (units[i] != null) {
                msg += units[i].toString() + "\n";
            }
        }
        return msg;
    }

}
