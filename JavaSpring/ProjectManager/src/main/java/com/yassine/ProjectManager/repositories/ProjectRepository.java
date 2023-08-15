package com.yassine.ProjectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yassine.ProjectManager.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	List <Project> findAll();
}