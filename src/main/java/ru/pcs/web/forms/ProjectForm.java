package ru.pcs.web.forms;

import lombok.Data;
import ru.pcs.web.models.Project;

@Data
public class ProjectForm {

    private Long id;
    private String projectName;
    private String dStart;
    private String dEnd;
    private Project.ProjectStatus projectStatus;
    private Integer priority;
}
