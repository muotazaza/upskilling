package bean;

public class School {

	private int school_Id;
	private String school_aname;
	private String school_ename;

	public School(String school_aname, String school_ename) {
		super();
		this.school_aname = school_aname;
		this.school_ename = school_ename;
	}

	public School(int school_Id, String school_aname, String school_ename) {
		super();
		this.school_Id = school_Id;
		this.school_aname = school_aname;
		this.school_ename = school_ename;
	}

	public School() {
		super();
	}

	public int getSchool_Id() {
		return school_Id;
	}

	public void setSchool_Id(int school_Id) {
		this.school_Id = school_Id;
	}

	public String getSchool_aname() {
		return school_aname;
	}

	public void setSchool_aname(String school_aname) {
		this.school_aname = school_aname;
	}

	public String getSchool_ename() {
		return school_ename;
	}

	public void setSchool_ename(String school_ename) {
		this.school_ename = school_ename;
	}

	@Override
	public String toString() {
		return "School [school_Id=" + school_Id + ", school_aname=" + school_aname + ", school_ename=" + school_ename
				+ "]";
	}

}
