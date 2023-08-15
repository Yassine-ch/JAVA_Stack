package com.yassine.ProjectManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.yassine.ProjectManager.models.Project;
import com.yassine.ProjectManager.models.Task;
import com.yassine.ProjectManager.models.User;
import com.yassine.ProjectManager.services.ProjectService;
import com.yassine.ProjectManager.services.TaskService;
import com.yassine.ProjectManager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TaskService taskService;

	

	// Show All Projects
	@GetMapping("/dashboard")
	public String showAllProjects(Model model, HttpSession session) {
		// Grab the user_id from session
		Long userId = (Long) session.getAttribute("user_id");
		// Route Guard
		if (userId == null) {
			return "redirect:/login";
		} else {
			User user = userService.getUserById(userId);
			model.addAttribute("user", user);

			List<Project> allProjects = projectService.allProjects();

			model.addAttribute("allProjects", allProjects);
			return "dashboard.jsp";
		}
	}

	// Display Form Project
	@GetMapping("/projects/new")
	public String edit(@ModelAttribute("project") Project project, Model model) {

		return "projectForm.jsp";
	}
	// Create a new Project
	@PostMapping("projects/new")
	public String newDojo(@Valid @ModelAttribute("project") Project project,
			BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {

			return "projectForm.jsp";
		} else {

			Long userId = (Long) session.getAttribute("user_id");

			User actualUser = userService.getUserById(userId);

			project.setUser(actualUser);

			projectService.createProject(project);

			return "redirect:/dashboard";
		}
	}
	// Join a Project
	@GetMapping("projects/{projectId}/join")
	public String joinProject(@PathVariable("projectId") Long projectId, HttpSession session) {
		
		// 1.Grab the logged in user
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = userService.getUserById(userId);
		//2. Grab the Project from the db
		
		Project thisProject = projectService.findProject(projectId);
		// .3 Add the User (manager) to join the project
		
		thisProject.getUsers().add(currentUser);
		// 4. Save the Project 
		
		projectService.updateProject(thisProject);
		
		return "redirect:/dashboard";
		
		
	}
	// Leave a project
	@GetMapping("projects/{projectId}/leave")
	public String leaveProject(@PathVariable("projectId") Long projectId, HttpSession session) {
		
		// 1.Grab the logged in user
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = userService.getUserById(userId);
		//2. Grab the Project from the db
		
		Project thisProject = projectService.findProject(projectId);
		// .3 Add the User (manager) to join the project
		
		thisProject.getUsers().remove(currentUser);
		// 4. Save the Project 
		
		projectService.updateProject(thisProject);
		
		return "redirect:/dashboard";
		
	}
	
	// Display Form Edit Project
	@GetMapping("/projects/{id}/edit")
	public String editProject(@ModelAttribute("project") Project project ,@PathVariable("id") Long projectId, HttpSession session, Model model) {
		
		// Grab current user id and compare it to the belt ninja id
		Long userId = (Long) session.getAttribute("user_id");
		

		Project thisProject = projectService.findProject(projectId);
		// Grab the ninja id from the thisBelt
		Long managerId = thisProject.getUser().getId();
		//Edit route guard
		if(!(userId.equals(managerId))) {
			return "redirect:/dashboard"; 
		}
		model.addAttribute("project",thisProject);
		
		return "editProject.jsp";
}
	@PutMapping("/projects/{id}/edit")
	public String updateProject(@Valid @ModelAttribute("project") Project project,
			BindingResult result,Model model, HttpSession session,
			@PathVariable("id") Long projectId) {
			if (result.hasErrors()) {
				return "editProject.jsp";
			} else {
				Long userId = (Long) session.getAttribute("user_id");
				User actualUser = userService.getUserById(userId);
				project.setUser(actualUser);
				projectService.createProject(project);
				
				return "redirect:/dashboard";

			}
			
	}
	// Delete Project
	@DeleteMapping("/projects/{id}/delete")
	public String deleteProject(@PathVariable("id") Long projectId) {
		projectService.deleteProject(projectId);
		return "redirect:/dashboard";
	}	
	
	// Show One Project
	@GetMapping("/projects/{id}")
	public String showOneProject(@PathVariable("id") Long projectId, Model model, HttpSession session) {
		Project thisProject = projectService.findProject(projectId);
		model.addAttribute("project", thisProject);
		Long userId = (Long) session.getAttribute("user_id");
		User currentUser = userService.getUserById(userId);
		model.addAttribute("user", currentUser);
		return "oneProject.jsp";
	}
	
	// Show Project's Tasks
	@GetMapping("/projects/{id}/tasks")
	public String showTask(@PathVariable("id")Long projectId, Model model,
			@ModelAttribute("task") Task task) {
		Project thisProject = projectService.findProject(projectId);
		model.addAttribute("project", thisProject);
		return "projectTasks.jsp";
	}
	// Add Task to the project
	@PostMapping("/projects/{projectId}/tasks")
	public String addTask(@Valid @ModelAttribute("task") Task task,
			@PathVariable("projectId") Long projectId,
			HttpSession session) {
		// 1. Grab the project by id
		Project thisProject = projectService.findProject(projectId);
		
		
		
		// 3. grab the current user from the session

		Long user_id = (Long) session.getAttribute("user_id");
		User currentUser = userService.getUserById(user_id);
		// 4. Set to the newTask the Project and the User Models
		task.setProject(thisProject);
		task.setUser(currentUser);
		// 2. Create the new task
		Task newTask = taskService.createTask(task);
		
		return "redirect:/dashboard";
	}
	
	
	
	
	
	
	
	
	
}