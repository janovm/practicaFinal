package com.alejandro.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.app.entity.Role;

public interface RolesCrudRepository extends CrudRepository<Role, Integer> {

}