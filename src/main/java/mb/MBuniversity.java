package mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import bean.university;
import dao.universityDAO;

@ViewScoped
@ManagedBean(name = "mbuni")
public class MBuniversity {
	private List<university> universityTable;
	private university selectUniversity;
	private universityDAO universityDAO;

	
	@PostConstruct
	public void init() {
		universityDAO = new universityDAO();
		universityTable = universityDAO.selectAll();
		selectUniversity = new university();
	}
	public void web(university uni) throws IOException {
        selectUniversity = uni;
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect( selectUniversity.getWebsite());
    }

	public String updateuniversity() {
		universityDAO.update(selectUniversity);
		universityTable = universityDAO.selectAll();
		return null;
	}

	public String removeuniversity() {
		universityDAO.delete(selectUniversity.getUniversityId());
		universityTable = universityDAO.selectAll();
		return null;
	}

	public List<university> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<university> universityTable) {
		this.universityTable = universityTable;
	}

	public university getSelectUniversity() {
		return selectUniversity;
	}

	public void setSelectUniversity(university selectUniversity) {
		this.selectUniversity = selectUniversity;
	}

	public universityDAO getUniversityDAO() {
		return universityDAO;
	}

	public void setUniversityDAO(universityDAO universityDAO) {
		this.universityDAO = universityDAO;
	}

}
