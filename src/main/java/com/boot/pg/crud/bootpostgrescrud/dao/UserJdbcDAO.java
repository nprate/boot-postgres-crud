package com.boot.pg.crud.bootpostgrescrud.dao;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.boot.pg.crud.bootpostgrescrud.model.User;

@Component
public class UserJdbcDAO implements UserDAO {
	
	private final static Logger logger = LoggerFactory.getLogger(UserJdbcDAO.class);

	JdbcTemplate jdbcTemplate;
	
	
	RowMapper<User> rowMapper = (rs, rowNum) -> {
		
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setFirst_name(rs.getString("first_name"));
		user.setLast_name(rs.getString("last_name"));
		
		return user;
	};
	
	
	public UserJdbcDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public List<User> findAll() {
		
		String sql = "SELECT id, first_name, last_name FROM users";
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
