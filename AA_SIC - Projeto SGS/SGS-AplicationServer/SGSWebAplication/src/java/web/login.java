/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import beans.adminBeanLocal;
import beans.utilizadorBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
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

    @EJB
    private utilizadorBeanLocal utilizadorBean;

    @EJB
    private adminBeanLocal adminBean;

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
        HttpSession session = request.getSession(false);
        if(session != null) session.setAttribute("Type", null);
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
       
        String result = utilizadorBean.login(email, pass);
       
        
        if(result.equals("Email invalido")){
            result = adminBean.login(email, pass);
            if(result.equals("Administrador")){
                session.setAttribute("Type", result);
                response.sendRedirect(request.getContextPath() + "/adminMainMenu");
            }
            else{
                session.setAttribute("ErrorMessage", result);
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }
        else if(result.equals("Aluno")){
            String nome = utilizadorBean.getNome(email);
            session.setAttribute("Type", result);
            session.setAttribute("Nome", nome);
            session.setAttribute("Email", email);
            response.sendRedirect(request.getContextPath() + "/alunoMainMenu");
        }
        else if(result.equals("Docente")){
            String nome = utilizadorBean.getNome(email);
            session.setAttribute("Type", result);
            session.setAttribute("Nome", nome);
            session.setAttribute("Email", email);
            response.sendRedirect(request.getContextPath() + "/docenteMainMenu");
        }
        else if(result.equals("Utilizador")){
            String nome = utilizadorBean.getNome(email);
            session.setAttribute("Type", result);
            session.setAttribute("Nome", nome);
            session.setAttribute("Email", email);
            response.sendRedirect(request.getContextPath() + "/utilizadorMainMenu");
        }
        else{
            session.setAttribute("ErrorMessage", result);
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
