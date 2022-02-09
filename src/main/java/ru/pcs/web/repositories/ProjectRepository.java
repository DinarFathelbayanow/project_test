package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
