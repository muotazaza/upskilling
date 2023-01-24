package bean;

public class Program {

	private int PROGRAM_ID;
	private String PROGRAM_ANAME;
	private String PROGRAM_ENAME;
	private School school;

	

	public Program(int PROGRAM_ID, String PROGRAM_ANAME, String PROGRAM_ENAME, School school) {
		super();
		this.PROGRAM_ID = PROGRAM_ID;
		this.PROGRAM_ANAME = PROGRAM_ANAME;
		this.PROGRAM_ENAME = PROGRAM_ENAME;
		this.school = school;
	}
	public Program(int PROGRAM_ID, String PROGRAM_ANAME, String PROGRAM_ENAME) {
		super();
		this.PROGRAM_ID = PROGRAM_ID;
		this.PROGRAM_ANAME = PROGRAM_ANAME;
		this.PROGRAM_ENAME = PROGRAM_ENAME;
		
	}

	public Program() {
	
	}

	public int getPROGRAM_ID() {
		return PROGRAM_ID;
	}

	public void setPROGRAM_ID(int PROGRAM_ID) {
		this.PROGRAM_ID = PROGRAM_ID;
	}

	public String getPROGRAM_ANAME() {
		return PROGRAM_ANAME;
	}

	public void setPROGRAM_ANAME(String PROGRAM_ANAME) {
		this.PROGRAM_ANAME = PROGRAM_ANAME;
	}

	public String getPROGRAM_ENAME() {
		return PROGRAM_ENAME;
	}

	public void setPROGRAM_ENAME(String PROGRAM_ENAME) {
		this.PROGRAM_ENAME = PROGRAM_ENAME;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Program [PROGRAM_ID=" + PROGRAM_ID + ", PROGRAM_ANAME=" + PROGRAM_ANAME + ", PROGRAM_ENAME=" + PROGRAM_ENAME
				+ ", school=" + school + "]";
	}
}