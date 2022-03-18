package com.alejandro.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.app.entity.Calendar;


public interface CalendarsCrudRepository extends CrudRepository<Calendar, Integer> {

}