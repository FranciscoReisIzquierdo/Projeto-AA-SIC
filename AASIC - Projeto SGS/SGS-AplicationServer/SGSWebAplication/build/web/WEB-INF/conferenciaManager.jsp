<%-- 
    Document   : conferenciaManager
    Created on : 15/06/2023, 21:09:31
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
            var confirmation = confirm("Tem a certeza de que pretende eliminar a conferencia " + codigo + "?");
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
            var horainicioElement = document.getElementById("horaInicio-" + codigo);
            var horafimElement = document.getElementById("horaFim-" + codigo);
            var salaElement = document.getElementById("sala-" + codigo);
            var entradaElement = document.getElementById("entrada-" + codigo);
            var descricaoElement = document.getElementById("descricao-" + codigo);
            var oradorElement = document.getElementById("orador-" + codigo);
            var temaElement = document.getElementById("tema-" + codigo);
            var editButton = document.getElementById("editButton-" + codigo);

            if (nomeElement.readOnly || horainicioElement.readOnly || horafimElement.readOnly || salaElement.readOnly 
                    || entradaElement.readOnly || descricaoElement.readOnly || oradorElement.readOnly || temaElement.readOnly) {
                nomeElement.readOnly = false;
                horainicioElement.readOnly = false;
                horafimElement.readOnly = false;
                salaElement.readOnly = false;
                entradaElement.readOnly = false;
                descricaoElement.readOnly = false;
                oradorElement.readOnly = false;
                temaElement.readOnly = false;
                editButton.innerHTML = "Submit";
            } else {
                nomeElement.readOnly = true;
                horainicioElement.readOnly = true;
                horafimElement.readOnly = true;
                salaElement.readOnly = true;
                entradaElement.readOnly = true;
                descricaoElement.readOnly = true;
                oradorElement.readOnly = true;
                temaElement.readOnly = true;
                editButton.innerHTML = "Edit";
                submitChanges(codigo, nomeElement.value, horainicioElement.value, horafimElement.value, salaElement.value, entradaElement.value,
                    descricaoElement.value, oradorElement.value, temaElement.value);
            }
        }



        function submitChanges(codigo, nome, horainicio, horafim, sala, entrada, descricao, orador, tema) {
            const url = window.location.href; // Get the current URL
            const data = "Edit//" + codigo + "//" + nome + "//" + horainicio + "//" + horafim + 
                    "//" + sala + "//" + entrada + "//" + descricao + "//" + orador + "//" + tema;

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
            <h1>Gestão de Conferências</h1>
        </div>
        <div class="main-menu">
            <a href="adminMainMenu" style="margin-left:15px">Main Menu</a> > Gestão de Conferências
        </div>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Codigo</th>
                    <th onmouseover="this.style.width = '300px'" onmouseout="this.style.width = ''">Nome</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Dia/Hora de Inicio</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Dia/ Hora de Fim</th>
                    <th>Sala</th>
                    <th>Entrada</th>
                    <th>Descrição</th>
                    <th onmouseover="this.style.width = '250px'" onmouseout="this.style.width = ''">Orador</th>
                    <th onmouseover="this.style.width = '250px'" onmouseout="this.style.width = ''">Tema</th>
                    <th>Ações</th>
                </tr>
                <% List<sgs.Conferencia> rows = (List<sgs.Conferencia>) request.getAttribute("allConferencias");
                if (rows != null) {
                    for (sgs.Conferencia row : rows) { %>
                        <tr>
                            <!-- Row data... -->
                            <td id="codigo-<%= row.getCodigo() %>"><%= row.getCodigo() %></td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="nome-<%= row.getCodigo() %>" type="text" value="<%= row.getNome() %>" readonly>
                            </td>
                            <td>
                                <% 
                                    java.util.Date dateInicio = new java.util.Date(row.getHoraInicio());
                                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                                    String formattedDateInicio = sdf.format(dateInicio);  
                                %>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="horaInicio-<%= row.getCodigo() %>" type="datetime-local" value="<%= formattedDateInicio %>" readonly>
                            </td>
                            <td>
                                <% 
                                    java.util.Date date = new java.util.Date(row.getHoraFim());
                                    String formattedDate = sdf.format(date);  
                                %>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="horaFim-<%= row.getCodigo() %>" type="datetime-local" value="<%= formattedDate %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="sala-<%= row.getCodigo() %>" type="text" value="<%= row.getSala().getCodigo() != null ? row.getSala().getCodigo() : "Sem sala atribuida" %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="entrada-<%= row.getCodigo() %>" type="text" value="<%= row.getLivre() ? "Livre" : "Restrito" %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="descricao-<%= row.getCodigo() %>" type="text" value="<%= row.getDescrição() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="orador-<%= row.getCodigo() %>" type="text" value="<%= row.getOrador() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="tema-<%= row.getCodigo() %>" type="text" value="<%= row.getTema() %>" readonly>
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
            <button onclick="window.location.href='criarConferencia.jsp'">Criar Conferencia</button>
            <button onclick="window.history.back()">Voltar</button>
        </div>
    </body>
</html>