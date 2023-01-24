package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.sql.Date;
import Database.Database;
//import bean.Program;
//import bean.School;
import bean.Student;
//import bean.university;

public class StudentDAO {
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Student> studentTable;
	private int row;

	public List<Student> selectAll() {
		studentTable=new ArrayList<Student>();
		try {
			db = new Database();
			//studentTable = new ArrayList<Student>();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select STUDENT_ID ,STUDENT_ANAME , STUDENT_ENAME , mobile , birthdate , sex , email , UNIVERSITY_ID , school_Id , program_id , FINAL_AVERAGE , MAX_AVERAGE , rate , START_YEAR , GRADUATE_YEAR , GRADUATE_SEM from student order by STUDENT_ID ");
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setSTUDENT_ID(rs.getInt("STUDENT_ID"));
				student.setSTUDENT_ANAME(rs.getString("STUDENT_ANAME"));
				student.setSTUDENT_ENAME(rs.getString("STUDENT_ENAME"));
				student.setMobile(rs.getString("mobile"));
				student.setBirthdate(rs.getDate("birthdate"));
				student.setSex(rs.getInt("sex"));
				student.setEmail(rs.getString("email"));
				
				universityDAO universityDAO = new universityDAO();
				student.setUniversity(universityDAO.selectById(rs.getInt("UNIVERSITY_ID")));
				
				SchoolDAO schoolDAO = new SchoolDAO();
				student.setSchool(schoolDAO.selectById(rs.getInt("school_Id")));
				//School school = schoolDAO.selectById(rs.getInt("school_Id"));
				//student.setSchool(school);
				
				ProgramDAO programDAO = new ProgramDAO();
				//Program program = programDAO.selectById(rs.getInt("program_id"));
				student.setProgram(programDAO.selectById(rs.getInt("program_id")));
				
				student.setFINAL_AVERAGE(rs.getInt("FINAL_AVERAGE"));
				student.setMAX_AVERAGE(rs.getInt("MAX_AVERAGE"));
				student.setRate(rs.getString("rate"));
				student.setSTART_YEAR(rs.getInt("START_YEAR"));
				student.setGRADUATE_YEAR(rs.getInt("GRADUATE_YEAR"));
				student.setGRADUATE_SEM(rs.getInt("GRADUATE_SEM"));
				studentTable.add(student); 

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return studentTable;

	}
	
	public  Student selectbyID(int id) {
		Student student=null;
		try {
			db=new Database();
			connection=db.getConnection();
			ps=connection.prepareStatement(
					"select STUDENT_ID ,STUDENT_ANAME , STUDENT_ENAME   from student where student_id = ?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if (rs.next()) {
				student=new Student(
					rs.getInt("STUDENT_ID")	,
					rs.getString("STUDENT_ANAME"),
					rs.getString("STUDENT_ENAME")
					
						
						);
				
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
				return student;
	} 
	

	public int insert(Student student) {
		try {
			db=new Database(); 
			connection=db.getConnection(); 
			ps=connection.prepareStatement("insert into student(STUDENT_ID ,STUDENT_ANAME , STUDENT_ENAME , mobile , birthdate , sex , email , UNIVERSITY_ID , school_Id , program_id , FINAL_AVERAGE , MAX_AVERAGE , rate , START_YEAR , GRADUATE_YEAR , GRADUATE_SEM)values ( ? ,? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )");
					int counter=1; 
					ps.setInt(counter++, student.getSTUDENT_ID());
					ps.setString(counter++, student.getSTUDENT_ANAME());
					ps.setString(counter++, student.getSTUDENT_ENAME());
					ps.setString(counter ++, student.getMobile());
					ps.setDate(counter++, new Date(student.getBirthdate().getTime()));
					ps.setInt(counter++, student.getSex());
					ps.setString(counter++, student.getEmail());
					ps.setInt(counter++, student.getUniversity().getUniversityId());
					ps.setInt(counter++, student.getSchool().getSchool_Id());
					ps.setInt(counter++, student.getProgram().getPROGRAM_ID());
					ps.setInt(counter++, student.getFINAL_AVERAGE());
					ps.setInt(counter++, student.getMAX_AVERAGE());
					ps.setString(counter++, student.getRate());
					ps.setInt(counter++, student.getSTART_YEAR());
					ps.setInt(counter++, student.getGRADUATE_YEAR());
					ps.setInt(counter++, student.getGRADUATE_SEM());
                   row=ps.executeUpdate();


					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
		
		
	}
	public int update(Student student) {
		try {
			db=new Database(); 
			connection=db.getConnection(); 
			ps=connection.prepareStatement(
					"update  student set STUDENT_ANAME=?  , STUDENT_ENAME=? , mobile=? , birthday=? , sex=? , email=? , UNIVERSITY_ID=?  , school_Id=? , program_id=? , FINAL_AVERAGE=? , MAX_AVERAGE=? , rate=? , START_YEAR=? , GRADUATE_YEAR=? , GRADUATE_SEM=? where STUDENT_ID=? ");
					int counter=1; 
					
					ps.setString(counter++, student.getSTUDENT_ANAME());
					ps.setString(counter++, student.getSTUDENT_ENAME());
					ps.setString(counter ++, student.getMobile());
					ps.setDate(counter++,new java.sql.Date(student.getBirthdate().getTime()));
					ps.setInt(counter++, student.getSex());
					ps.setString(counter++, student.getEmail());
					ps.setInt(counter++, student.getUniversity().getUniversityId());
					ps.setInt(counter++, student.getSchool().getSchool_Id());
					ps.setInt(counter++, student.getProgram().getPROGRAM_ID());
					ps.setInt(counter++, student.getFINAL_AVERAGE());
					ps.setInt(counter++, student.getMAX_AVERAGE());
					ps.setString(counter++, student.getRate());
					ps.setInt(counter++, student.getSTART_YEAR());
					ps.setInt(counter++, student.getGRADUATE_YEAR());
					ps.setInt(counter++, student.getGRADUATE_SEM());
					ps.setInt(counter++, student.getSTUDENT_ID());
					

                   row=ps.executeUpdate();


					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
		}
	public int delete(int id ) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete student where STUDENT_ID = ?");
			ps.setInt(1, id);
			row = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Database.close(ps);
			Database.close(connection);
		}		
		
		return row;
	}

	
		

}
