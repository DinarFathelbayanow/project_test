package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {
    public enum ProjectStatus {
        NotStarted, Active, Completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    @Column(name = "project_start_date")
    private String dStart;
    @Column(name = "project_completion_date")
    private String dEnd;

   @Enumerated(value = EnumType.STRING)
    private ProjectStatus projectStatus;
    private Integer priority;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}
