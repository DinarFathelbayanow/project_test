package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.web.forms.TaskForm;
import ru.pcs.web.models.Task;
import ru.pcs.web.services.TasksService;

import java.util.List;

@Controller
public class TasksController {
    private final TasksService tasksService;
    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/tasks")
    public String getTaskPage(Model model) {
        List<Task> tasks = tasksService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/{task-id}")
    public String getTaskPage(Model model, @PathVariable("task-id") Long taskId) {
        Task task = tasksService.getTask(taskId);
        model.addAttribute("task", task);
        return "taskId";
    }

    @PostMapping("/tasks")
    public String addTask(TaskForm taskForm)  {
        tasksService.addTask(taskForm);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/{task-id}/delete")
    public String deleteTask(@PathVariable("task-id") Long taskId) {
        tasksService.deleteTask(taskId);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/{task-id}/update")
    public String update(@PathVariable("task-id") Long taskId, TaskForm taskForm) {
        tasksService.updateTask(taskId, taskForm);
        return "redirect:/tasks";
    }

}
