package com.boot.pg.crud.bootpostgrescrud.dao;

import java.util.List;

import com.boot.pg.crud.bootpostgrescrud.model.User;

public interface UserDAO {

	List<User> findAll();
	
}
