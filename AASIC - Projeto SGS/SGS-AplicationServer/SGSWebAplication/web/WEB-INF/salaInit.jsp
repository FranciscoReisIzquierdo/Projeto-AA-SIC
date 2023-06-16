<%-- 
    Document   : salaInit
    Created on : 14/06/2023, 11:08:45
    Author     : franc
--%>
<%@ page language="java" %>
<%@ page import="java.io.*, java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sala</title>
        <style>
            .container {
              display: flex;
              justify-content: center;
              align-items: center;
              height: 100vh;
            }

            .input-container {
              text-align: center;
            }

            .input-container input[type="text"] {
              padding: 10px;
              font-size: 16px;
            }

            .input-container input[type="submit"] {
              padding: 10px 20px;
              font-size: 16px;
              background-color: #4CAF50;
              color: white;
              border: none;
              cursor: pointer;
            }
            .error-message {
            color: red;
            margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <body>
            <div class="container">
              <div class="input-container">
                <% String errorMessage = (String) session.getAttribute("errorMessage"); %>
                <% if (errorMessage != null) { %>
                    <div class="error-message"><%= errorMessage %></div>
                <% } %>  
                <form action="" method="post">
                  <input type="text" name="text" placeholder="Enter text" />
                  <br /><br />
                  <input type="submit" value="Submit" />
                </form>
              </div>
            </div>
    </body>
</html>
