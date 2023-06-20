<%-- 
    Document   : inscreveAulas
    Created on : 18/06/2023, 22:29:29
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrição em Aulas</title>
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
      function submitChanges(entrada, email, codigoDiscp) {
            const url = window.location.href; // Get the current URL
            var data;
            if(entrada.checked) data = "Inscreve//" + codigoDiscp + "//" + email;
            else{ data = "Desinscreve//" + codigoDiscp + "//" + email; }
            
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
            <h1>Inscrição em Aulas</h1>
        </div>
        <div class="main-menu">
            <a href="../adminMainMenu" style="margin-left:15px">Docente Main Menu</a> > Inscrição em Aulas
        </div>
        <p id= "confirmMessage" style="width: 100%; text-align: center; color: green"> </p>
        <p id= "errorMessage" style="width: 100%; text-align: center; color: red"> </p>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Inscrito</th>
                    <th>Email</th>
                    <th onmouseover="this.style.width = '350px'" onmouseout="this.style.width = ''">Nome</th>
                    <th>Idade</th>
                    <th>Numero</th>
                    <th>Genero</th>
                    <th>Curso</th>
                    <th>Ano</th>
                </tr>
                <% List<sgs.Aluno> rows = (List<sgs.Aluno>) request.getAttribute("allAlunos");
                sgs.Aula aula = (sgs.Aula) request.getAttribute("Aula");
                if (rows != null) {
                    for (sgs.Aluno row : rows) { %>
                    <script> console.log("<%=aula.getCodigo() %>"); </script>
                        <tr>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="entrada-<%= row.getEmail() %>" type="checkbox" <%= aula.inscritos.contains(row) ? "checked" : "unchecked" %> onchange="submitChanges(this, '<%=(String) row.getEmail()%>', '<%= aula.getCodigo() %>')">
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="nome-<%= row.getEmail() %>" type="text" value="<%= row.getEmail() %>" readonly>
                            </td>
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
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="curso-<%= row.getEmail() %>" type="text" value="<%= row.getCurso().getCodigo() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="ano-<%= row.getEmail() %>" type="number" value="<%= row.getAno() %>" readonly>
                            </td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='../adminMainMenu'">Voltar</button>
        </div>
    </body>
</html>
