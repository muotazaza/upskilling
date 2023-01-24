package mb;

import java.util.List;

import javax.annotation.PostConstruct;
//import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Program;
import bean.School;
import dao.ProgramDAO;
import dao.SchoolDAO;
import util.message;

@ManagedBean(name = "mbaddpro")
public class mbaddprogram {
	private Program program;
	private List<School> schoolTable;
	private ProgramDAO programDAO;
	private SchoolDAO dao;

	@PostConstruct
	public void inti() {
		//add program have school id as fk 
		programDAO = new ProgramDAO();
		dao = new SchoolDAO();
		program = new Program();
		program.setSchool(new School());
		schoolTable = dao.selectAll();
		// program = new Program();

	}

	public String save() {
		//program = new Program();
		programDAO = new ProgramDAO();
		programDAO.insert(program);
		message.addMessage("INFO", "Adding program", "program adding succefully");
		program = new Program();
		program.setSchool(new School());

		return null;
	}

	public Program getProgram() {
		if (program == null) {
			program = new Program();
			program.setSchool(new School());
		}
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

}
