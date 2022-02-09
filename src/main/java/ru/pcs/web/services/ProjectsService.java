package ru.pcs.web.services;

import ru.pcs.web.forms.ProjectForm;
import ru.pcs.web.models.Project;
import ru.pcs.web.models.Task;

import java.util.List;

public interface ProjectsService {

    void addProject(ProjectForm projectForm);
    List<Project> getAllProjects();
    void deleteProject(Long projectId);
    Project getProject(Long projectId);
    void updateProject(Long projectId, ProjectForm projectForm);

    List<Task> getTasksByProject(Long projectId);
    List<Task> getTasksWithoutProjects();

    void addTaskToProject(Long projectId, Long taskId);

    void deleteTaskToProject(Long taskId);
}
