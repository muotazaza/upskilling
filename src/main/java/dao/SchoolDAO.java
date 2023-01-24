package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Database;
import bean.School;

public class SchoolDAO {
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<School> SchoolTable;
	private int row;

	public List<School> selectAll() {
		SchoolTable = new ArrayList<School>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select school_Id , school_aname , school_ename from school order by school_id  ");
			rs = ps.executeQuery();
			while (rs.next()) {
				School school = new School(
						rs.getInt("school_Id"),
						rs.getString("school_aname"),
						rs.getString("school_ename"));
				SchoolTable.add(school);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return SchoolTable;
	}

	public School selectById(int id) {
		School school = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection
					.prepareStatement("select School_Id, school_aname ,school_ename from School where School_Id = ? ");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				school = new School(rs.getInt("school_Id"), rs.getString("school_aname"), rs.getString("school_ename"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			 Database.close(connection);
		}
		return school;
	}

	public int insert(School school) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection
					.prepareStatement("insert into school (school_id , school_aname , school_ename )values(? , ? ,? )");
			int counter = 1;
			ps.setInt(counter++, school.getSchool_Id());
			ps.setString(counter++, school.getSchool_aname());
			ps.setString(counter++, school.getSchool_ename());
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

	public int update(School school) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update school set school_aname=? , school_ename=? where school_id=? ");
			int counter = 1;
			ps.setString(counter++, school.getSchool_aname());
			ps.setString(counter++, school.getSchool_ename());
			ps.setInt(counter++, school.getSchool_Id());
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

	public int delete(int id) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from school where school_id=?");
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
