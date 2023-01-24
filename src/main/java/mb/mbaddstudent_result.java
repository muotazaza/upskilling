package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Student;
import bean.Student_result;
import bean.TrainingCourse;
//import dao.SchoolDAO;
import dao.StudentDAO;
import dao.Student_ResultDAO;
import dao.trainingcourseDAO;
import util.message;

@ManagedBean(name = "mbaddstre")
public class mbaddstudent_result {
	private Student_result student_result;
	private List<Student> studentTable;
	private List<TrainingCourse> traingcourseTable;
    private Student_ResultDAO student_ResultDAO; 
    private StudentDAO dao ; 
    private trainingcourseDAO tdao; 
    
	@PostConstruct
	private void init() {
		
		student_ResultDAO = new Student_ResultDAO(); 
		student_result = new Student_result(); 

		dao = new StudentDAO(); 
		student_result.setStudent(new Student());
		studentTable = dao.selectAll();

		tdao = new trainingcourseDAO();
		student_result.setTrainingCourse(new TrainingCourse());
		traingcourseTable = tdao.selectAll();

	}

	public String save() {
		student_ResultDAO = new Student_ResultDAO(); 
		student_ResultDAO.insert(student_result);
		message.addMessage("INFO", "adding student result ", "student result adding succefully");
		student_result = new Student_result(); 
		student_result.setStudent(new Student());
		student_result.setTrainingCourse(new TrainingCourse());
		return null;

	}

	public Student_result getStudent_result() {

		if (student_result == null) {
			student_result = new Student_result();

		}

		return student_result;
	}

	public void setStudent_result(Student_result student_result) {
		this.student_result = student_result;
	}

	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public List<TrainingCourse> getTraingcourseTable() {
		return traingcourseTable;
	}

	public void setTraingcourseTable(List<TrainingCourse> traingcourseTable) {
		this.traingcourseTable = traingcourseTable;
	}

}
