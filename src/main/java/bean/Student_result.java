package bean;

public class Student_result {
	private Student student;
	private TrainingCourse trainingCourse;
	private int english_mark ; 
	private int interview_mark ; 
	private int  ACCEPTRD_FLAG ; 
	private String notes;
	
	
	
	public Student_result(Student student, TrainingCourse trainingCourse, int english_mark, int interview_mark,
			int aCCEPTRD_FLAG, String notes) {
		super();
		this.student = student;
		this.trainingCourse = trainingCourse;
		this.english_mark = english_mark;
		this.interview_mark = interview_mark;
		ACCEPTRD_FLAG = aCCEPTRD_FLAG;
		this.notes = notes;
	}

	public Student_result() {
		super();
	}


	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public TrainingCourse getTrainingCourse() {
		return trainingCourse;
	}



	public void setTrainingCourse(TrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}



	
	public int getEnglish_mark() {
		return english_mark;
	}
	public void setEnglish_mark(int english_mark) {
		this.english_mark = english_mark;
	}
	public int getInterview_mark() {
		return interview_mark;
	}
	public void setInterview_mark(int interview_mark) {
		this.interview_mark = interview_mark;
	}
	public int getACCEPTRD_FLAG() {
		return ACCEPTRD_FLAG;
	}
	public void setACCEPTRD_FLAG(int aCCEPTRD_FLAG) {
		ACCEPTRD_FLAG = aCCEPTRD_FLAG;
	}
	public String getnotes() {
		return notes;
	}
	public void setnotes(String notes) {
		this.notes = notes;
	}



	@Override
	public String toString() {
		return "Student_result [student=" + student + ", trainingCourse=" + trainingCourse + ", english_mark="
				+ english_mark + ", interview_mark=" + interview_mark + ", ACCEPTRD_FLAG=" + ACCEPTRD_FLAG + ", notes="
				+ notes + "]";
	}
	
	
	

}
