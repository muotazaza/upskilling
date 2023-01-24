package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.TrainingCourse;
import dao.trainingcourseDAO;

@ViewScoped
@ManagedBean(name = "mbtra")
public class mbtrainingcourse {
	private List<TrainingCourse> trainingCoursesTable;
	private TrainingCourse selectTrainingCourse;
	private trainingcourseDAO trainingcourseDAO;

	@PostConstruct
	public void inti() {
		trainingcourseDAO = new trainingcourseDAO();
		trainingCoursesTable = trainingcourseDAO.selectAll();
		selectTrainingCourse = new TrainingCourse();

	}

	public String updatetrainingcourse() {
		trainingcourseDAO.update(selectTrainingCourse);
		trainingCoursesTable =trainingcourseDAO.selectAll();
		return null;
	}

	public String removetrainingcourse() {
		trainingcourseDAO.delete(selectTrainingCourse.getCOURSE_ID());
		trainingCoursesTable = trainingcourseDAO.selectAll();
		return null;
	}

	public List<TrainingCourse> getTrainingCoursesTable() {
		return trainingCoursesTable;
	}

	public void setTrainingCoursesTable(List<TrainingCourse> trainingCoursesTable) {
		this.trainingCoursesTable = trainingCoursesTable;
	}

	public TrainingCourse getSelectTrainingCourse() {
		return selectTrainingCourse;
	}

	public void setSelectTrainingCourse(TrainingCourse selectTrainingCourse) {
		this.selectTrainingCourse = selectTrainingCourse;
	}

	public trainingcourseDAO getTrainingcourseDAO() {
		return trainingcourseDAO;
	}

	public void setTrainingcourseDAO(trainingcourseDAO trainingcourseDAO) {
		this.trainingcourseDAO = trainingcourseDAO;
	}

}
