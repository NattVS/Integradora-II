package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {
		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {
		Executable exe = new Executable();
		exe.menu();
	}

	public void menu() {
		System.out.println ("Welcome to GreenSQA!");
		int proceed = 0;
        while (proceed == 0) {
			System.out.println ("Choose which of the following do you wish to do \n1. Register a project \n2. Close a project's stage \n3. Register a knowledge capsule \n4. Aprove a knowledge capsule \n5. Consult the information of a knowledge capsule \n6. Exit the program ");
			int option = reader.nextInt() ;
			switch(option) {
			case 1:
				RegisterProject();
			break;
			case 2:
				closeProjectStage();
			break;
			case 3:
				registerKnowledgeUnit();
			break;
			case 4:
				approveKnowledgeUnit();
			break;
			case 5:
				showAllKnowledgeUnits();
			break;
			case 6:
				proceed = 1 ;
				System.out.println ("Goodbye! Have a wonderfull day ");
			break;
			default:
				System.out.println ("Choose a valid option ") ;
			break;
			}
		}
	}

	public void RegisterProject() {
		//buffer
		reader.nextLine();

		System.out.println("Enter the proyect's name");
		String name= reader.nextLine();

		System.out.println("Enter the client's name");
		String clientName= reader.nextLine();

		System.out.println("Enter the manager's name");
		String managerName = reader.nextLine();

		System.out.println("Enter the manager's phone number");
		String managerNumber = reader.nextLine();

		System.out.println("Enter the project's initialization date:");
		System.out.println("-Enter the day ");
		int day = reader.nextInt();

		System.out.println("-Enter the month ");
		int month = reader.nextInt();

		System.out.println("-Enter the year ");
		int year = reader.nextInt();

		System.out.println("Enter the project's finalization date");
		System.out.println("-Enter the day");
		int dayF = reader.nextInt();

		System.out.println("-Enter the month ");
		int monthF = reader.nextInt();

		System.out.println("-Enter the year ");
		int yearF = reader.nextInt();

		System.out.println("Enter the proyect's budget");
		double budget = reader.nextDouble();

		if (controller.RegisterProject( name,  clientName, managerName, managerNumber,  budget,  day,  month,  year,  dayF,  monthF,  yearF)) {
			System.out.println("The project was successfully registered!");
		} 
		else {
			System.out.println("Memory full, unable to register the project");
		}
	}

	public void closeProjectStage(){
		String infoProject = controller.getAllProjects();
        if (infoProject.equals("")){
            System.out.println("You have not registered any project");
        } else {
			System.out.println("This are the created projects");
			System.out.println(infoProject);
			int proyectChoice = 0;
			System.out.println("Enter the  project you wish to close a stage in");
			proyectChoice = reader.nextInt();
			if (controller.closeStage(proyectChoice - 1) == 1) {
				System.out.println("\nStage status changed succesfully");

			} else {
				System.out.println("\nThe status wasn't changed properlly");
			}
        }
	}

	public void registerKnowledgeUnit() {
		String type;
		System.out.println ("Enter the information of the new knowledge capsule") ;
        //buffer
        reader.nextLine();
        System.out.println ("Enter the id of the knowledge capsule") ;
        String id = reader.nextLine();
        System.out.println ("Enter the description of the knowledge capsule") ;
        String description = reader.nextLine();
		System.out.println ("Enter the type of capsule knowledge: \n1. Technical \n2. Experiences ") ;
		int tem=reader.nextInt();
		switch(tem){
			case 1:
			type="Technical";
			break;
			case 2:
			type="Experiences";
			break;
			default:
			System.out.println ("Choose a valid option ") ;
			type="";
			break;
		}
		//buffer 2
        reader.nextLine();
		System.out.println ("Enter the lessons learned while making the knowledge capsule ") ;
        String learnedLessons = reader.nextLine();
        if(controller.registerKnowledgeUnit(id, description, type, learnedLessons)){
            System.out.println ("Knowledge capsule successfully created") ;
        }else{
            System.out.println ("There arent any more spaces available, the knowledge capsule could not be registered") ;
        }
	}

	private void approveKnowledgeUnit() {
		//Limpieza de buffer 3
		reader.nextLine();
		String newStatus;
		System.out.println("This are the ids of the existing knowledge capsules:");
        System.out.println(controller.showRegisteredUnits());
        System.out.println("Insert the id of the capsule you want to change its approvation status");
        String id = reader.nextLine();
        System.out.println("Insert the new status: \n 1. Approved \n 2. Not Approved");
        int temp=reader.nextInt();
		switch(temp){
			case 1:
			newStatus="Approved";
			break;
			case 2:
			newStatus="Not Approved";
			break;
			default:
			System.out.println ("Choose a valid option ") ;
			newStatus="";
			break;
		}
        controller.approveKnowledgeUnit(id, newStatus);

	}

	public void showAllKnowledgeUnits() {
		String information = controller.getAllKnowledgeUnits();
        if (information.equals("")){
            System.out.println("You have not registered any knowledge unit");

        } else {
			System.out.println("This are the created knowledge capsules:");
            System.out.println(information);
        }
	}

}