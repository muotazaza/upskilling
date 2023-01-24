package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Database.Database;
//import bean.Student;
import bean.Student_Training_course;
//import bean.TrainingCourse;

public class Student_Training_courseDAO {
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Student_Training_course> student_Training_courseTable;
	private int row;

	public List<Student_Training_course> selectAll() {
		student_Training_courseTable = new ArrayList<Student_Training_course>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select STUDENT_ID,COURSE_ID,PRIORITY from student_Training_course order by student_id ");
			rs = ps.executeQuery();
			while (rs.next()) {
				Student_Training_course student_Training_course = new Student_Training_course();
				//student_Training_course.setPriority(rs.getInt("priority"));

				StudentDAO studentDAO = new StudentDAO();
				student_Training_course.setStudent(studentDAO.selectbyID(rs.getInt("STUDENT_ID")));
				//Student student = studentDAO.selectbyID(rs.getInt("student_id"));
				//student_Training_course.setStudent(student);

				trainingcourseDAO trainingcourseDAO1 = new trainingcourseDAO();
				student_Training_course.setTrainingCourse(trainingcourseDAO1.selectbyID(rs.getInt(2)));
				student_Training_course.setPriority(rs.getInt("priority"));

			
				student_Training_courseTable.add(student_Training_course);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return student_Training_courseTable;

	}

	public int insert(Student_Training_course student_Training_course) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("insert into Student_Training_course (STUDENT_ID,COURSE_ID, PRIORITY) values(?, ?, ?)");
			int counter = 1;
			
		
			ps.setInt(counter++ ,student_Training_course.getStudent().getSTUDENT_ID() );
			
			ps.setInt(counter++, student_Training_course.getTrainingCourse().getCOURSE_ID());
			
			ps.setInt(counter++, student_Training_course.getPriority());
			
			
			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;
	}

	public int update(Student_Training_course student_Training_course) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update Student_Training_course set STUDENT_ID = ?, COURSE_ID = ?, PRIORITY = ?  where student_id = ?");

			int counter = 1;
			ps.setInt(counter++, student_Training_course.getStudent().getSTUDENT_ID());
			ps.setInt(counter++, student_Training_course.getTrainingCourse().getCOURSE_ID());
			ps.setInt(counter++, student_Training_course.getPriority());

			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}

	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete Student_Training_course where STUDENT_ID  = ?");
			ps.setInt(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;
	}

}
