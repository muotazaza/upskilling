package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Database;
import bean.university;

public class universityDAO {
	private Database db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<university> universityTable;
	private int row;

	public List<university> selectAll() {
		universityTable = new ArrayList<university>();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					" select UNIVERSITY_ID, UNIVERSITY_ANAME, UNIVERSITY_ENAME, WEBSITE from university order by UNIVERSITY_ID ");
			rs = ps.executeQuery();
			while (rs.next()) {
				university university = new university(
						rs.getInt("UNIVERSITY_ID"), rs.getString("UNIVERSITY_ENAME"),
						rs.getString("UNIVERSITY_ANAME"), rs.getString("WEBSITE"));

				universityTable.add(university);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return universityTable;
	}

	public university selectById(int id) {
		university university = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select university_Id, UNIVERSITY_aname ,UNIVERSITY_ename ,website  from university where university_Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				university = new university(rs.getInt("university_Id"), rs.getString("UNIVERSITY_ename"),
						rs.getString("UNIVERSITY_aname"), rs.getString("website"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return university;

	}

	public int insert(university university) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into university (university_Id,UNIVERSITY_aname,UNIVERSITY_ename,website) values( ? , ? , ? ,? )");
			int counter = 1;
			ps.setInt(counter++, university.getUniversityId());
			ps.setString(counter++, university.getaName());
			ps.setString(counter++, university.geteName());
			ps.setString(counter++, university.getWebsite());
			row = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;
	}

	public int update(university university) {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update university set UNIVERSITY_aname=?, UNIVERSITY_ename=?, website=? where university_Id=?");
			int counter = 1;
			ps.setString(counter++, university.getaName());
			ps.setString(counter++, university.geteName());
			ps.setString(counter++, university.getWebsite());
			ps.setInt(counter++, university.getUniversityId());
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
			ps = connection.prepareStatement("delete from university where university_Id =?");
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
