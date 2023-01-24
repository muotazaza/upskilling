package mb;

import javax.faces.bean.ManagedBean;

import bean.university;
import dao.universityDAO;
import util.message;

@ManagedBean(name = "mbadduni")
public class mbadduniversity {
	private university university;

	public String save() {
		universityDAO universityDAO = new universityDAO();
		universityDAO.insert(university);
		message.addMessage("INFO", "Adding university", "university adding succefully ");
		university = new university();
		return null;
	}

	public university getUniversity() {
		if (university == null) {
			university = new university();

		}
		return university;
	}

	public void setUniversity(university university) {
		this.university = university;
	}

}
