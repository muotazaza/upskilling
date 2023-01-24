package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Database.Database;
//import bean.Student;
import bean.Student_result;
//import bean.TrainingCourse;


public class Student_ResultDAO {
	private Database db; 
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Student_result>student_resultTable;
	private int row; 
	
	public List<Student_result>selectAll(){
		student_resultTable=new ArrayList<Student_result>();
		try {
			db=new Database(); 
			connection=db.getConnection();
			ps=connection.prepareStatement("select student_id,course_id,ENGLISH_MARK,INTERVIEW_MARK,ACCEPTED_FLAG,notes  from Student_result order by student_id,course_id");
			rs=ps.executeQuery();
			while (rs.next()) {
				Student_result student_result=new Student_result();
				
				StudentDAO studentDAO=new StudentDAO(); 
				student_result.setStudent(studentDAO.selectbyID(rs.getInt("STUDENT_ID")));
								
				trainingcourseDAO trainingcourseDAO=new trainingcourseDAO(); 
				student_result.setTrainingCourse(trainingcourseDAO.selectbyID(rs.getInt(2)));

				
				student_result.setEnglish_mark(rs.getInt("ENGLISH_MARK"));
				student_result.setInterview_mark(rs.getInt("INTERVIEW_MARK"));
				student_result.setACCEPTRD_FLAG(rs.getInt("ACCEPTED_FLAG"));
				student_result.setnotes(rs.getString("NOTES"));
		
				student_resultTable.add(student_result);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return student_resultTable;
		
	}
	public int insert(Student_result student_result) {
		try {
			db=new  Database(); 
			connection=db.getConnection(); 
			ps=connection.prepareStatement("insert into Student_result (STUDENT_ID,COURSE_ID, ENGLISH_MARK ,INTERVIEW_MARK , ACCEPTED_FLAG ,NOTES)values(? ,?, ? ,? ,? ,?)");
			int counter=1;
			ps.setInt(counter ++, student_result.getStudent().getSTUDENT_ID());
			ps.setInt(counter ++, student_result.getTrainingCourse().getCOURSE_ID());
			ps.setInt(counter ++, student_result.getEnglish_mark());
			ps.setInt(counter ++, student_result.getInterview_mark());
			ps.setInt(counter ++, student_result.getACCEPTRD_FLAG());
			ps.setString(counter++, student_result.getnotes());
			row=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
		
	} 
	
	public int update(Student_result student_result) {
		try {
			db=new  Database(); 
			connection=db.getConnection(); 
			ps=connection.prepareStatement(" update Student_result set STUDENT_ID =?,COURSE_ID= ?, ENGLISH_MARK=? ,INTERVIEW_MARK=? , ACCEPTED_FLAG=? ,NOTES=? where student_id=??)");
			int counter=1;
			ps.setInt(counter ++, student_result.getStudent().getSTUDENT_ID());
			ps.setInt(counter ++, student_result.getTrainingCourse().getCOURSE_ID());
			ps.setInt(counter ++, student_result.getEnglish_mark());
			ps.setInt(counter ++, student_result.getInterview_mark());
			ps.setInt(counter ++, student_result.getACCEPTRD_FLAG());
			ps.setString(counter++, student_result.getnotes());
			row = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
			
		}
		return row;
		
	} public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete Student_result where student_id = ?");
			ps.setInt(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		
		return row;
	}
	
	
}
