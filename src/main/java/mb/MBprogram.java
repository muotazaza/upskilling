package mb;

//import java.awt.image.BufferedImage;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.imageio.ImageIO;

import bean.Program;
import dao.ProgramDAO;
import report.Report;

@ViewScoped
@ManagedBean(name = "mbpro")
public class MBprogram {
	private List<Program> programTable;
	private Program selectProgram;
	private ProgramDAO programDAO;

	@PostConstruct
	public void inti() {
		programDAO = new ProgramDAO();
//	System.out.println(programDAO.selectAll());
		programTable = programDAO.selectAll();
		selectProgram = new Program();
//	System.out.println(programDAO.selectAll());

	}

	public String updateprogram() {
		programDAO.update(selectProgram);
		programTable = new ProgramDAO().selectAll();

		return null;
	}

	public String removeprogram() {
		programDAO.delete(selectProgram.getPROGRAM_ID());
		programTable = new ProgramDAO().selectAll();

		return null;
	}

	public String runProgramReport() throws Exception {
		/*
		 * Map<String, Object>param=new HashMap<String, Object>(); BufferedImage
		 * image=ImageIO.read(getClass().getResourceAsStream("/image/imagesup.png"));
		 * param.put("p_school_id", 99);
		 */
		Report report = new Report();
		report.runPdf("program.jasper", null);

		return null;
	}

	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public Program getSelectProgram() {
		return selectProgram;
	}

	public void setSelectProgram(Program selectProgram) {
		this.selectProgram = selectProgram;
	}

	public ProgramDAO getProgramDAO() {
		return programDAO;
	}

	public void setProgramDAO(ProgramDAO programDAO) {
		this.programDAO = programDAO;
	}

}
