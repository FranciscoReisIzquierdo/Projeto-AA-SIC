<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="60">
    <title>Sala Info Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f2f2f2;
        }

        .container {
            width: 80%;
            max-width: 800px;
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: relative;
        }

        .title {
            font-size: 28px;
            font-weight: bold;
            margin: 0;
        }

        .paragraph {
            font-size: 18px;
            color: #555;
            margin: 10px 0;
        }

        .separation-line {
            margin-top: 20px;
            border-top: 1px solid #ccc;
        }

        .info {
            margin-top: 30px;
            font-size: 18px;
        }

        .info-title {
            font-weight: bold;
            font-size: 20px;
            text-align: center;
            margin: 0;
            padding: 10px 0;
            border-top: 1px solid #000;
            border-bottom: 1px solid #000;
            color: #000;
        }

        .info-list {
            padding-left: 20px;
            list-style-type: none;
        }

        .info-list li:nth-child(odd) {
            background-color: #f2f2f2;
            padding: 10px 0;
        }

        .lotacao {
            font-size: 18px;
            position: absolute;
            top: 20px;
            right: 20px;
        }

        .bottom-right-section {
            margin-top: 20px;
            display: flex;
            align-items: center;
            justify-content: flex-end;
        }

        .bottom-right-section input[type="text"] {
            padding: 8px;
            font-size: 16px;
            margin-right: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .bottom-right-section input[type="submit"] {
            padding: 8px 16px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .green {
            background: green;
        }

        .red {
            background: red;
        }
    </style>
    <script>
        // Function to change the body color to green for 2 seconds
        function Granted() {
            document.body.classList.add("green");
            setTimeout(function () {
                document.body.classList.remove("green");
            }, 700);
        }

        function Denied() {
            document.body.classList.add("red");
            setTimeout(function () {
                document.body.classList.remove("red");
            }, 700);
        }
    </script>
</head>
<body>
<% if (session.getAttribute("Response") != null && session.getAttribute("Response").equals("True")) {
    session.setAttribute("Response", "null");
%>
<%
    out.println("<script>Granted();</script>");
%>
<% } else if(session.getAttribute("Response") != null && session.getAttribute("Response").equals("False")){
    session.setAttribute("Response", "null");
%>
<%
    out.println("<script>Denied();</script>");
%>
<% } %>
<div class="container">
    <div class="lotacao">Lotação: ${pageContext.request.getAttribute("Lotacao")}/${pageContext.request.getAttribute("Capacidade")}</div>
    <h1 class="title">Sala ${pageContext.request.getAttribute("Codigo")}</h1>
    <p class="paragraph">${pageContext.request.getAttribute("Localizacao")}</p>

    <div class="info">
        <h2 class="info-title">Informação</h2>
        <ul class="info-list">
            <%
            if (!request.getAttribute("type").equals("null")) {
            %>
            <li>Nome do Evento: ${pageContext.request.getAttribute("Nome")}</li>
            <% SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
               String inicio = dateFormat.format(new java.util.Date(Long.parseLong((String) request.getAttribute("HoraInicio"))));
               request.setAttribute("inicio", inicio);
               String fim = dateFormat.format(new java.util.Date(Long.parseLong((String) request.getAttribute("HoraFim"))));
               request.setAttribute("fim", fim);
            %>

            <li>Início: ${inicio}</li>
            <li>Fim: ${fim}</li>
            <%
            if (request.getAttribute("type").equals("Aula")) {
            %>
            <li>Disciplina: ${Disciplina}</li>
            <li>Curso: ${Curso}</li>
            <li>Docente: ${Docente}</li>
            <li>Turno: ${Turno}</li>
            <%
                }else{
            %>
            <li>Orador: ${Orador}</li>
            <li>Tema: ${Tema}</li>
            <li>${Entrada}</li>
            <li>Descrição: ${Descricao}</li>
            <%
                }
            %>
            <%
                } else {
            %>
            <p>
                Sem eventos agendados
            </p>
            <%
                }
            %>
        </ul>

    </div>

    <div class="bottom-right-section">
        <form action="" method="post">
            <input type="text" name="emailAluno" placeholder="Enter text">
            <input type="submit" value="Submit">
        </form>
    </div>
</div>
</body>
</html>