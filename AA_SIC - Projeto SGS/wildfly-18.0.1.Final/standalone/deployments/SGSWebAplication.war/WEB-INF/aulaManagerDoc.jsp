<%-- 
    Document   : aulaManagerDoc
    Created on : 18/06/2023, 13:19:11
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Aulas</title>
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
    <script>
        function confirmDelete(codigo) {
            var confirmation = confirm("Tem a certeza de que pretende eliminar a aula " + codigo + "?");
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
                    .then(html => { console.log(html);
                    document.getElementById("confirmMessage").textContent = "Aula " + codigo + " eliminada com sucesso!";
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
            var nomeElement = document.getElementById("nome-" + codigo);
            var horainicioElement = document.getElementById("horaInicio-" + codigo);
            var horafimElement = document.getElementById("horaFim-" + codigo);
            var salaElement = document.getElementById("sala-" + codigo);
            var disciplinaElement = document.getElementById("disciplina-" + codigo);
            var turnoElement = document.getElementById("turno-" + codigo);
            var editButton = document.getElementById("editButton-" + codigo);

            if (nomeElement.readOnly || horainicioElement.readOnly || horafimElement.readOnly || salaElement.readOnly 
                    || disciplinaElement.readOnly || turnoElement.readOnly) {
                nomeElement.readOnly = false;
                horainicioElement.readOnly = false;
                horafimElement.readOnly = false;
                salaElement.readOnly = false;
                disciplinaElement.readOnly = false;
                turnoElement.readOnly = false;
                editButton.innerHTML = "Submit";
            } else {
                nomeElement.readOnly = true;
                horainicioElement.readOnly = true;
                horafimElement.readOnly = true;
                salaElement.readOnly = true;
                disciplinaElement.readOnly = true;
                turnoElement.readOnly = true;
                editButton.innerHTML = "Edit";
                submitChanges(codigo, nomeElement.value, horainicioElement.value, horafimElement.value, salaElement.value,
                    disciplinaElement.value, turnoElement.value);
            }
        }



        function submitChanges(codigo, nome, horainicio, horafim, sala, disciplina, turno) {
            horainicio = new Date(horainicio).getTime();
            horafim = new Date(horafim).getTime();
            const url = window.location.href; // Get the current URL
            const data = "Edit//" + codigo + "//" + nome + "//" + horainicio + "//" + horafim + 
                    "//" + sala + "//" + disciplina + "//" + turno;
            
            fetch(url, {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
                'JSESSIONID': '${pageContext.session.id}'
              },
              body: JSON.stringify(data)
            })
            .then(response => response.text())
            .then(message => { console.log(message);
        
                if(message === "true\n")
                    document.getElementById("confirmMessage").textContent = "Aula " + codigo + " editada com sucesso!";
                else document.getElementById("errorMessage").textContent = message;
                setTimeout(function(){
                document.getElementById("errorMessage").textContent = "";
                location.reload();
                document.getElementById("confirmMessage").textContent = "";
                }, 3000);
            })
            .catch(error => {
              // Handle network error
              console.error('Network error:', error);
            });
        }
        
        function confirmMessage(codigo){
            document.getElementById("confirmMessage").textContent = "Aula " + codigo + " criada com sucesso!";
            setTimeout(function(){
                document.getElementById("confirmMessage").textContent = "";
            }, 3000);
        }
    </script>
    <body>
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="header">
            <h1>Consulta de Aulas</h1>
        </div>
        <div class="main-menu">
            <a href="docenteMainMenu" style="margin-left:15px">Main Menu</a> > Consulta de Aulas
        </div>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Codigo</th>
                    <th onmouseover="this.style.width = '300px'" onmouseout="this.style.width = ''">Nome</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Dia/Hora de Inicio</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Dia/Hora de Fim</th>
                    <th>Sala</th>
                    <th>Disciplina</th>
                    <th>Turno</th>
                    <th>Ações</th>
                </tr>
                <% List<sgs.Aula> rows = (List<sgs.Aula>) request.getAttribute("allAulas");
                if (rows != null) {
                    for (sgs.Aula row : rows) { %>
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
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="sala-<%= row.getCodigo() %>" type="text" value="<%= row.getSala() != null ? row.getSala().getCodigo() : "Sem sala atribuida" %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="disciplina-<%= row.getCodigo() %>" type="text" value="<%= row.getDisciplina().getCodigo() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="turno-<%= row.getCodigo() %>" type="text" value="<%= row.getTurno() %>" readonly>
                            </td>
                            <td class="buttons">
                                <%
                                    if(session.getAttribute("currentTime")!= null && row.getHoraInicio() <= (long) session.getAttribute("currentTime")){
                                %>
                                <button id="presencasButton-<%= row.getCodigo() %>" type="button" onclick="window.location.href='consultarPresencasDoc/?codAula=<%=row.getCodigo()%>'">Presenças</button>
                                <%
                                    }
                                %>
                                <input type="hidden" name="codigo" value="<%= row.getCodigo() %>">
                            </td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='docenteMainMenu'">Voltar</button>
        </div>
    </body>
</html>
