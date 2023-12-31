<%-- 
    Document   : inscreveDisciplinas
    Created on : 18/06/2023, 21:59:14
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrição em Disciplinas</title>
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
            
            .data-table tr:nth-child(even) {
                background-color: #f9f9f9;
            }
        </style>
    </head>
    <script>
        function expandcolumn(id, size){
            document.getElementById(id).style.width=size;
        }
        
        function shrinkcolumn(id){
            document.getElementById(id).style.width="";
        }
        
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
            <h1>Inscrição em Disciplinas</h1>
        </div>
        <div class="main-menu">
            <a href="alunoMainMenu" style="margin-left:15px">Menu Principal</a> > Inscrição em Disciplinas
        </div>
        <p id= "confirmMessage" style="width: 100%; text-align: center; color: green"> </p>
        <p id= "errorMessage" style="width: 100%; text-align: center; color: red"> </p>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Inscrito</th>
                    <th>Código</th>
                    <th id="columnnome">Nome</th>
                    <th>Curso</th>
                    <th id="columndocente">Docente</th>
                    <th>Carga</th>
                    <th>Descrição</th>
                </tr>
                <% List<sgs.Disciplina> rows = (List<sgs.Disciplina>) request.getAttribute("allDisciplinas");
                sgs.Aluno aluno = (sgs.Aluno) session.getAttribute("Aluno");
                if (rows != null) {
                    for (sgs.Disciplina row : rows) { %>
                        <tr>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="entrada-<%= row.getCodigo() %>" type="checkbox" <%= row.inscritos.contains(aluno) ? "checked" : "unchecked" %> onchange="submitChanges(this, '<%=(String) session.getAttribute("Email")%>', '<%= row.getCodigo() %>')">
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="nome-<%= row.getCodigo() %>" type="text" value="<%= row.getCodigo() %>" readonly>
                            </td>
                            <td onmouseover="expandcolumn('columnnome', '400px');" onmouseout="shrinkcolumn('columnnome');">
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="nome-<%= row.getCodigo() %>" type="text" value="<%= row.getNome() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="curso-<%= row.getCodigo() %>" type="text" value="<%= row.getCurso() != null ? row.getCurso().getCodigo() : "Sem curso" %>" readonly>
                            </td>
                            <td onmouseover="expandcolumn('columndocente', '200px');" onmouseout="shrinkcolumn('columndocente');">
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="docente-<%= row.getCodigo() %>" type="text" value="<%= row.getDocente()!= null ? row.getDocente().getEmail() : "Sem docente" %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="carga-<%= row.getCodigo() %>" type="number" value="<%= row.getCargaHoraria() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="descricao-<%= row.getCodigo() %>" type="text" value="<%= row.getDescricao() %>" readonly>
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
