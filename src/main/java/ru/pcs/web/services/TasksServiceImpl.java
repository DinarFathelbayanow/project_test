package ru.pcs.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcs.web.forms.TaskForm;
import ru.pcs.web.models.Task;
import ru.pcs.web.repositories.TaskRepository;

import java.util.List;

@Component
public class TasksServiceImpl implements TasksService {
    private final TaskRepository taskRepository;

    @Autowired
    public TasksServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(TaskForm taskForm) {
        Task task = Task.builder()
                .taskName(taskForm.getTaskName())
               .taskStatus(taskForm.getTaskStatus())
                .description(taskForm.getDescription())
                .priority(taskForm.getPriority())
                .build();
        taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task getTask(Long taskId) {
        return taskRepository.getById(taskId);
    }

    @Override
    public void updateTask(Long taskId, TaskForm taskForm) {
        Task task = taskRepository.getById(taskId);
        task.setTaskName(taskForm.getTaskName());
        task.setTaskStatus(taskForm.getTaskStatus());
        task.setDescription(taskForm.getDescription());
        task.setPriority(taskForm.getPriority());
        taskRepository.save(task);
    }
}
