package org.riya.JDBCJavaEx.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.riya.JDBCJavaEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class StudentRepo {
	
	private JdbcTemplate jdbc;
	
	

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	
	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void save(Student s) {
		
		String query = "Insert into Student (rollno, name, marks) values (?, ?, ?)";
		int rows = jdbc.update(query, s.getRollNo(), s.getName(), s.getMarks());
		System.out.println(rows);
		
		
	}

	public List<Student> findAll() {
		
		String sql = "select * from Student";
		RowMapper<Student> mapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setRollNo(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				return s;
			}
			
		};
		
		return jdbc.query(sql, mapper);
		
	}



}
