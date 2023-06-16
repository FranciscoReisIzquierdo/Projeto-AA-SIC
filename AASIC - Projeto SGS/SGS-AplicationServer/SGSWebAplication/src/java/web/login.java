/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franc
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Object obj = "hello";
            request.setAttribute("obj", obj);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
            HttpSession session = request.getSession();
            Object username = null;
            //verificar login
            //session.setAttribute("username", username);
            //response.sendRedirect("welcome.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
       
        sgs.UtilizadorFunctions userFunctions = new sgs.UtilizadorFunctions();
        String result = userFunctions.login(email, pass);
        
        if(result .equals("Email invalido")){
            sgs.AdministradorFunctions adminFunctions = new sgs.AdministradorFunctions();
            result = adminFunctions.login(email, pass);
            if(result.equals("Administrador")){
                session.setAttribute("Type", result);
                response.sendRedirect(request.getContextPath() + "/adminMainMenu");
            }
            else{
                session.setAttribute("Type", result);
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }
        else if(result.equals("Aluno")){
            session.setAttribute("Type", result);
            response.sendRedirect(request.getContextPath() + "/alunoMainMenu");
        }
        else if(result.equals("Docente")){
            session.setAttribute("Type", result);
            response.sendRedirect(request.getContextPath() + "/docenteMainMenu");
        }
        else if(result.equals("Utilizador")){
            session.setAttribute("Type", result);
            response.sendRedirect(request.getContextPath() + "/utilizadorMainMenu");
        }
        else{
            session.setAttribute("Type", result);
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
