package mb;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import bean.Program;
import bean.School;
import bean.Student;
import bean.university;
import dao.ProgramDAO;
import dao.SchoolDAO;
import dao.StudentDAO;
import dao.universityDAO;
import util.message;

@ManagedBean(name = "mbaddstu")
public class mbaddstudent {
	private Student student;
	private StudentDAO studentDAO;
	private List<School> schoolTable;
	private List<university> uniTable;
	private List<Program> programTable;
	private SchoolDAO dao;
	private universityDAO unidao;
	private ProgramDAO programDAO;
	@PostConstruct
	public void inti() {
		studentDAO =new StudentDAO();
		dao = new SchoolDAO();
		student =new Student();
		student.setSchool(new School());
		schoolTable= dao.selectAll();
		///////////////////////////////////
		unidao = new universityDAO();
		student.setUniversity(new university());
		uniTable=unidao.selectAll();
		/////////////////////////////////////
		programDAO = new ProgramDAO();
		student.setProgram(new Program());
		programTable=programDAO.selectAll();
		
		
	}
	
	public String save() {
		
		studentDAO = new StudentDAO();
		studentDAO.insert(student);
		message.addMessage("INFO", "Adding Student ", "Student add succefully ");
		student = new Student();
		student.setUniversity(new university());
		student.setSchool(new School());
		student.setProgram(new Program());
	
		return null;
	}

	public Student getStudent() {
		if (student == null) {
			student=new Student(); 
			student.setUniversity(new university());
			student.setSchool(new School());
			student.setProgram(new Program());
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<university> getUniTable() {
		return uniTable;
	}

	public void setUniTable(List<university> uniTable) {
		this.uniTable = uniTable;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
