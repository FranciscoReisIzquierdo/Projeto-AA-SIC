/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import beans.alunoBeanLocal;
import beans.cursoBeanLocal;
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
@WebServlet(name = "registerAluno", urlPatterns = {"/registerAluno"})
public class registerAluno extends HttpServlet {

    @EJB
    private cursoBeanLocal cursoBean;

    @EJB
    private alunoBeanLocal alunoBean;

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
        HttpSession session = request.getSession();
        
        List<sgs.Curso> allCursos = cursoBean.getAllCursos();
            List<String> allCursosCodigos = new ArrayList<>();
            for(sgs.Curso curso : allCursos) allCursosCodigos.add(curso.getCodigo());
            request.setAttribute("allCursosCodigos", allCursosCodigos);
        request.getRequestDispatcher("/WEB-INF/registerAluno.jsp").forward(request, response);
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

        List<String> json = getData(request);
        PrintWriter writer = response.getWriter();
        String isValid = alunoBean.createAluno(json.get(0), json.get(1), (json.get(2)),
                Integer.parseInt(json.get(3)), json.get(4), json.get(5).charAt(0), 
                Integer.parseInt(json.get(6)), json.get(7));
        writer.println(isValid);
        if(isValid.equals("true")){
            session.setAttribute("Type", "Aluno");
            session.setAttribute("Nome", json.get(1));
            session.setAttribute("Email", json.get(0));
            //response.sendRedirect(request.getContextPath() + "/alunoMainMenu");
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
