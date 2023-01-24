package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Database;
import bean.Program;
//import bean.School;

public class ProgramDAO {
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Program> programTable;
	private int row;

	public List<Program> selectAll() {
		programTable = new ArrayList<Program>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select program_id ,Program_aname ,Program_ename ,school_id from program order by program_id ");
			rs = ps.executeQuery();
			while (rs.next()) {
				Program program = new Program();
				program.setPROGRAM_ID(rs.getInt("program_id"));
				program.setPROGRAM_ANAME(rs.getString("Program_aname"));
				program.setPROGRAM_ENAME(rs.getString("Program_ename"));

				SchoolDAO schoolDAO = new SchoolDAO();
				program.setSchool(schoolDAO.selectById(rs.getInt("school_id")));

				programTable.add(program);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return programTable;

	}

	public List<String> selectename() {
		List<String> enametable = new ArrayList<String>();

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select DISTINCT school_ename from program order by  school_ename  ");
			rs = ps.executeQuery();
			while (rs.next()) {

				enametable.add(rs.getString("school_ename"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return enametable;

	}

	public Program selectById(int id) {
		Program program = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select  program_id ,Program_aname ,Program_ename from program where program_id =?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if (rs.next()) {

				program = new Program(rs.getInt("program_id"), rs.getString("Program_aname"),
						rs.getString("Program_ename"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return program;
	}

	public int insert(Program program) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into program (PROGRAM_ID, PROGRAM_ANAME, PROGRAM_ENAME, SCHOOL_ID) values(?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, program.getPROGRAM_ID());
			ps.setString(counter++, program.getPROGRAM_ANAME());
			ps.setString(counter++, program.getPROGRAM_ENAME());
			ps.setInt(counter++, program.getSchool().getSchool_Id());
			row = ps.executeUpdate();
		}
		catch (Exception e) {

			e.printStackTrace();
		} finally {
			//Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int update(Program program) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update program set program_aname=?, program_ename=? where program_id =?");
			int counter = 1;
			ps.setInt(counter++, program.getPROGRAM_ID());
			ps.setString(counter++, program.getPROGRAM_ANAME());
			ps.setString(counter++, program.getPROGRAM_ENAME());
			ps.setInt(counter++, program.getSchool().getSchool_Id());
			row = ps.executeUpdate();
		}  catch (Exception e) {
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
			ps = connection.prepareStatement("delete from program where program_id=?");
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
/*
 * public Program selectByid(int id ) { Program program =null ; try { db =new
 * Database(); connection=db.getConnection(); ps= connection.
 * prepareStatement("select program_id , Program_aname ,Program_ename  ,school_id from program where program_id =? "
 * ); ps.setInt(1, id); if (rs.next()) { //program= new
 * Program(rs.getInt("program_id") , rs.getString("Program_aname"),
 * rs.getString("Program_ename"), rs.getInt("school_id"));
 * 
 * } } catch (SQLException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } } }
 */
