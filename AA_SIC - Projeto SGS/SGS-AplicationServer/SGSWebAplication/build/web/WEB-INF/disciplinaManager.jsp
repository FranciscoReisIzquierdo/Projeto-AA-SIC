<%-- 
    Document   : disciplinaManager
    Created on : 15/06/2023, 13:08:33
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Disciplinas</title>
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
            
            select{
                width: 100%;
                text-align: center;
            }
            
            select[disabled]{
                color: #333;
                opacity: 100%;
                cursor: not-allowed;
                pointer-events: none;
                width: 100%;
                text-align: center;
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
                    .then(html => { console.log(html);
                        document.getElementById("confirmMessage").textContent = "Disciplina " + codigo + " eliminada com sucesso!";
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
            var cursoElement = document.getElementById("curso-" + codigo);
            var docenteElement = document.getElementById("docente-" + codigo);
            var cargaElement = document.getElementById("carga-" + codigo);
            var descricaoElement = document.getElementById("descricao-" + codigo);
            var editButton = document.getElementById("editButton-" + codigo);

            if (nomeElement.readOnly || cursoElement.disabled || docenteElement.disabled || cargaElement.readOnly 
                    || descricaoElement.readOnly) {
                nomeElement.readOnly = false;
                cursoElement.disabled = false;
                docenteElement.disabled = false;
                cargaElement.readOnly = false;
                descricaoElement.readOnly = false;
                editButton.innerHTML = "Submit";
            } else {
                nomeElement.readOnly = true;
                cursoElement.disabled = true;
                docenteElement.disabled = true;
                cargaElement.readOnly = true;
                descricaoElement.readOnly = true;
                editButton.innerHTML = "Edit";
                submitChanges(codigo, nomeElement.value, cursoElement.value, docenteElement.value, cargaElement.value, descricaoElement.value);
            }
        }

        function submitChanges(codigo, nome, curso, docente, carga, descricao) {
            const url = window.location.href; // Get the current URL
            const data = "Edit//" + codigo + "//" + nome + "//" + curso + "//" + docente + "//" + carga + "//" + descricao;
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
                document.getElementById("confirmMessage").textContent = "Disciplina " + codigo + " editada com sucesso!";
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
            document.getElementById("confirmMessage").textContent = "Disciplina " + codigo + " criada com sucesso!";
            setTimeout(function(){
                document.getElementById("confirmMessage").textContent = "";
            }, 3000);
        }
    </script>
    <body>
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="header">
            <h1>Gestão de Disciplinas</h1>
        </div>
        <div class="main-menu">
            <a href="adminMainMenu" style="margin-left:15px">Menu Principal</a> > Gestão de Disciplinas
        </div>
        <p id= "confirmMessage" style="width: 100%; text-align: center; color: green"> </p>
        <% if (session.getAttribute("createdDisciplina") != null) {
            out.println("<script>confirmMessage('" + session.getAttribute("createdDisciplina") + "');</script>");
            session.setAttribute("createdDisciplina", null);
            }
        %>
        <p id= "errorMessage" style="width: 100%; text-align: center; color: red"> </p>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Código</th>
                    <th id="columnname">Nome</th>
                    <th>Curso</th>
                    <th id="columndocente">Docente</th>
                    <th>Carga</th>
                    <th>Descrição</th>
                    <th>Ações</th>
                </tr>
                <% List<sgs.Disciplina> rows = (List<sgs.Disciplina>) request.getAttribute("allDisciplinas");
                if (rows != null) {
                    for (sgs.Disciplina row : rows) { %>
                        <tr>
                            <!-- Row data... -->
                            <td id="codigo-<%= row.getCodigo() %>"><%= row.getCodigo() %></td>
                            <td onmouseover="expandcolumn('columnname', '400px');" onmouseout="shrinkcolumn('columnname');">
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="nome-<%= row.getCodigo() %>" type="text" value="<%= row.getNome() %>" readonly>
                            </td>
                            <td>
                                <select class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="curso-<%= row.getCodigo() %>" disabled>
                                    <% 
                                    List<String> dropdownCursoOptions = (List<String>) request.getAttribute("allCursosCodigos");
                                    if (dropdownCursoOptions != null) {
                                        for (String option : dropdownCursoOptions) {
                                    %>
                                    <option value="<%= option %>"<%if(row.curso.getCodigo().equals(option)) out.print("selected"); %>><%= option %></option>
                                    <% 
                                        }
                                    }
                                    %>
                                </select>
                            </td>
                            <td onmouseover="expandcolumn('columndocente', '300px');" onmouseout="shrinkcolumn('columndocente');">
                                <select class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="docente-<%= row.getCodigo() %>" disabled>
                                    <% 
                                    List<String> dropdownDocOptions = (List<String>) request.getAttribute("allDocentesEmails");
                                    if (dropdownDocOptions != null) {
                                        for (String option : dropdownDocOptions) {
                                    %>
                                    <option value="<%= option %>"<%if(row.getDocente().getEmail().equals(option)) out.print("selected"); %>><%= option %></option>
                                    <% 
                                        }
                                    }
                                    %>
                                </select>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="carga-<%= row.getCodigo() %>" type="number" value="<%= row.getCargaHoraria() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="descricao-<%= row.getCodigo() %>" type="text" value="<%= row.getDescricao() %>" readonly>
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
            <button onclick="window.location.href='criarDisciplina'">Criar Disciplina</button>
            <button style="background-color: #ccc; color: #fff" onclick="window.location.href='adminMainMenu'">Voltar</button>
        </div>
    </body>
</html>
