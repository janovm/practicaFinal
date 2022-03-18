package com.alejandro.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.app.entity.State;

public interface StatesCrudRepository extends CrudRepository<State, Integer> {

}