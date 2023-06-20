/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import beans.conferenciaBeanLocal;
import beans.utilizadorBeanLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
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
@WebServlet(name = "inscreveConferenciasDoc", urlPatterns = {"/inscreveConferenciasDoc"})
public class inscreveConferenciasDoc extends HttpServlet {
    
    @EJB
    private utilizadorBeanLocal utilizadorBean;
    
    @EJB
    private conferenciaBeanLocal conferenciaBean;

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
        if(session.getAttribute("Type")!= null && session.getAttribute("Type").equals("Docente")){
            sgs.Utilizador user = utilizadorBean.getUtilizador((String) session.getAttribute("Email"));
            session.setAttribute("Docente", user);
            List<sgs.Conferencia> allConf = conferenciaBean.getAllConfDisponiveis();
            request.setAttribute("allConferencias", allConf);
            request.getRequestDispatcher("/WEB-INF/inscreveConferenciasDoc.jsp").forward(request, response);
        }
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
        HttpSession session = request.getSession(false);
        if(session.getAttribute("Type")!= null && session.getAttribute("Type").equals("Docente")){
            
            List<String> json = getData(request);
            PrintWriter writer = response.getWriter();
            String message = "";
            if(json.get(0).equals("Inscreve")){
                message = conferenciaBean.inscreveConferencia(json.get(1), json.get(2));
                if(message.equals("true")) writer.println(message);
            }
            else if(json.get(0).equals("Desinscreve")){
                message = conferenciaBean.desinscreveConferencia(json.get(1), json.get(2));
                if(message.equals("false")) writer.println(message);
            }
        }
    }

    public List<String> getData(HttpServletRequest request){
        try{
            StringBuilder requestBody = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
            String str = requestBody.toString();
            str = str.substring(1, str.length() - 1);
            return Arrays.asList(str.split("//"));
        }
        catch(Exception e){
            return null;
        }
    }
}
