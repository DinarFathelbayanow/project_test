package ru.pcs.web.services;

import ru.pcs.web.forms.TaskForm;
import ru.pcs.web.models.Task;

import java.util.List;

public interface TasksService {
    void addTask(TaskForm taskForm);
    List<Task> getAllTasks();
    void deleteTask(Long taskId);


    Task getTask(Long taskId);

    void updateTask(Long taskId, TaskForm taskForm);
}
