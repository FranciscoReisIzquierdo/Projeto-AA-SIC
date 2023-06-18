<%-- 
    Document   : inscreveConferenciasAluno
    Created on : 18/06/2023, 20:35:56
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrição em Confêrencias</title>
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
      function submitChanges(entrada, email, codigoConf) {
            const url = window.location.href; // Get the current URL
            var data;
            if(entrada.checked) data = "Inscreve//" + codigoConf + "//" + email;
            else{ data = "Desinscreve//" + codigoConf + "//" + email; }
            
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
                    document.getElementById("confirmMessage").textContent = "Inscrição efetuada com sucesso!";
                else if(message === "false\n")
                    document.getElementById("confirmMessage").textContent = "Inscrição removida com sucesso!";
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
    </script>
    <body>
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="header">
            <h1>Inscrição em Conferências</h1>
        </div>
        <div class="main-menu">
            <a href="alunoMainMenu" style="margin-left:15px">Aluno Main Menu</a> > Inscrição em Conferências
        </div>
        <p id= "confirmMessage" style="width: 100%; text-align: center; color: green"> </p>
        <p id= "errorMessage" style="width: 100%; text-align: center; color: red"> </p>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Inscrito</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Codigo</th>
                    <th onmouseover="this.style.width = '300px'" onmouseout="this.style.width = ''">Nome</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Dia/Hora de Inicio</th>
                    <th onmouseover="this.style.width = '200px'" onmouseout="this.style.width = ''">Dia/ Hora de Fim</th>
                    <th>Sala</th>
                    <th>Descrição</th>
                    <th onmouseover="this.style.width = '250px'" onmouseout="this.style.width = ''">Orador</th>
                    <th onmouseover="this.style.width = '250px'" onmouseout="this.style.width = ''">Tema</th>
                </tr>
                <% List<sgs.Conferencia> rows = (List<sgs.Conferencia>) request.getAttribute("allConferencias");
                if (rows != null) {
                    for (sgs.Conferencia row : rows) { %>
                        <tr>
                            <% if(row.getLivre()) { %>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="entrada-<%= row.getCodigo() %>" type="text" value="Livre" readonly>
                            </td>
                            <% } else{ %>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="entrada-<%= row.getCodigo() %>" type="checkbox" <%= row.inscritos.contains((sgs.Utilizador) session.getAttribute("Aluno")) ? "checked" : "unchecked" %> onchange="submitChanges(this, '<%=(String) session.getAttribute("Email")%>', '<%= row.getCodigo() %>')">
                            </td>
                            <% } %>
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
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="descricao-<%= row.getCodigo() %>" type="text" value="<%= row.getDescrição() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="orador-<%= row.getCodigo() %>" type="text" value="<%= row.getOrador() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="tema-<%= row.getCodigo() %>" type="text" value="<%= row.getTema() %>" readonly>
                            </td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='alunoMainMenu'">Voltar</button>
        </div>
    </body>
</html>
