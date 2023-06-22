<%-- 
    Document   : criarAula
    Created on : 17/06/2023, 13:55:47
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Aula</title>
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
        <h1 class="title">Criar Aula</h1>
        <a href="adminMainMenu">Menu Principal</a> > <a href="aulaManager">Gestão de Aulas</a> > Criar Aulas
        <p style="color: red" id="errorMessage"></p>
        <div class="form-container">
            <form id="createAulaForm">
                <div class="form-group">
                    <label for="horaInicio">Data de Inicio:</label>
                    <input id="horaInicio" type="datetime-local" name="horaInicio" class="form-input">
                </div>

                <div class="form-group">
                    <label for="horaFim">Data de Fim:</label>
                    <input type="datetime-local" name="horaFim" class="form-input">
                </div>

                <div class="form-group">
                    <label for="codigo">Código:</label>
                    <input type="text" name="codigo" class="form-input">
                </div>

                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" class="form-input">
                </div>

                <div class="form-group">
                    <label for="sala">Sala:</label>
                    <select id="sala" name="sala" class="form-select">
                        <% 
                        List<String> dropdownSalaOptions = (List<String>) request.getAttribute("allSalasCodigos");
                        if (dropdownSalaOptions != null) {
                            for (String option : dropdownSalaOptions) {
                        %>
                        <option value="<%= option %>"><%= option %></option>
                        <% 
                            }
                        }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label for="disciplina">Disciplina</label>
                    <select id="disciplina" name="disciplina" class="form-select">
                        <% 
                        List<String> dropdownDiscpOptions = (List<String>) request.getAttribute("allDiscpCodigos");
                        if (dropdownDiscpOptions != null) {
                            for (String option : dropdownDiscpOptions) {
                        %>
                        <option value="<%= option %>"><%= option %></option>
                        <% 
                            }
                        }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label for="turno">Turno</label>
                    <input type="text" name="turno" class="form-input">
                </div>

                <div class="form-buttons">
                    <button class="cancel-button" type="button" onclick="goBack()">Cancelar</button>
                    <button class="create-button" type="button" onclick="createAula()">Criar</button>
                </div>
            </form>
        </div>
    </div>
        <script>
            function goBack() {
                window.location.href = 'aulaManager';
            }

            function createAula() {
                var form = document.getElementById("createAulaForm");
                var formData = new FormData(form);
                var codigo = formData.get("codigo");
                var nome = formData.get("nome");
                var sala = formData.get("sala");
                var horaInicio = new Date(formData.get("horaInicio")).getTime();
                var horaFim = new Date(formData.get("horaFim")).getTime();
                var disciplina = formData.get("disciplina");
                var turno = formData.get("turno");

                var dataString = codigo + "//" + nome + "//" + horaInicio + "//" + horaFim + "//" + sala + "//" + disciplina + "//" + turno;
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
                          console.log(isValid);
                          if(isValid === "true\n") goBack();
                          else{
                              var errorMessage = document.getElementById("errorMessage");
                              errorMessage.textContent = "Erro ao criar aula. " + isValid;
                          }
                        })
                      .catch(error => {
                        // Handle network error
                        console.error('Network error:', error);
                      });
                    }
                    else{
                        var errorMessage = document.getElementById("errorMessage");
                        errorMessage.textContent = "Erro ao criar aula. Um ou mais campos em falta";
                    }
                }
        </script>
    </body>
</html>

