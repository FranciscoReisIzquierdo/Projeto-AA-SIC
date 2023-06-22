<%-- 
    Document   : editarPerfilDocente
    Created on : 18/06/2023, 12:49:45
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
        <h1 class="title">Editar Docente</h1>
        <a href="docenteMainMenu">Menu Principal</a> > Editar Perfil
        <p style="color: red" id="errorMessage"></p>
        <div class="form-container">
            <%
                sgs.Docente docente = (sgs.Docente) session.getAttribute("Docente");
                %>
            <form id="registerUtilizadorForm">
                <div class="form-group">
                    <label for="codigo">Email</label>
                    <input type="email" name="email" value="<%= docente.getEmail() %>" class="form-input" readonly>
                </div>
                <div class="form-group">
                    <label for="genero">Senha</label>
                    <input type="password" name="senha" value="<%= docente.getSenha() %>" class="form-input" required>
                </div>
                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" value="<%= docente.getNome() %>" class="form-input" required>
                </div>

                <div class="form-group">
                    <label for="cartao">Numero/Identificador Mecanográfico</label>
                    <input type="text" name="cartao" value="<%= docente.getNumero() %>" class="form-input" required>
                </div>

                <div class="form-group">
                    <label for="idade">Idade</label>
                    <input type="number" name="idade" value="<%= docente.getIdade() %>" class="form-input" required>
                </div>

                <div class="form-group">
                    <label for="genero">Genero</label>
                    <select id="genero" name="genero" class="form-select">
                            <option value="M" <%if(docente.getGenero() == "M".charAt(0)) out.print("selected"); %>>M</option>
                            <option value="F" <%if(docente.getGenero() == "F".charAt(0)) out.print("selected"); %>>F</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="departamento">Departamento</label>
                    <input type="text" name="departamento" value="<%= docente.getDepartamento() %>" class="form-input" placeholder="Departamento" required>
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
                window.location.href = 'docenteMainMenu';
            }

            function editUtilizador(email) {
                var form = document.getElementById("registerUtilizadorForm");
                var formData = new FormData(form);
                var nome = formData.get("nome");
                var senha = formData.get("senha");
                var idade = formData.get("idade");
                var cartao = formData.get("cartao");
                var genero = formData.get("genero");
                var departamento = formData.get("departamento");

                var dataString = "Edit//" + email + "//" + nome + "//" + idade + "//" + cartao + "//" + senha 
                        + "//" + departamento + "//" + genero;
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
                          if(isValid === "true\n") window.location.href = 'docenteMainMenu';
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
                    else{
                        var errorMessage = document.getElementById("errorMessage");
                        errorMessage.textContent = "Erro ao editar perfil. Um ou mais campos em falta";
                    }
                }
        </script>
    </body>
</html>
