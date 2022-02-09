package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByProject_Id(Long id);
    List<Task> findAllByProjectIsNull();
}
