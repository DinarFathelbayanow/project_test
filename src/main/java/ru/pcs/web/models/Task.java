package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {
    public  enum TaskStatus{
        ToDo, InProgress, Done;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;

    @Enumerated(value = EnumType.STRING)
    private TaskStatus taskStatus;
    private String description;
    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
