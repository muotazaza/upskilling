package mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import bean.Student;
import bean.Student_Training_course;
import bean.TrainingCourse;
//import dao.SchoolDAO;
import dao.StudentDAO;
import dao.Student_Training_courseDAO;
import dao.trainingcourseDAO;
import util.message;

@ManagedBean(name = "mbaddstc")
public class mbaddStudent_Training_course {
	private Student_Training_course student_Training_course;
	private List<Student> studentTable;
	private List<TrainingCourse> traingcourseTable;
	private Student_Training_courseDAO student_Training_courseDAO;
	private StudentDAO dao;
	private trainingcourseDAO Cdao;

	@PostConstruct
	public void init() {

		student_Training_courseDAO = new Student_Training_courseDAO();
		student_Training_course = new Student_Training_course();

		dao = new StudentDAO();
		student_Training_course.setStudent(new Student());
		studentTable = dao.selectAll();

		Cdao = new trainingcourseDAO();
		student_Training_course.setTrainingCourse(new TrainingCourse());
		traingcourseTable = Cdao.selectAll();

		//student_Training_course = new Student_Training_course();
		//student_Training_course.setStudent(new Student());
		//student_Training_course.setTrainingCourse(new TrainingCourse());
		
	}

	public String save() {

		student_Training_courseDAO = new Student_Training_courseDAO();
		student_Training_courseDAO.insert(student_Training_course);
		message.addMessage("INFO", "Adding Student training course", "student training course adding  succefully");
		student_Training_course = new Student_Training_course();
		student_Training_course.setStudent(new Student());
		student_Training_course.setTrainingCourse(new TrainingCourse());
		
		return null;
	}

	public Student_Training_course getStudent_Training_course() {
		if (student_Training_course == null) {
			student_Training_course = new Student_Training_course();
			student_Training_course.setStudent(new Student());
			student_Training_course.setTrainingCourse(new TrainingCourse());

		}

		return student_Training_course;
	}

	public void setStudent_Training_course(Student_Training_course student_Training_course) {
		this.student_Training_course = student_Training_course;
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

	public StudentDAO getDao() {
		return dao;
	}

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	public trainingcourseDAO getCdao() {
		return Cdao;
	}

	public void setCdao(trainingcourseDAO cdao) {
		Cdao = cdao;
	}

	public Student_Training_courseDAO getStudent_Training_courseDAO() {
		return student_Training_courseDAO;
	}

	public void setStudent_Training_courseDAO(Student_Training_courseDAO student_Training_courseDAO) {
		this.student_Training_courseDAO = student_Training_courseDAO;
	}

	

}
