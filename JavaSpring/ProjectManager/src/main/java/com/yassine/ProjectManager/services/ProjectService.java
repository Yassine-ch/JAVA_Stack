package com.yassine.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yassine.ProjectManager.models.Project;
import com.yassine.ProjectManager.repositories.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	// Display all Projects

	public List<Project> allProjects() {
		return projectRepository.findAll();
	}

	// Create a project
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	// Find one
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if (optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}

	// Delete a project
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

	// Update a project
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
}