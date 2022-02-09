<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
<h1>Добавление проекта</h1>
<form method="post" action="/projects">
    <label>Название проекта:
        <input name="projectName" placeholder="Название проекта:">
    </label>
    <label>Дата начала проекта:
        <input name="dStart" placeholder="Дата начала проекта">
    </label>
    <label>Дата завершения проекта:
        <input name="dEnd" placeholder="Дата завершения проекта">
    </label>
    <label>Статус проекта:
        <input name="projectStatus" placeholder="Статус проекта">
    </label>
    <label>Приоритет:
        <input name="priority" placeholder="Приоритет">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Название проекта</th>
        <th>Дата начала проекта</th>
        <th>Дата завершения проекта</th>
        <th>Статус проекта</th>
        <th>Приоритет</th>
        <th>Действия</th>
    </tr>
    <#list projects as allProject>
        <tr>
            <td>${allProject.id}</td>
            <td>${allProject.projectName}</td>
            <td>${allProject.DStart?date('yyyy-MM-dd')}</td>
            <td>${allProject.DEnd?date('yyyy-MM-dd')}</td>
            <td>${allProject.projectStatus}</td>
            <td>${allProject.priority}</td>
            <td>
                <form method="post" action="/projects/${allProject.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/projects/${allProject.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>

