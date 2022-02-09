package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.forms.ProjectForm;
import ru.pcs.web.models.Project;
import ru.pcs.web.models.Task;
import ru.pcs.web.repositories.ProjectRepository;
import ru.pcs.web.repositories.TaskRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProjectsServiceImpl implements ProjectsService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Override
    public void addProject(ProjectForm projectForm) {
        Project project = Project.builder()
                .projectName(projectForm.getProjectName())
                .dStart(projectForm.getDStart())
                .dEnd(projectForm.getDEnd())
                .projectStatus(projectForm.getProjectStatus())
                .priority(projectForm.getPriority())
                .build();
        projectRepository.save(project);

    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public Project getProject(Long projectId) {
        return projectRepository.getById(projectId);
    }

    @Override
    public void updateProject(Long projectId, ProjectForm projectForm) {
        Project project = projectRepository.getById(projectId);
        project.setProjectName(projectForm.getProjectName());
        project.setDStart(projectForm.getDStart());
        project.setDEnd(projectForm.getDEnd());
        project.setProjectStatus(projectForm.getProjectStatus());
        project.setPriority(projectForm.getPriority());
       projectRepository.save(project);
    }

    @Override
    public List<Task> getTasksByProject(Long projectId) {
        return taskRepository.findAllByProject_Id(projectId);
    }

    @Override
    public List<Task> getTasksWithoutProjects() {
        return taskRepository.findAllByProjectIsNull();
    }

    @Override
    public void addTaskToProject(Long projectId, Long taskId) {
        Project project = projectRepository.getById(projectId);
        Task task = taskRepository.getById(taskId);
        task.setProject(project);
        taskRepository.save(task);
    }

    @Override
    public void deleteTaskToProject(Long taskId) {
        Task task = taskRepository.getById(taskId);
        task.setProject(null);
        taskRepository.save(task);
    }
}
