<%-- 
    Document   : salaInfo
    Created on : 14/06/2023, 12:04:01
    Author     : franc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="60">
        <title>Sala Info Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            .title {
                font-size: 24px;
                font-weight: bold;
            }

            .paragraph {
                margin-top: 10px;
                font-size: 16px;
            }

            .separation-line {
                margin-top: 20px;
                border-top: 1px solid #ccc;
            }

            .info {
                margin-top: 20px;
                font-size: 16px;
            }

            .info-title {
                font-weight: bold;
            }

            .right-section {
                position: absolute;
                top: 20px;
                right: 20px;
            }

            .lotacao {
                font-size: 16px;
            }

            .bottom-right-section {
                position: absolute;
                bottom: 20px;
                right: 20px;
                display: flex;
                align-items: center;
            }

            .bottom-right-section input[type="text"] {
                padding: 5px;
                font-size: 14px;
                margin-right: 10px;
            }

            .bottom-right-section input[type="submit"] {
                padding: 5px 10px;
                font-size: 14px;
                background-color: #4CAF50;
                color: white;
                border: none;
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
            setTimeout(function(){
                document.body.classList.remove("green");
            }, 700);
        }

        function Denied() {
            document.body.classList.add("red");
            setTimeout(function(){
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
            <h1 class="title">Sala ${pageContext.request.getAttribute("Codigo")}</h1>
            <p class="paragraph">${pageContext.request.getAttribute("Localizacao")}</p>
            <hr class="separation-line">

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
                    
                    <li>Inicio: ${inicio}</li>
                    <li>Fim: ${fim}</li>
                    <%
                    if (request.getAttribute("type").equals("Aula")) {
                    %>
                    <li>Disciplina: ${Disciplina}</li>
                    <li>Curso ${Curso}</li>
                    <li>Docente: ${Docente}</li>
                    <li>Turno ${Turno}</li>
                    <%
                        }else{
                    %>
                    <li>Orador: ${Orador}</li>
                    <li>Tema: ${Tema}</li>
                    <li>Descricao: ${Descricao}</li>
                    <li>${Entrada}</li>
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

            <div class="right-section">
                <div class="lotacao">Lotacao: ${pageContext.request.getAttribute("Lotacao")}/${pageContext.request.getAttribute("Capacidade")}</div>
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
