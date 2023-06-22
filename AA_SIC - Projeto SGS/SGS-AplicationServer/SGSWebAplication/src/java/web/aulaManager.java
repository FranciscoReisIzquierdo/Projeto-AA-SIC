/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import beans.aulaBeanLocal;
import beans.disciplinaBeanLocal;
import beans.salaBeanLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "aulaManager", urlPatterns = {"/aulaManager"})
public class aulaManager extends HttpServlet {

    @EJB
    private disciplinaBeanLocal disciplinaBean;

    @EJB
    private salaBeanLocal salaBean;

    @EJB
    private aulaBeanLocal aulaBean;

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
        if(session.getAttribute("Type")!= null && session.getAttribute("Type").equals("Administrador")){
            session.setAttribute("currentTime", System.currentTimeMillis());
            List<sgs.Aula> allAulas = aulaBean.getAllAulas();
            request.setAttribute("allAulas", allAulas);
            
            List<sgs.Sala> allSalas = salaBean.getAllSalas();
            List<String> allSalasCodigos = new ArrayList<>();
            for(sgs.Sala sala : allSalas) allSalasCodigos.add(sala.getCodigo());
            request.setAttribute("allSalasCodigos", allSalasCodigos);
            
            List<sgs.Disciplina> allDiscp = disciplinaBean.getAllDisciplinas();
            List<String> allDiscpCodigos = new ArrayList<>();
            for(sgs.Disciplina discp : allDiscp) allDiscpCodigos.add(discp.getCodigo());
            request.setAttribute("allDiscpCodigos", allDiscpCodigos);
            request.getRequestDispatcher("/WEB-INF/aulaManager.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("Type")!= null && session.getAttribute("Type").equals("Administrador")){
            
            List<String> json = getData(request);
            PrintWriter writer = response.getWriter();
            
            if(json.get(0).equals("Edit")){
                String message = aulaBean.updateAula(json.get(1), json.get(2), Long.parseLong(json.get(3)), Long.parseLong(json.get(4)),
                        json.get(5), json.get(6), json.get(7));
                writer.println(message);
            }
            else if(json.get(0).equals("Delete")) aulaBean.deleteAula(json.get(1));
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
