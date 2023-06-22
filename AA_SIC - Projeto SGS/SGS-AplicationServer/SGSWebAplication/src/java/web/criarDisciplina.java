/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import beans.cursoBeanLocal;
import beans.disciplinaBeanLocal;
import beans.docenteBeanLocal;
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
@WebServlet(name = "criarDisciplina", urlPatterns = {"/criarDisciplina"})
public class criarDisciplina extends HttpServlet {

    @EJB
    private docenteBeanLocal docenteBean;

    @EJB
    private cursoBeanLocal cursoBean;

    @EJB
    private disciplinaBeanLocal disciplinaBean;
    
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
            List<sgs.Curso> allCursos = cursoBean.getAllCursos();
            List<String> allCursosCodigos = new ArrayList<>();
            for(sgs.Curso curso : allCursos) allCursosCodigos.add(curso.getCodigo());
            request.setAttribute("allCursosCodigos", allCursosCodigos);
            
            List<sgs.Docente> allDocentes = docenteBean.getAllDocentes();
            List<String> allDocentesEmails = new ArrayList<>();
            for(sgs.Docente doc : allDocentes) allDocentesEmails.add(doc.getEmail());
            request.setAttribute("allDocentesEmails", allDocentesEmails);
            request.getRequestDispatcher("/WEB-INF/criarDisciplina.jsp").forward(request, response);
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
        if(session.getAttribute("Type")!= null && session.getAttribute("Type").equals("Administrador")){
            
            List<String> json = getData(request);
            PrintWriter writer = response.getWriter();
            String isValid = disciplinaBean.createDisciplina(json.get(0), json.get(1), json.get(2), json.get(3),
                    json.get(4), Integer.parseInt(json.get(5)));
            if(isValid.equals("true")) session.setAttribute("createdDisciplina", json.get(0));
            writer.println(isValid);
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
