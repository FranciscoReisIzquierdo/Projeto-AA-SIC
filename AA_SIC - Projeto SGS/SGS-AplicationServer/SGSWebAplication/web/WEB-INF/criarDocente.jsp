<%-- 
    Document   : criarDocente
    Created on : 16/06/2023, 16:37:01
    Author     : franc
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Docente</title>
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
            <h1 class="title">Criar Docente</h1>
            <a href="adminMainMenu">Menu Principal</a> > <a href="docenteManager">Gestão de Docentes</a> > Criar Docente
            <p style="color: red" id="errorMessage"> </p>
            <div class="form-container">
                <form id="createDocenteForm">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input id="email" type="text" name="email" class="form-input">
                    </div>
                    <div class="form-group">
                        <label for="email">Nome</label>
                        <input id="nome" type="text" name="nome" class="form-input">
                    </div>
                    <div class="form-group">
                        <label for="email">Idade</label>
                        <input id="idade" type="number" name="idade" class="form-input">
                    </div>   
                    <div class="form-group">
                        <label for="email">Numero/Identificador Mecanográfico</label>
                        <input id="numero" type="text" name="numero" class="form-input">
                    </div>
                    <div class="form-group">
                        <label for="email">Genero</label>
                        <select id="genero" name="genero" class="form-select">
                            <option value="M">M</option>
                            <option value="F">F</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="email">Departamento</label>
                        <input id="departamento" type="text" name="departamento" class="form-input">
                    </div>   
                    <div class="form-group">
                        <label for="email">Password</label>
                        <input id="senha" type="password" name="senha" class="form-input">
                    </div> 
                    <div class="form-buttons">
                        <button class="cancel-button" type="button" onclick="goBack()">Cancelar</button>
                        <button class="create-button" type="button" onclick="createCurso()">Criar</button>
                    </div>
                </form>
            </div>
        </div>

        <script>
            function goBack() {
                window.location.href = 'docenteManager';
            }

            function createCurso() {
                var form = document.getElementById("createDocenteForm");
                var formData = new FormData(form);

                var email = formData.get("email");
                var nome = formData.get("nome");
                var idade = formData.get("idade");
                var numero = formData.get("numero");
                var genero = formData.get("genero");
                var departamento = formData.get("departamento");
                var senha = formData.get("senha");


                var dataString = email + "//" + nome + "//" + idade + "//" + numero + "//" + senha + "//" + departamento + "//" + genero;
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
                              errorMessage.textContent = "Erro ao criar docente. Já existe um docente com o email " + email;
                          }
                        })
                      .catch(error => {
                        // Handle network error
                        console.error('Network error:', error);
                      });
                    }
                    else{
                        var errorMessage = document.getElementById("errorMessage");
                        errorMessage.textContent = "Erro ao criar docente. Um ou mais campos em falta";
                    }
                }
        </script>
    </body>
</html>
