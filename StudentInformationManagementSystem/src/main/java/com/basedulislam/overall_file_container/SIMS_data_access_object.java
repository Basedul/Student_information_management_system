package com.basedulislam.overall_file_container;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/*
 * This class used for data access from database
 * I'm Using mysql database
 * Class name is Student information management system data access object
 */

@Component("simsdao") // This annotation for autowired, simsdao just bean refference
public class SIMS_data_access_object {
	/*
	 * Field of Dao
	 */
	private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbcna;

	// Set data source
	@Autowired // Autowired annotation used for auto wiring
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
		jdbcna = new NamedParameterJdbcTemplate(jdbc);
	}

	// Get list of data from database table
	public List<Student_information_management_system> getStudentInfo() {
		return jdbcna.query("select * from student_info", new RowMapper<Student_information_management_system>() {

			public Student_information_management_system mapRow(ResultSet rs, int rowNum) throws SQLException {
				// Import beans file
				ApplicationContext context = new ClassPathXmlApplicationContext(
						"com/basedulislam/beans_file_container/beans.xml");

				// Create Instance
				Student_information_management_system stinfo = (Student_information_management_system) context
						.getBean("sims");

				// get data from database and set to list item
				stinfo.setId(rs.getInt("id"));
				stinfo.setName(rs.getString("name"));
				stinfo.setEmail(rs.getString("email"));
				stinfo.setDept(rs.getString("dept"));
				stinfo.setBloodGroup(rs.getString("bloodGroup"));

				// close beans file
				((ClassPathXmlApplicationContext) context).close();

				// return student information
				return stinfo;
			}

		});
	}

	// Insert data into table using this function
	public void insertDataIntoTable(Student_information_management_system sims) {

		// This is insert query
		String inser_query = "insert into student_info (name, email, dept, bloodGroup) values (:name, :email, :dept, :bloodGroup)";

		// Map used for insert individual columns
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", sims.getName());
		paramMap.put("email", sims.getEmail());
		paramMap.put("dept", sims.getDept());
		paramMap.put("bloodGroup", sims.getBloodGroup());

		// execute query
		jdbcna.update(inser_query, paramMap);

	}

	// Get data from database table
	public List<Student_information_management_system> getJustOneObject(String name) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);

		// return data
		return jdbcna.query("select * from student_info where name = :name", params,
				new RowMapper<Student_information_management_system>() {

					public Student_information_management_system mapRow(ResultSet rs, int rowNum) throws SQLException {
						// Import beans file
						ApplicationContext context = new ClassPathXmlApplicationContext(
								"com/basedulislam/beans_file_container/beans.xml");

						// Create Instance
						Student_information_management_system stinfo = (Student_information_management_system) context
								.getBean("sims");

						// get data from database and set to list item
						stinfo.setId(rs.getInt("id"));
						stinfo.setName(rs.getString("name"));
						stinfo.setEmail(rs.getString("email"));
						stinfo.setDept(rs.getString("dept"));
						stinfo.setBloodGroup(rs.getString("bloodGroup"));

						// close beans file
						((ClassPathXmlApplicationContext) context).close();

						// return student information
						return stinfo;
					}
				});
	}
	
	// Delete single data from database table depend on id
	public void delete(int id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		jdbcna.update("delete from student_info where id = :id",params);
	}

}
