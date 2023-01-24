package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Student_result;
import dao.Student_ResultDAO;
//import dao.Student_Training_courseDAO;

@ViewScoped
@ManagedBean (name ="mbstre")
public class mbstudent_reslut {
	private List<Student_result> student_resultTable;
	private Student_result selectstudent_result ;
	private Student_ResultDAO student_ResultDAO;
	
	
	@PostConstruct
    public void init() {
      student_ResultDAO=new Student_ResultDAO();
      student_resultTable =student_ResultDAO.selectAll();
      selectstudent_result = new Student_result();
	}
	
	public String updataStudent_result() {
		student_ResultDAO.update(selectstudent_result);
		student_resultTable = new Student_ResultDAO().selectAll();
		return null;
	}
	public String removeStudent_result() {
		student_ResultDAO.delete(selectstudent_result.getStudent().getSTUDENT_ID());
		student_resultTable=new Student_ResultDAO().selectAll();
		return null;
	}

	public List<Student_result> getStudent_resultTable() {
		return student_resultTable;
	}

	public void setStudent_resultTable(List<Student_result> student_resultTable) {
		this.student_resultTable = student_resultTable;
	}

	public Student_result getSelectstudent_result() {
		return selectstudent_result;
	}

	public void setSelectstudent_result(Student_result selectstudent_result) {
		this.selectstudent_result = selectstudent_result;
	}

}
