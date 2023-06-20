<%-- 
    Document   : consultarPresencas
    Created on : 17/06/2023, 16:38:26
    Author     : franc
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Presenças</title>
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
                text-align: left;
                margin-top: 20px;
                margin-bottom: 10px;
            }

            .main-menu a {
                color: #333;
                text-decoration: none;
            }

            .table-container {
                width: 80%;
                margin: 0 auto;
                overflow-y: auto;
                max-height: 75vh;
            }

            .data-table {
                width: 100%;
                border-collapse: collapse;
                word-wrap: break-word;
            }

            .data-table th,
            .data-table td {
                padding: 10px;
                border: 1px solid #ccc;
                transition: width 3.3s ease-in-out;
            }
            
            .data-table th {
                background-color: #333;
                color: #fff;
            }

            .data-table td.buttons {
                text-align: center;
            }

            .data-table td.buttons button {
                margin-right: 5px;
                padding: 5px 10px;
                border: none;
                border-radius: 3px;
                background-color: #4CAF50;
                color: #fff;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            
            input{
                height: 15px;
                width: 100%;
                max-width: 100%;
                overflow-x: hidden;
                text-align: center;
            }
            table {
                width: 100%;
                table-layout: fixed;
            }
            th, td {
                text-align: center;
                padding: 8px;
                word-wrap: break-word;
                height: 15px;
                overflow-x: hidden;
            }

            .data-table td.buttons button:hover {
                background-color: #45a049;
            }

            .fixed-buttons {
                position: fixed;
                bottom: 20px;
                right: 20px;
            }

            .fixed-buttons button {
                margin-left: 10px;
                padding: 10px 20px;
                border: none;
                border-radius: 3px;
                background-color: #4CAF50;
                color: #fff;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .fixed-buttons button:hover {
                background-color: #45a049;
            }

            input:focus {
                outline: none;
            }
            
            input[readonly] {
                pointer-events: none;
            }
        </style>
    </head>
        
    <body>
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="header">
            <h1>Consultar Presenças da Aula <%= session.getAttribute("codigoAula") %> </h1>
        </div>
        <div class="main-menu">
            <a href="../adminMainMenu" style="margin-left:15px">Main Menu</a> > <a href="../aulaManager" >Gestão de Aulas </a> > Consultar Presenças
        </div>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th onmouseover="this.style.width = '300px'" onmouseout="this.style.width = ''">Nome</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Email</th>
                    <th>Presença</th>
                </tr>
                <% sgs.Aula aula = (sgs.Aula) request.getAttribute("aula");
                if (aula.inscritos != null) {
                    List<sgs.Aluno> allInscritos = Arrays.asList(aula.inscritos.toArray());
                    for (sgs.Aluno aluno : allInscritos) { %>
                        <tr>
                            <!-- Row data... -->
                            <td id="email-<%= aluno.getEmail() %>"><%= aluno.getEmail() %></td>
                            <td id="nome-<%= aluno.getEmail() %>"><%= aluno.getNome() %></td>
                            <td id="presenca-<%= aluno.getEmail() %>"><%= aula.presentes.contains(aluno) ? "Presente" : "Ausente" %></td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='../aulaManager'">Voltar</button>
        </div>
    </body>
</html>
