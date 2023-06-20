<%-- 
    Document   : adminMainMenu
    Created on : 14/06/2023, 20:22:20
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Main Menu</title>
        <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: left;
        }

        .header h1 {
            margin: 0;
        }

        .main-menu {
            text-align: center;
            margin-top: 50px;
        }

        .main-menu h2 {
            margin: 0;
            font-size: 24px;
            color: #333;
        }

        .menu-buttons {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 30px;
        }

        .menu-button {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 15px 20px;
            margin-top: 10px;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 250px;
        }

        .menu-button:hover {
            background-color: #45a049;
        }
    </style>
    </head>
    <body>
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="header">
            <h1>SGS Admin</h1>
        </div>
        <div class="main-menu">
            <h2>Main Menu</h2>
            <div class="menu-buttons">
                <button class="menu-button" onclick="window.location.href='aulaManager'">Gerir Aulas</button>
                <button class="menu-button" onclick="window.location.href='conferenciaManager'">Gerir Conferencias</button>
                <button class="menu-button" onclick="window.location.href='salaManager'">Gerir Salas</button>
                <button class="menu-button" onclick="window.location.href='cursoManager'">Gerir Cursos</button>
                <button class="menu-button" onclick="window.location.href='disciplinaManager'">Gerir Disciplinas</button>
                <button class="menu-button" onclick="window.location.href='docenteManager'">Gerir Docentes</button>
            </div>
        </div>
    </body>
</html>
