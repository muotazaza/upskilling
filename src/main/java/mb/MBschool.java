package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.School;
import dao.SchoolDAO;
@ViewScoped
@ManagedBean(name="mbsch")
public class MBschool {
	private List<School>SchoolTable;
	private School selectSchool;
	private SchoolDAO schoolDAO;
	
	
	@PostConstruct
	private void inti() {
		schoolDAO=new SchoolDAO(); 
		SchoolTable=schoolDAO.selectAll(); 
		selectSchool=new School(); 

	}
	public String updateSchool() {
	schoolDAO.update(selectSchool); 
	SchoolTable =schoolDAO.selectAll();
		return null; 
	}
	public String removeSchool() {
		schoolDAO.delete(selectSchool.getSchool_Id()); 
		SchoolTable=new SchoolDAO().selectAll();
		return null; 
	}
	public List<School> getSchoolTable() {
		return SchoolTable;
	}
	public void setSchoolTable(List<School> schoolTable) {
		SchoolTable = schoolTable;
	}
	public School getSelectSchool() {
		return selectSchool;
	}
	public void setSelectSchool(School selectSchool) {
		this.selectSchool = selectSchool;
	}
	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}
	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}
	
}
