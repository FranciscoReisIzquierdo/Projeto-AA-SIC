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
            
            input{
                height: 15px;
                width: 100%;
                max-width: 100%;
                overflow-x: hidden;
                text-align: center;
            }
            
            th, td {
                text-align: center;
                padding: 8px;
                word-wrap: break-word;
                height: 15px;
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
            
            .data-table tr:nth-child(even) {
                background-color: #f9f9f9;
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
                  .then(html => { console.log(html);
                        document.getElementById("confirmMessage").textContent = "Sala " + codigo + " eliminada com sucesso!";
                        setTimeout(function(){
                        location.reload();
                        document.getElementById("confirmMessage").textContent = "";
                        }, 3000);
                    })
                  .catch(error => {
                    // Handle network error
                    console.error('Network error:', error);
                  });
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
            .then(html => { console.log(html);
                document.getElementById("confirmMessage").textContent = "Sala " + codigo + " editada com sucesso!";
                setTimeout(function(){
                    location.reload();
                    document.getElementById("confirmMessage").textContent = "";
                    }, 3000);
            })
            .catch(error => {
              // Handle network error
              console.error('Network error:', error);
            });
            //location.reload();
        }
        
        function confirmMessage(codigo){
            console.log(codigo);
            document.getElementById("confirmMessage").textContent = "Sala " + codigo + " criada com sucesso!";
            setTimeout(function(){
                document.getElementById("confirmMessage").textContent = "";
            }, 3000);
        }
    </script>
    <body>
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="header">
            <h1>Gestão de Salas</h1>
        </div>
        <div class="main-menu">
            <a href="adminMainMenu" style="margin-left:15px">Menu Principal</a> > Gestão de Salas
        </div>
        <p id= "confirmMessage" style="width: 100%; text-align: center; color: green"> </p>
        <% if (session.getAttribute("createdSala") != null) {
            out.println("<script>confirmMessage('" + session.getAttribute("createdSala") + "');</script>");
            session.setAttribute("createdSala", null);
            }
        %>
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
                                <button style="background-color: red; color: #fff" type="button" onclick="confirmDelete('<%= row.getCodigo() %>')">Delete</button>
                            </td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='criarSala'">Criar Sala</button>
            <button style="background-color: #ccc; color: #fff" onclick="window.location.href='adminMainMenu'">Voltar</button>
        </div>
    </body>
</html>
