<%-- 
    Document   : criarDisciplina
    Created on : 16/06/2023, 19:04:53
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Curso</title>
        <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 4px;
        }

        .title {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin: 0;
        }

        .breadcrumb {
            margin-top: 10px;
            font-size: 14px;
            color: #666;
        }

        .form-container {
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .form-input {
            width: 300px;
            padding: 8px;
            font-size: 14px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            color: #666;
        }
        
        .form-select {
            width: 319px;
            padding: 8px;
            font-size: 14px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            color: #666;
        }

        .form-buttons {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }

        .form-buttons button {
            padding: 8px 16px;
            font-size: 14px;
            margin-right: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .cancel-button {
            background-color: #ccc;
            color: #fff
        }

        .create-button {
            background-color: #4CAF50;
            color: #fff;
        }
        
        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 10px;
          }

          label {
            font-weight: bold;
          }

          input[type="checkbox"] {
            margin-top: 5px;
    }
    </style>
    </head>
    <body>
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="container">
            <h1 class="title">Criar Disciplina</h1>
            <a href="adminMainMenu">Menu Principal</a> > <a href="disciplinaManager">Gestão de Disciplinas</a> > Criar Disciplina
            <p style="color: red" id="errorMessage"> </p>
            <div class="form-container">
                <form id="createDisciplinaForm">
                    <div class="form-group">
                        <label for="codigo">Código</label>
                        <input id=codigo" type="text" name="codigo" class="form-input">
                    </div>
                    <div class="form-group">
                        <label for="nome">Nome</label>
                        <input id=nome" type="text" name="nome" class="form-input">
                    </div>
                    <div class="form-group">
                        <label for="curso">Curso</label>
                        <select id="curso" name="curso" class="form-select">
                            <% 
                                List<String> dropdownCursoOptions = (List<String>) request.getAttribute("allCursosCodigos");
                                if (dropdownCursoOptions != null) {
                                    for (String option : dropdownCursoOptions) {
                                %>
                                <option value="<%= option %>"><%= option %></option>
                                <% 
                                    }
                                }
                                %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="docente">Docente</label>
                        <select id="docente" name="docente" class="form-select">
                            <% 
                                List<String> dropdownDocOptions = (List<String>) request.getAttribute("allDocentesEmails");
                                if (dropdownDocOptions != null) {
                                    for (String option : dropdownDocOptions) {
                                %>
                                <option value="<%= option %>"><%= option %></option>
                                <% 
                                    }
                                }
                                %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descricao</label>
                        <input id=descricao" type="text" name="descricao" class="form-input">
                    </div>
                    <div class="form-group">
                        <label for="carga">Carga Horaria</label>
                        <input id=carga" type="number" name="carga" class="form-input">
                    </div>
                    <div class="form-buttons">
                        <button class="cancel-button" type="button" onclick="goBack()">Cancelar</button>
                        <button class="create-button" type="button" onclick="createDiscp()">Criar</button>
                    </div>
                </form>
            </div>
        </div>

        <script>
            function goBack() {
                window.location.href = 'disciplinaManager';
            }

            function createDiscp() {
                var form = document.getElementById("createDisciplinaForm");
                var formData = new FormData(form);

                var codigo = formData.get("codigo");
                var nome = formData.get("nome");
                var curso = formData.get("curso");
                var docente = formData.get("docente");
                var descricao = formData.get("descricao");
                var carga = formData.get("carga");

                var dataString = codigo + "//" + nome + "//" + curso + "//" + docente + "//" + descricao + "//" + carga;
                const url = window.location.href;
                if(!dataString.split("//").some(element => element === "NaN" || element === "")){
                    fetch(url, {
                        method: 'POST',
                        headers: {
                          'Content-Type': 'application/json',
                          'JSESSIONID': '${pageContext.session.id}'
                        },
                        body: JSON.stringify(dataString)
                      })
                      .then(response => response.text())
                      .then(isValid => {
                          if(isValid === "true\n") goBack();
                          else{
                              var errorMessage = document.getElementById("errorMessage");
                              errorMessage.textContent = "Erro ao criar disciplina. " + isValid;
                          }
                        })
                      .catch(error => {
                        // Handle network error
                        console.error('Network error:', error);
                      });
                    }
                    else{
                        var errorMessage = document.getElementById("errorMessage");
                        errorMessage.textContent = "Erro ao criar disciplina. Um ou mais campos em falta"
                    }
                }
        </script>
    </body>
</html>
