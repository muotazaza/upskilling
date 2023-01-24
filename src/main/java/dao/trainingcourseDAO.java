package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Database;

import bean.TrainingCourse;

public class trainingcourseDAO {
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<TrainingCourse> trainingcoursesTable;
	private int row;

	public List<TrainingCourse> selectAll() {
		trainingcoursesTable = new ArrayList<TrainingCourse>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select COURSE_ID , COURSE_ANAME , COURSE_ENAME , MAX_STUDENTS , SHORT_DESC , DETAILED_DESC from training_course order by COURSE_ID");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				TrainingCourse trainingCourse = new TrainingCourse(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(6));
				
				trainingcoursesTable.add(trainingCourse);

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return trainingcoursesTable;

	}
	
	
	public TrainingCourse selectbyID(int id) {
		TrainingCourse trainingCourse=null;
		
		try {
			db=new Database();
			connection=db.getConnection();
			ps=connection.prepareStatement("select COURSE_ID , COURSE_ANAME , COURSE_ENAME , MAX_STUDENTS , SHORT_DESC , DETAILED_DESC from training_course order by  COURSE_ID");
			rs = ps.executeQuery();
			if (rs.next()) {
				trainingCourse=new TrainingCourse(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(6));
				
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
				return trainingCourse;
	} 
	

	public int insert(TrainingCourse trainingCourse) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into training_course (COURSE_ID , COURSE_ANAME , COURSE_ENAME , MAX_STUDENTS , SHORT_DESC , DETAILED_DESC) values(? , ? , ? , ? , ? , ?)");
			int counter = 1;
			ps.setInt(counter++, trainingCourse.getCOURSE_ID());
			ps.setString(counter++, trainingCourse.getCOURSE_ANAME());
			ps.setString(counter++, trainingCourse.getCOURSE_ENAME());
			ps.setInt(counter++, trainingCourse.getMAX_STUDENTS());
			ps.setString(counter++, trainingCourse.getSHORT_DESC());
			ps.setString(counter++, trainingCourse.getDETAILED_DESC());
			row=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int update(TrainingCourse trainingCourse) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					" updata training_course set  COURSE_ANAME=? ,COURSE_ENAME=? , MAX_STUDENTS=? , SHORT_DESC=? , DETAILED_DESC=? where COURSE_ID=?");
			int counter = 1;
			ps.setString(counter++, trainingCourse.getCOURSE_ANAME());
			ps.setString(counter++, trainingCourse.getCOURSE_ENAME());
			ps.setInt(counter++, trainingCourse.getMAX_STUDENTS());
			ps.setString(counter++, trainingCourse.getSHORT_DESC());
			ps.setString(counter++, trainingCourse.getDETAILED_DESC());
			ps.setInt(counter++, trainingCourse.getCOURSE_ID());
			row=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			ps = connection.prepareStatement("delete from training_course where COURSE_ID=? ");
			ps.setInt(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;

	}

}
