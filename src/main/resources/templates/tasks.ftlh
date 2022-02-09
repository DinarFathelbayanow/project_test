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
<body>
<h1> Добавление задачи</h1>
<form method="post" action="/tasks">
    <label>Название задачи:
        <input name="taskName" placeholder="Название задачи">
    </label>
    <label>Статус задачи:
        <input name="taskStatus" placeholder="Статус задачи">
    </label>
    <label>Описание задачи:
        <input name="description" placeholder="Описание задачи">
    </label>
    <label>Приоритет задачи:
        <input   name="priority" placeholder="Приоритет задачи">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Название задачи</th>
        <th>Статус задачи</th>
        <th>Описание задачи</th>
        <th>Приоритет задачи</th>
        <th>Действия</th>
    </tr>
    <#list tasks as task>
        <tr>
            <td> ${task.id}</td>
            <td> ${task.taskName}</td>
            <td> ${task.taskStatus}</td>
            <td> ${task.description}</td>
            <td> ${task.priority}</td>
            <td>
                <form method="post" action="/tasks/${task.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/tasks/${task.id}"> Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>