package bean;

public class TrainingCourse {

	
	private int COURSE_ID;
	private String COURSE_ANAME;
	private String COURSE_ENAME;
	private int MAX_STUDENTS;
	private String SHORT_DESC;
	private String DETAILED_DESC;
	

	
	public TrainingCourse(int COURSE_ID, String COURSE_ANAME, String COURSE_ENAME, int MAX_STUDENTS, String SHORT_DESC,
			String DETAILED_DESC) {
		super();
		this.COURSE_ID = COURSE_ID;
		this.COURSE_ANAME = COURSE_ANAME;
		this.COURSE_ENAME = COURSE_ENAME;
		this.MAX_STUDENTS = MAX_STUDENTS;
		this.SHORT_DESC = SHORT_DESC;
		this.DETAILED_DESC = DETAILED_DESC;
	}
	public TrainingCourse() {
		
	}
	
	public TrainingCourse(int COURSE_ID , String COURSE_ENAME) {
	this.COURSE_ID=COURSE_ID;
	this.COURSE_ENAME=COURSE_ENAME;
	}
	
	public int getCOURSE_ID() {
		return COURSE_ID;
	}
	public void setCOURSE_ID(int COURSE_ID) {
		this.COURSE_ID = COURSE_ID;
	}
	public String getCOURSE_ANAME() {
		return COURSE_ANAME;
	}
	public void setCOURSE_ANAME(String COURSE_ANAME) {
		this.COURSE_ANAME = COURSE_ANAME;
	}
	public String getCOURSE_ENAME() {
		return COURSE_ENAME;
	}
	public void setCOURSE_ENAME(String COURSE_ENAME) {
		this.COURSE_ENAME = COURSE_ENAME;
	}
	public int getMAX_STUDENTS() {
		return MAX_STUDENTS;
	}
	public void setMAX_STUDENTS(int MAX_STUDENTS) {
		this.MAX_STUDENTS = MAX_STUDENTS;
	}
	public String getSHORT_DESC() {
		return SHORT_DESC;
	}
	public void setSHORT_DESC(String SHORT_DESC) {
		this.SHORT_DESC = SHORT_DESC;
	}
	public String getDETAILED_DESC() {
		return DETAILED_DESC;
	}
	public void setDETAILED_DESC(String DETAILED_DESC) {
		this.DETAILED_DESC = DETAILED_DESC;
	}
	
	@Override
	public String toString() {
		return "TrainingCourse [COURSE_ID=" + COURSE_ID + ", COURSE_ANAME=" + COURSE_ANAME + ", COURSE_ENAME=" + COURSE_ENAME
				+ ", MAX_STUDENTS=" + MAX_STUDENTS + ", SHORT_DESC=" + SHORT_DESC + ", DETAILED_DESC=" + DETAILED_DESC + "]";
	}
}
