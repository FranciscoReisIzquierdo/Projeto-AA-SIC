<%-- 
    Document   : registerAluno
    Created on : 18/06/2023, 19:14:44
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registar Aluno</title>
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
        <div class="container">
        <h1 class="title">Registar Aluno</h1>
        <a href="login">Login</a> >
        <p style="color: red" id="errorMessage"></p>
        <div class="form-container">
            <form id="registerUtilizadorForm">
                <div class="form-group">
                    <label for="codigo">Email:</label>
                    <input type="email" name="email" class="form-input" placeholder="Email" required>
                </div>
                <div class="form-group">
                    <label for="genero">Senha:</label>
                    <input type="password" name="senha" class="form-input" placeholder="Senha" required>
                </div>
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" class="form-input" placeholder="Nome" required>
                </div>

                <div class="form-group">
                    <label for="cartao">Cartão:</label>
                    <input type="text" name="cartao" class="form-input" placeholder="Cartao" required>
                </div>

                <div class="form-group">
                    <label for="idade">Idade:</label>
                    <input type="number" name="idade" class="form-input" placeholder="Idade" required>
                </div>

                <div class="form-group">
                    <label for="genero">Genero:</label>
                    <input type="text" name="genero" class="form-input" placeholder="Genero" required>
                </div>
                <div class="form-group">
                    <label for="ano">Ano:</label>
                    <input type="text" name="ano" class="form-input" placeholder="Ano" required>
                </div>
                
                <div class="form-group">
                    <label for="curso">Curso:</label>
                    <input type="text" name="curso" class="form-input" placeholder="Curso" required>
                </div>
                <div class="form-buttons">
                    <button class="cancel-button" type="button" onclick="goBack()">Cancelar</button>
                    <button class="create-button" type="button" onclick="registerUtilizador()">Registar</button>
                </div>
            </form>
        </div>
    </div>
        <script>
            function goBack() {
                window.location.href = 'login';
            }

            function registerUtilizador() {
                var form = document.getElementById("registerUtilizadorForm");
                var formData = new FormData(form);
                var email = formData.get("email");
                var nome = formData.get("nome");
                var senha = formData.get("senha");
                var idade = formData.get("idade");
                var cartao = formData.get("cartao");
                var genero = formData.get("genero");
                var ano = formData.get("ano");
                var curso = formData.get("curso");

                var dataString = email + "//" + nome + "//" + senha + "//" + idade + "//" + 
                        cartao + "//" + genero + "//" + ano + "//" + curso;
                const url = window.location.href;
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
                      if(isValid === "true\n") window.location.href = 'alunoMainMenu';
                      else{
                          var errorMessage = document.getElementById("errorMessage");
                          errorMessage.textContent = "Erro no registo. " + isValid;
                      }
                    })
                  .catch(error => {
                    // Handle network error
                    console.error('Network error:', error);
                  });
                }
        </script>
    </body>
</html>
