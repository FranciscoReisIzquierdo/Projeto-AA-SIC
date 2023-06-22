/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.salaBeanLocal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
@WebServlet(name = "salaInit", urlPatterns = {"/salaInit"})
public class salaInit extends HttpServlet {

    @EJB
    private salaBeanLocal salaBean;

    @EJB
    private salaBeanLocal salaBeans;


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
        
        List<sgs.Sala> allSalas = salaBean.getAllSalas();
            List<String> allSalasCodigos = new ArrayList<>();
            for(sgs.Sala sala : allSalas) allSalasCodigos.add(sala.getCodigo());
            request.setAttribute("allSalasCodigos", allSalasCodigos);
        
        request.getRequestDispatcher("/WEB-INF/salaInit.jsp").forward(request, response);
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
            throws ServletException, IOException{
        String codSala = request.getParameter("text");
        HttpSession session = request.getSession();
        
        if(salaBeans.isValid(codSala)){
            session.setAttribute("codSala", codSala);
            response.sendRedirect(request.getContextPath() + "/salaInfo");
        }
        else{
            session.setAttribute("errorMessage", "Código " + codSala + " de sala inválido");
            response.sendRedirect(request.getContextPath() + "/salaInit");
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
