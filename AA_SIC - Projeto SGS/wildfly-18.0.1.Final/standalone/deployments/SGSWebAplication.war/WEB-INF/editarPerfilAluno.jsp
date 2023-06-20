<%-- 
    Document   : editarPerfilAluno
    Created on : 18/06/2023, 20:27:26
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Perfil</title>
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
        <button style="position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);" onclick="window.location.href='login'">Logout</button>
        <div class="container">
        <h1 class="title">Editar Aluno</h1>
        <a href="alunoMainMenu">Docente Main Menu</a> >
        <p style="color: red" id="errorMessage"></p>
        <div class="form-container">
            <%
                sgs.Aluno aluno = (sgs.Aluno) session.getAttribute("Aluno");
                %>
            <form id="registerUtilizadorForm">
                <div class="form-group">
                    <label for="codigo">Email:</label>
                    <input type="email" name="email" value="<%= aluno.getEmail() %>" class="form-input" placeholder="Email" readonly>
                </div>
                <div class="form-group">
                    <label for="genero">Senha:</label>
                    <input type="password" name="senha" value="<%= aluno.getSenha() %>" class="form-input" placeholder="Senha" required>
                </div>
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" value="<%= aluno.getNome() %>" class="form-input" placeholder="Nome" required>
                </div>

                <div class="form-group">
                    <label for="cartao">Cartão:</label>
                    <input type="text" name="cartao" value="<%= aluno.getNumero() %>" class="form-input" placeholder="Cartao" required>
                </div>

                <div class="form-group">
                    <label for="idade">Idade:</label>
                    <input type="number" name="idade" value="<%= aluno.getIdade() %>" class="form-input" placeholder="Idade" required>
                </div>

                <div class="form-group">
                    <label for="genero">Genero:</label>
                    <input type="text" name="genero" value="<%= aluno.getGenero() %>" class="form-input" placeholder="Genero" required>
                </div>
                <div class="form-group">
                    <label for="ano">Ano:</label>
                    <input type="number" name="ano" value="<%= aluno.getAno() %>" class="form-input" placeholder="Ano" required>
                </div>
                <div class="form-buttons">
                    <button class="cancel-button" type="button" onclick="goBack()">Cancelar</button>
                    <button class="create-button" type="button" onclick="editUtilizador('<%=session.getAttribute("Email")%>')">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
        <script>
            function goBack() {
                window.location.href = 'alunoMainMenu';
            }

            function editUtilizador(email) {
                var form = document.getElementById("registerUtilizadorForm");
                var formData = new FormData(form);
                var nome = formData.get("nome");
                var senha = formData.get("senha");
                var idade = formData.get("idade");
                var cartao = formData.get("cartao");
                var genero = formData.get("genero");
                var ano = formData.get("ano");

                var dataString = "Edit//" + email + "//" + nome + "//" + idade + "//" + cartao + "//" + senha 
                        + "//" + genero + "//" + ano;
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
                          errorMessage.textContent = "Erro ao editar perfil." + isValid;
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
