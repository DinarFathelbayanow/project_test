package ru.pcs.web.forms;

import lombok.Data;
import ru.pcs.web.models.Task;

@Data
public class TaskForm {

    private Long id;
    private String taskName;
    private Task.TaskStatus taskStatus;
    private String description;
    private Integer priority;
}
