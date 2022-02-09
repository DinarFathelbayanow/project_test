Приложение для  введения  задач по проекту.

Project information that should be stored:
* the name of the project
* project start date
* project completion date
* the current status of the project (enum: NotStarted, Active,
priority (int)
  
Task information that should be stored:
* task name
* task status (enum: ToDo / InProgress / Done)
* description
* priority (int)

Приложение написано с функционалом:
* Возможность создания / редактирования / просмотра / удаления информации о проектах
* Возможность создания / редактирования / просмотра / удаления информации о задаче
* Возможность добавлять и удалять задачи из проекта (один проект может содержать несколько задач)
* Возможность просматривать все задачи в проекте

Используемые технологии
* Java 11
* Spring Boot, Spring MVC, Spring Data JPA
* Hibernate 
* Freemarker
* PostgreSQL
* Maven
* Tomcat

Web API:
* localhost/tasks - Возможность создания / редактирования / просмотра / удаления информации о задачах
* localhost/project - Возможность создания  / просмотра / удаления информации о проектах
* localhost/projects/{project-id}/tasks - Возможность добавлять и удалять задачи из проекта
  Возможность просматривать все задачи в проекте