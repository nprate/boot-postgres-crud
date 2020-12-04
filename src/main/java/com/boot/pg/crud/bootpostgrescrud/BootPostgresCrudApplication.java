package com.boot.pg.crud.bootpostgrescrud;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.pg.crud.bootpostgrescrud.dao.UserDAO;
import com.boot.pg.crud.bootpostgrescrud.model.User;

@SpringBootApplication
public class BootPostgresCrudApplication {

	
	private static UserDAO userDao;
	
	public BootPostgresCrudApplication(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootPostgresCrudApplication.class, args);
		
		System.out.println("\n All User==================================\n");
		List<User> userList = userDao.findAll();
		userList.forEach(data -> System.out.println(data.getId() + " | " + data.getFirst_name() + " | " + data.getLast_name()));
	}

}
