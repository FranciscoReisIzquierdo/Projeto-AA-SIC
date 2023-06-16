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
                //location.reload();
            }
        }

        function toggleEdit(codigo) {
            var nomeElement = document.getElementById("nome-" + codigo);
            var cursoElement = document.getElementById("curso-" + codigo);
            var docenteElement = document.getElementById("docente-" + codigo);
            var cargaElement = document.getElementById("carga-" + codigo);
            var descricaoElement = document.getElementById("descricao-" + codigo);
            var editButton = document.getElementById("editButton-" + codigo);

            if (nomeElement.readOnly || cursoElement.readOnly || docenteElement.readOnly || cargaElement.readOnly 
                    || descricaoElement.readOnly) {
                nomeElement.readOnly = false;
                cursoElement.readOnly = false;
                docenteElement.readOnly = false;
                cargaElement.readOnly = false;
                descricaoElement.readOnly = false;
                editButton.innerHTML = "Submit";
            } else {
                nomeElement.readOnly = true;
                cursoElement.readOnly = true;
                docenteElement.readOnly = true;
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
            .then(html => { console.log(html);})
            .catch(error => {
              // Handle network error
              console.error('Network error:', error);
            });
        }
    </script>
    <body>
        <div class="header">
            <h1>Gestão de Cursos</h1>
        </div>
        <div class="main-menu">
            <a href="adminMainMenu" style="margin-left:15px">Main Menu</a> > Gestão de Cursos
        </div>
        <div class="table-container">
            <table class="data-table">
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Curso</th>
                    <th>Docente</th>
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
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="nome-<%= row.getCodigo() %>" type="text" value="<%= row.getNome() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="curso-<%= row.getCodigo() %>" type="text" value="<%= row.getCurso().getCodigo() %>" readonly>
                            </td>
                            <td>
                                <input class="cell-content" style="background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px" id="docente-<%= row.getCodigo() %>" type="text" value="<%= row.getDocente()!= null ? row.getDocente().getEmail() : "Sem docente" %>" readonly>
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
                                <button type="button" onclick="confirmDelete('<%= row.getCodigo() %>')">Delete</button>
                            </td>
                        </tr>
                    <% }
                } %>
            </table>
        </div>
        <div class="fixed-buttons">
            <button onclick="window.location.href='criarDisciplina.jsp'">Criar Disciplina</button>
            <button onclick="window.history.back()">Voltar</button>
        </div>
    </body>
</html>