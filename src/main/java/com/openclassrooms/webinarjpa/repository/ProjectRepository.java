package com.openclassrooms.webinarjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.webinarjpa.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
