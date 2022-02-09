<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
    <title>${project.projectName}</title>
</head>
<body>
<h3>Название проекта - ${project.projectName}</h3>
<h3>Дата начала проекта - ${project.DStart}</h3>
<h3>Дата завершения проекта - ${project.DEnd}</h3>
<h3>Статус проекта - ${project.projectStatus}</h3>
<h3>Приоритет - ${project.priority}</h3>

<br>
<form method="post" action="/projects/${project.id}/update">
    <label>
        Название проекта: <input name="projectName" value="${project.projectName}">
    </label>
    <label>
        Дата начала проекта: <input name="dStart" value="${project.DStart}">
    </label>
    <label>
        Дата завершения проекта: <input name="dEnd" value="${project.DEnd}">
    </label>
    <label>
        Статус проекта: <input name="projectStatus" value="${project.projectStatus}">
    </label>
    <label>
        Приоритет: <input name="priority" value="${project.priority}">
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
