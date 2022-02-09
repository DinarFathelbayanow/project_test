<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Задачи</title>
    <style>
        input[type = "submit"], a {
            font-size: 14px;
            font-family: Arial, sans-serif;
            background-color: rgb(223, 223, 223);
            padding: 2px 4px;
            border-radius: 3px;
        }

        a {
            text-decoration: none;
            border: 1px solid black;
            color: black;
        }
    </style>
    <title>Проекты</title>
</head>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }

</style>
</head>
<body>
<body>
<h1> Задачи текущего проекта</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Название задачи</th>
        <th>Статус задачи</th>
        <th>Описание задачи</th>
        <th>Приоритет задачи</th>
        <th>Действие</th>
    </tr>
    <#list tasks as task>
    <tr>
        <td> ${task.id}</td>
        <td> ${task.taskName}</td>
        <td> ${task.taskStatus}</td>
        <td> ${task.description}</td>
        <td> ${task.priority}</td>
        <td>
            <form method="post" action="/projects/${projectId}/deleteTask">
                <input name="taskId" type="hidden" value="${task.id}">
                <input type="submit" value="Удалить">
            </form>
        </td>
    </tr>
    </#list>
</table>
<h1> Задачи не участвующие на проекте</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Название задачи</th>
        <th>Статус задачи</th>
        <th>Описание задачи</th>
        <th>Приоритет задачи</th>
        <th>Действие</th>
    </tr>
    <#list unusedTasks as task>
        <tr>
            <td> ${task.id}</td>
            <td> ${task.taskName}</td>
            <td> ${task.taskStatus}</td>
            <td> ${task.description}</td>
            <td> ${task.priority}</td>
            <td>
                <form method="post" action="/projects/${projectId}/tasks">
                    <input name="taskId" type="hidden" value="${task.id}">
                    <input type="submit" value="Добавить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>