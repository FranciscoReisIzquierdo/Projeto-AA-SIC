<%-- 
    Document   : salaManager
    Created on : 14/06/2023, 22:32:16
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Salas</title>
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

            .data-table {
                width: 100%;
                border-collapse: collapse;
            }

            .data-table th,
            .data-table td {
                padding: 10px;
                border: 1px solid #ccc;
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
            var confirmation = confirm("Tem a certeza de que pretende eliminar a sala " + codigo + "?");
            if (confirmation) {
                const url = window.location.href;
                console.log(url);
                fetch(url, {
                    method: 'POST',
                    headers: {
                      'Content-Type': 'application/json',
                      'JSESSIONID': '${pageContext.session.id}'
                    },
                    body: JSON.stringify("Delete/"+ codigo)
                  })
                  .then(response => response.text())
                  .then(html => { console.log(html);})
                  .catch(error => {
                    // Handle network error
                    console.error('Network error:', error);
                  });
                  location.reload();
                }
        }
        
        function toggleEdit(codigo) {
            var capacidadeElement = document.getElementById("capacidade-" + codigo);
            var localizacaoElement = document.getElementById("localizacao-" + codigo);
            var lotacaoElement = document.getElementById("lotacao-" + codigo);
            var editButton = document.getElementById("editButton-" + codigo);

            if (capacidadeElement.readOnly) {
                capacidadeElement.readOnly = false;
                editButton.innerHTML = "Submit";
            } else {
                capacidadeElement.readOnly = true;
                editButton.innerHTML = "Edit";
                submitChanges(codigo, capacidadeElement.value, localizacaoElement.value, lotacaoElement.value);
            }
        }

        function submitChanges(codigo, capacidade, localizacao, lotacao) {
            const url = window.location.href; // Get the current URL
            const data = "Edit/" + codigo + "/" + capacidade;

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
            <h1>Gestão de Salas</h1>
        </div>
        <div class="main-menu">
            <a href="adminMainMenu" style="margin-left:15px">Main Menu</a> > Gestão de Salas
        </div>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Código</th>
                    <th>Localização</th>
                    <th>Lotação</th>
                    <th>Capacidade</th>
                    <th>Ações</th>
                </tr>
                <% List<sgs.Sala> rows = (List<sgs.Sala>) request.getAttribute("allSalas");
                if (rows != null) {
                    for (sgs.Sala row : rows) { %>
                        <tr>
                            <!-- Row data... -->
                            <td id="codigo-<%= row.getCodigo() %>"><%= row.getCodigo() %></td>
                            <td id="localizacao-<%= row.getCodigo() %>"><%= row.getLocalizacao() %></td>
                            <td id="lotacao-<%= row.getCodigo() %>"><%= row.getLotacao() %></td>
                            <td>
                                <input style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="capacidade-<%= row.getCodigo() %>" type="number" value="<%= row.getCapacidade() %>" readonly>
                            </td>
                            <td class="buttons">
                                <button id="editButton-<%= row.getCodigo() %>" type="button" onclick="toggleEdit('<%= row.getCodigo() %>')">Edit</button>
                                    <input type="hidden" name="codigo" value="<%= row.getCodigo() %>">
                                <button type="button" onclick="confirmDelete('<%= row.getCodigo() %>')">Delete</button>
                            </td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='criarSala'">Criar Sala</button>
            <button onclick="window.history.back()">Voltar</button>
        </div>
    </body>
</html>
