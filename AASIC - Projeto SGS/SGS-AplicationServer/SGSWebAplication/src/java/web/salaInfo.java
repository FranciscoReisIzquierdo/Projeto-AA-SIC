/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sgs.Aula;
import sgs.Conferencia;

/**
 *
 * @author franc
 */
@WebServlet(name = "salaInfo", urlPatterns = {"/salaInfo"})
public class salaInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        Object codSala = session.getAttribute("codSala");
        sgs.SalaFunctions salaFunctions = new sgs.SalaFunctions();
        List<String> info = new ArrayList<>();
        info = salaFunctions.salaInfo((String) codSala);
        request.setAttribute("Codigo", info.get(0));
        request.setAttribute("Capacidade", info.get(1));
        request.setAttribute("Lotacao", info.get(2));
        request.setAttribute("Localizacao", info.get(3));
        
        if(info.size() == 4){
            request.setAttribute("type", "null");
            request.getRequestDispatcher("/WEB-INF/salaInfo.jsp").forward(request, response);
        }
        else if(info.get(7).equals("Aula")){
            request.setAttribute("type", "Aula");
            request.setAttribute("Disciplina", info.get(8));
            request.setAttribute("Curso", info.get(9));
            request.setAttribute("Docente", info.get(10));
            request.setAttribute("Turno", info.get(11));
        }
        else{
            request.setAttribute("type", "Conferencia");
            request.setAttribute("Orador", info.get(8));
            request.setAttribute("Tema", info.get(9));
            request.setAttribute("Descricao", info.get(10));
            request.setAttribute("Entrada", info.get(11));
        }
        request.setAttribute("Nome", info.get(4));
        request.setAttribute("HoraInicio", info.get(5));
        request.setAttribute("HoraFim", info.get(6));
        
        request.getRequestDispatcher("/WEB-INF/salaInfo.jsp").forward(request, response);
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
        String email = request.getParameter("emailAluno");
        HttpSession session = request.getSession(false);
        String codSala = (String) session.getAttribute("codSala");
        sgs.SalaFunctions salaFunctions = new sgs.SalaFunctions();
        
        if(salaFunctions.checkCartao(codSala, email)){
            session.setAttribute("Response", "True");
            response.sendRedirect(request.getContextPath() + "/salaInfo");
        }
        else{
            session.setAttribute("Response", "False");
            response.sendRedirect(request.getContextPath() + "/salaInfo");
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
