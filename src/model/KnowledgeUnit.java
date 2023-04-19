package model;

public class KnowledgeUnit {

	private String id;
	private String description;
	private String type;
	private String learnedLessons;
	private String status;

	public KnowledgeUnit(String id, String description, String type, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = "Undefined";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
        String msg = "";
        msg = " ID:  " + id + "\n The description is: " + description + "\n The type is: " + type + "\n The actual status is: " + getStatus() +" \n The learned lessons are: "+ learnedLessons;
        return msg;
    }

}
