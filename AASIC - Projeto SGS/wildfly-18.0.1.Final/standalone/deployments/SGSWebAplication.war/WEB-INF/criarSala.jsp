<%-- 
    Document   : criarSala
    Created on : 16/06/2023, 00:50:22
    Author     : franc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Sala</title>
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
            color: #fff;
        }

        .create-button {
            background-color: #4CAF50;
            color: #fff;
        }
    </style>
    </head>
    <body>
        <div class="container">
            <h1 class="title">Criar Sala</h1>
            <div class="breadcrumb">Main Menu &gt; Gerir Salas &gt; Criar Sala</div>

            <div class="form-container">
                <form id="createRoomForm">
                    <input type="text" name="codigo" class="form-input" placeholder="Código">
                    <input type="text" name="localizacao" class="form-input" placeholder="Localização">
                    <input type="number" name="capacidade" class="form-input" placeholder="Capacidade">

                    <div class="form-buttons">
                        <button class="cancel-button" onclick="goBack()">Cancelar</button>
                        <button class="create-button" onclick="createRoom()">Criar</button>
                    </div>
                </form>
            </div>
        </div>

        <script>
            function goBack() {
                window.history.back();
            }

            function createRoom() {
                var form = document.getElementById("createRoomForm");
                var formData = new FormData(form);

                var codigo = formData.get("codigo");
                var localizacao = formData.get("localizacao");
                var capacidade = formData.get("capacidade");

                var dataString = codigo + "//" + localizacao + "//" + capacidade;
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
                  .then(html => { console.log(html);})
                  .catch(error => {
                    // Handle network error
                    console.error('Network error:', error);
                  });
                }
        </script>
    </body>
</html>
