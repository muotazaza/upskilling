package mb;

import javax.faces.bean.ManagedBean;

import bean.TrainingCourse;
//import dao.ProgramDAO;
import dao.trainingcourseDAO;
import util.message;

@ManagedBean (name ="mbaddtra")
public class mbaddtrainingcourse {
private TrainingCourse trainingCourse; 
private trainingcourseDAO trainingcourseDAO;
 public String  save() {
	 trainingcourseDAO=new trainingcourseDAO();
	trainingcourseDAO.insert(trainingCourse);
	message.addMessage("INFO", "adding trainingcourse", "trainingcourse adding succfully");
	trainingCourse =new TrainingCourse(); 
	
return null; 
}

public TrainingCourse getTrainingCourse() {
	if (trainingCourse==null) {
		trainingCourse=new TrainingCourse();
		
	}
	
	return trainingCourse;
}

public void setTrainingCourse(TrainingCourse trainingCourse) {
	this.trainingCourse = trainingCourse;
}


 
}
