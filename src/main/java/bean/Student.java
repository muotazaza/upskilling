package bean;

import java.util.Date;

public class Student {

	private int STUDENT_ID;
	private String STUDENT_ANAME;
	private String STUDENT_ENAME;
	private String mobile;
	private Date birthdate;
	private int sex;
	private String email;
	private university university;
	private School school;
	private Program program;
	private int FINAL_AVERAGE;
	private int MAX_AVERAGE;
	private String rate;
	private int START_YEAR;
	private int GRADUATE_YEAR;
	private int GRADUATE_SEM;
	

	public Student( int STUDENT_ID,String STUDENT_ANAME, String STUDENT_ENAME) {
		
		this.STUDENT_ID = STUDENT_ID;
		this.STUDENT_ANAME = STUDENT_ANAME;
		this.STUDENT_ENAME = STUDENT_ENAME;
	}

	public Student(int STUDENT_ID, String STUDENT_ANAME, String STUDENT_ENAME, String mobile, Date birthdate, int sex,
			String email, bean.university university, School school, Program program, int FINAL_AVERAGE, int MAX_AVERAGE,
			String rate, int START_YEAR, int GRADUATE_YEAR, int GRADUATE_SEM) {
		super();
		this.STUDENT_ID = STUDENT_ID;
		this.STUDENT_ANAME = STUDENT_ANAME;
		this.STUDENT_ENAME = STUDENT_ENAME;
		this.mobile = mobile;
		this.birthdate = birthdate;
		this.sex = sex;
		this.email = email;
		this.university = university;
		this.school = school;
		this.program = program;
		this.FINAL_AVERAGE = FINAL_AVERAGE;
		this.MAX_AVERAGE = MAX_AVERAGE;
		this.rate = rate;
		this.START_YEAR = START_YEAR;
		this.GRADUATE_YEAR = GRADUATE_YEAR;
		this.GRADUATE_SEM = GRADUATE_SEM;
	}

	public Student(String STUDENT_ANAME, String STUDENT_ENAME, String mobile, Date birthdate, int sex, String email,
			bean.university university, School school, Program program, int FINAL_AVERAGE, int MAX_AVERAGE, String rate,
			int START_YEAR, int GRADUATE_YEAR, int GRADUATE_SEM) {
		super();
		this.STUDENT_ANAME = STUDENT_ANAME;
		this.STUDENT_ENAME = STUDENT_ENAME;
		this.mobile = mobile;
		this.birthdate = birthdate;
		this.sex = sex;
		this.email = email;
		this.university = university;
		this.school = school;
		this.program = program;
		this.FINAL_AVERAGE = FINAL_AVERAGE;
		this.MAX_AVERAGE = MAX_AVERAGE;
		this.rate = rate;
		this.START_YEAR = START_YEAR;
		this.GRADUATE_YEAR = GRADUATE_YEAR;
		this.GRADUATE_SEM = GRADUATE_SEM;
	}

	public Student() {
		super();
	}

	public int getSTUDENT_ID() {
		return STUDENT_ID;
	}

	public void setSTUDENT_ID(int STUDENT_ID) {
		this.STUDENT_ID = STUDENT_ID;
	}

	public String getSTUDENT_ANAME() {
		return STUDENT_ANAME;
	}

	public void setSTUDENT_ANAME(String STUDENT_ANAME) {
		this.STUDENT_ANAME = STUDENT_ANAME;
	}

	public String getSTUDENT_ENAME() {
		return STUDENT_ENAME;
	}

	public void setSTUDENT_ENAME(String STUDENT_ENAME) {
		this.STUDENT_ENAME = STUDENT_ENAME;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public university getUniversity() {
		return university;
	}

	public void setUniversity(university university) {
		this.university = university;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public int getFINAL_AVERAGE() {
		return FINAL_AVERAGE;
	}

	public void setFINAL_AVERAGE(int FINAL_AVERAGE) {
		this.FINAL_AVERAGE = FINAL_AVERAGE;
	}

	public int getMAX_AVERAGE() {
		return MAX_AVERAGE;
	}

	public void setMAX_AVERAGE(int MAX_AVERAGE) {
		this.MAX_AVERAGE = MAX_AVERAGE;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getSTART_YEAR() {
		return START_YEAR;
	}

	public void setSTART_YEAR(int START_YEAR) {
		this.START_YEAR = START_YEAR;
	}

	public int getGRADUATE_YEAR() {
		return GRADUATE_YEAR;
	}

	public void setGRADUATE_YEAR(int GRADUATE_YEAR) {
		this.GRADUATE_YEAR = GRADUATE_YEAR;
	}

	public int getGRADUATE_SEM() {
		return GRADUATE_SEM;
	}

	public void setGRADUATE_SEM(int GRADUATE_SEM) {
		this.GRADUATE_SEM = GRADUATE_SEM;
	}

	@Override
	public String toString() {
		return "Student [STUDENT_ID=" + STUDENT_ID + ", STUDENT_ANAME=" + STUDENT_ANAME + ", STUDENT_ENAME=" + STUDENT_ENAME
				+ ", mobile=" + mobile + ", birthdate=" + birthdate + ", sex=" + sex + ", email=" + email
				+ ", university=" + university + ", school=" + school + ", program=" + program + ", FINAL_AVERAGE="
				+ FINAL_AVERAGE + ", MAX_AVERAGE=" + MAX_AVERAGE + ", rate=" + rate + ", START_YEAR=" + START_YEAR
				+ ", GRADUATE_YEAR=" + GRADUATE_YEAR + ", GRADUATE_SEM=" + GRADUATE_SEM + "]";
	}

}
