<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>

<title>${task.taskName}</title>
<h3>Название задачи - ${task.taskName}</h3>
<h3>Статус задачи - ${task.taskStatus}</h3>
<h3>Описание задачи - ${task.description}</h3>
<h3>Приоритет задачи - ${task.priority}</h3>

<br>
<form method="post" action="/tasks/${task.id}/update">
    <label>
        Название задачи: <input name="taskName" value="${task.taskName}">
    </label>
    <label>
        Статус задачи: <input name="taskStatus" value="${task.taskStatus}">
    </label>
    <label>
        Описание задачи: <input name="description" value="${task.description}">
    </label>
    <label>
        Приоритет задачи: <input name="priority" value="${task.priority}">
    </label>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
