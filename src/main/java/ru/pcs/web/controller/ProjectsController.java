package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.forms.ProjectForm;
import ru.pcs.web.models.Project;
import ru.pcs.web.models.Task;
import ru.pcs.web.services.ProjectsService;

import java.util.List;

@Controller
public class ProjectsController {
    private final ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }
    @GetMapping("/projects")
    public String getProjectsPage(Model model) {
        List<Project> projects = projectsService.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/projects/{project-id}")
    public String getProjectPage(Model model, @PathVariable("project-id") Long projectId){
        Project project = projectsService.getProject(projectId);
        System.out.println(project.toString());
        model.addAttribute("project", project);
        return "projectId";

    }
    @PostMapping("/projects")
    public String addProject(ProjectForm projectForm)  {
        projectsService.addProject(projectForm);
        return "redirect:/projects";
    }

    @PostMapping("/projects/{project-id}/delete")
    public String deleteProject(@PathVariable("project-id") Long projectId) {
        projectsService.deleteProject(projectId);
        return "redirect:/projects";
    }
    @PostMapping("/projects/{project-id}/update")
    public String update(@PathVariable("project-id") Long projectId, ProjectForm projectForm) {
       projectsService.updateProject(projectId, projectForm);
        return "redirect:/projects";
    }

    @GetMapping("/projects/{project-id}/tasks")
    public String getTasksByProject(Model model, @PathVariable("project-id") Long projectId){
        List<Task> tasks = projectsService.getTasksByProject(projectId);
        List<Task> unusedTasks = projectsService.getTasksWithoutProjects();
        model.addAttribute("projectId", projectId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("unusedTasks", unusedTasks);
        return "tasks_of_project";
    }
    @PostMapping("/projects/{project-id}/tasks")
    public String addTaskToProject(@PathVariable("project-id") Long projectId, @RequestParam("taskId") Long taskId){
        projectsService.addTaskToProject(projectId, taskId);
        return "redirect:/projects/" + projectId + "/tasks";
    }
    @PostMapping("/projects/{project-id}/deleteTask")
    public String deleteTaskToProject(@PathVariable("project-id") Long projectId, @RequestParam("taskId") Long taskId){
        projectsService.deleteTaskToProject(taskId);
        return "redirect:/projects/" + projectId + "/tasks";
    }
}
