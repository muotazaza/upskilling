package mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import bean.Student_Training_course;
import dao.Student_Training_courseDAO;

@ViewScoped
@ManagedBean(name = "mbstc")
public class mbstudent_Tranining_course {
	private List<Student_Training_course> Student_Training_courseTable;
	private Student_Training_course selectStudent_Training_course;
	private Student_Training_courseDAO student_Training_courseDAO;

	@PostConstruct
	public void init() {
		student_Training_courseDAO = new Student_Training_courseDAO();
		Student_Training_courseTable=student_Training_courseDAO.selectAll();
		selectStudent_Training_course = new Student_Training_course();
	

	}

	public String updateStudent_training_course() {

		student_Training_courseDAO.update(selectStudent_Training_course);
		Student_Training_courseTable = new Student_Training_courseDAO().selectAll();
		return null;
	}

	public String removeStudent_training_course() {

		student_Training_courseDAO.delete(selectStudent_Training_course.getStudent().getSTUDENT_ID());
		Student_Training_courseTable = new Student_Training_courseDAO().selectAll();
		return null;
	}

	public List<Student_Training_course> getStudent_Training_courseTable() {
		return Student_Training_courseTable;
	}

	public void setStudent_Training_courseTable(List<Student_Training_course> student_Training_courseTable) {
		Student_Training_courseTable = student_Training_courseTable;
	}

	public Student_Training_course getSelectStudent_Training_course() {
		return selectStudent_Training_course;
	}

	public void setSelectStudent_Training_course(Student_Training_course selectStudent_Training_course) {
		this.selectStudent_Training_course = selectStudent_Training_course;
	}

}
