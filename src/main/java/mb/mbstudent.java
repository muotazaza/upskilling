package mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import bean.Student;
import dao.StudentDAO;
@ViewScoped
@ManagedBean (name ="mbstu")
public class mbstudent {

	private List<Student> studentTablbe;
	private Student selectStudent; 
	private StudentDAO studentDAO; 
	
	@PostConstruct
	public void inti() {
		studentDAO=new StudentDAO(); 
		studentTablbe=studentDAO.selectAll(); 
		selectStudent=new Student();
		
	}
	public String update() {
		studentDAO.update(selectStudent); 
		studentTablbe= studentDAO.selectAll();
		return null; 
	}

	public String remove() {
		studentDAO.delete(selectStudent.getSTUDENT_ID()); 
		studentTablbe=studentDAO.selectAll();
		return null; 
	}

	public List<Student> getStudentTablbe() {
		return studentTablbe;
	}

	public void setStudentTablbe(List<Student> studentTablbe) {
		this.studentTablbe = studentTablbe;
	}

	public Student getSelectStudent() {
		return selectStudent;
	}

	public void setSelectStudent(Student selectStudent) {
		this.selectStudent = selectStudent;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
}
