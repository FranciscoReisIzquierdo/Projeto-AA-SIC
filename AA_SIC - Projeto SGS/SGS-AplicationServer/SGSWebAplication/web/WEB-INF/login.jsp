<%-- 
    Document   : login
    Created on : 14/06/2023, 00:07:54
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Login</title>
        <style>
            body {
                background-color: #f2f2f2;
                font-family: Arial, sans-serif;
            }

            .container {
                width: 300px;
                margin: 0 auto;
                margin-top: 150px;
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
            }

            .container h2 {
                text-align: center;
            }

            .form-group {
                margin-bottom: 20px;
            }

            .form-group label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            .form-group input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
                box-sizing: border-box; 
            }

            .form-group input[type="submit"] {
                background-color: #4CAF50;
                color: #fff;
                cursor: pointer;
            }
            .register-link {
                text-align: center;
                margin-top: 10px;
            }
            .result-text {
                text-align: center;
                margin-top: 10px;
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Login</h2>
            <form action="" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="result-text">
                    <% if (session.getAttribute("ErrorMessage") != null) { %>
                        <%= session.getAttribute("ErrorMessage") %>
                        <% session.setAttribute("ErrorMessage", null);
                        } %>
                </div>
                <div class="form-group">
                    <input type="submit" value="Login">
                </div>
            </form>
            <div class="register-link">
                <a href="registerUtilizador">Registar Visitante</a>
            </div>
            <div class="register-link">
                <a href="registerAluno">Registar Aluno</a>
            </div>
        </div>
    </body>
</html>
