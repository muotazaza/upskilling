package bean;

public class Student_Training_course {
	private Student student;
	private TrainingCourse trainingCourse ;
	private int priority;
	
	
	
	public Student_Training_course() {
		super();
	}
	public Student_Training_course( Student student,TrainingCourse trainingCourse, int priority) {
		super();
		this.student = student;
		this.trainingCourse = trainingCourse;
		this.priority = priority;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "Student_Training_course [student=" + student + ", trainingCourse=" + trainingCourse + ", priority="
				+ priority + "]";
	}



}
