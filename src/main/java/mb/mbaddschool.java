package mb;

import javax.faces.bean.ManagedBean;

import bean.School;
import dao.SchoolDAO;
import util.message;

@ManagedBean(name = "mbAddsch")
public class mbaddschool {
	private School school;

	public String save() {
		SchoolDAO schoolDAO = new SchoolDAO();
		schoolDAO.insert(school);
		message.addMessage("INFo", "Adding school", "achool add succefully ");
		school =new School();
		return null;
	}

	public School getSchool() {
		if (school == null) {
			school = new School();
		}
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
