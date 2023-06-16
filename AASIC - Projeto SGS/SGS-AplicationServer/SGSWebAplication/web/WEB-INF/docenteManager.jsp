<%-- 
    Document   : docenteManager
    Created on : 15/06/2023, 19:54:38
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Cursos</title>
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
            }
            .data-table {
                width: 100%;
                border-collapse: collapse;
                word-wrap: break-word;
            }

            .data-table th,
            .data-table td {
                width: auto;
                padding: 10px;
                border: 1px solid #ccc;
            }
            
            .data-table {
                width: 100%;
                border-collapse: collapse;
                word-wrap: break-word;
            }

            input{
                height: 15px;
                width: 100%;
                max-width: 100%;
                overflow-x: hidden;
                text-align: center;
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
        </style>
    </head>
    <script>
        function confirmDelete(codigo) {
            var confirmation = confirm("Tem a certeza de que pretende eliminar a disciplina " + codigo + "?");
            if (confirmation) {
                const url = window.location.href;
                console.log(url);
                fetch(url, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'JSESSIONID': '${pageContext.session.id}'
                    },
                    body: JSON.stringify("Delete//" + codigo)
                })
                    .then(response => response.text())
                    .then(html => {
                        console.log(html);
                    })
                    .catch(error => {
                        // Handle network error
                        console.error('Network error:', error);
                    });
                location.reload();
            }
        }

        function toggleEdit(codigo) {
            var nomeElement = document.getElementById("nome-" + codigo);
            var idadeElement = document.getElementById("idade-" + codigo);
            var numeroElement = document.getElementById("numero-" + codigo);
            var generoElement = document.getElementById("genero-" + codigo);
            var departamentoElement = document.getElementById("departamento-" + codigo);
            var editButton = document.getElementById("editButton-" + codigo);

            if (nomeElement.readOnly || idadeElement.readOnly || numeroElement.readOnly || generoElement.readOnly 
                    || departamentoElement.readOnly) {
                nomeElement.readOnly = false;
                idadeElement.readOnly = false;
                numeroElement.readOnly = false;
                generoElement.readOnly = false;
                departamentoElement.readOnly = false;
                editButton.innerHTML = "Submit";
            } else {
                nomeElement.readOnly = true;
                idadeElement.readOnly = true;
                numeroElement.readOnly = true;
                generoElement.readOnly = true;
                departamentoElement.readOnly = true;
                editButton.innerHTML = "Edit";
                submitChanges(codigo, nomeElement.value, idadeElement.value, numeroElement.value, generoElement.value, departamentoElement.value);
            }
        }



        function submitChanges(codigo, nome, idade, numero, genero, departamento) {
            const url = window.location.href; // Get the current URL
            const data = "Edit//" + codigo + "//" + nome + "//" + idade + "//" + numero + "//" + genero + "//" + departamento;

            fetch(url, {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
                'JSESSIONID': '${pageContext.session.id}'
              },
              body: JSON.stringify(data)
            })
            .then(response => response.text())
            .then(html => { console.log(html);})
            .catch(error => {
              // Handle network error
              console.error('Network error:', error);
            });
        }
    </script>
    <body>
        <div class="header">
            <h1>Gestão de Docentes</h1>
        </div>
        <div class="main-menu">
            <a href="adminMainMenu" style="margin-left:15px">Main Menu</a> > Gestão de Docentes
        </div>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Email</th>
                    <th>Nome</th>
                    <th>Idade</th>
                    <th>Numero</th>
                    <th>Genero</th>
                    <th>Departamento</th>
                    <th>Ações</th>
                </tr>
                <% List<sgs.Docente> rows = (List<sgs.Docente>) request.getAttribute("allDocentes");
                if (rows != null) {
                    for (sgs.Docente row : rows) { %>
                        <tr>
                            <!-- Row data... -->
                            <td id="codigo-<%= row.getEmail() %>"><%= row.getEmail() %></td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="nome-<%= row.getEmail() %>" type="text" value="<%= row.getNome() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="idade-<%= row.getEmail() %>" type="number" value="<%= row.getIdade() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="numero-<%= row.getEmail() %>" type="text" value="<%= row.getNumero() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="genero-<%= row.getEmail() %>" type="text" value="<%= row.getGenero() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="width: 200px; background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="departamento-<%= row.getEmail() %>" type="text" value="<%= row.getDepartamento() %>" readonly>
                            </td>
                            <td class="buttons">
                                <button id="editButton-<%= row.getEmail() %>" type="button" onclick="toggleEdit('<%= row.getEmail() %>')">Edit</button>
                                <input type="hidden" name="codigo" value="<%= row.getEmail() %>">
                                <button type="button" onclick="confirmDelete('<%= row.getEmail() %>')">Delete</button>
                            </td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='criarDocente.jsp'">Criar Docente</button>
            <button onclick="window.history.back()">Voltar</button>
        </div>
    </body>
</html>
