package com.openclassrooms.webinarjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.webinarjpa.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
