/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: WildFly Full 18.0.1.Final (WildFly Core 10.0.3.Final) - 2.0.27.Final
 * Generated at: 2023-06-22 16:26:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class conferenciaManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JBWEB004248: JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      response.addHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Gestão de Confêrencias</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: #fff;\n");
      out.write("                padding: 20px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .header h1 {\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .main-menu {\n");
      out.write("                text-align: left;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .main-menu a {\n");
      out.write("                color: #333;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .table-container {\n");
      out.write("                width: 80%;\n");
      out.write("                margin: 0 auto;\n");
      out.write("                overflow-y: auto;\n");
      out.write("                max-height: 75vh;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .data-table {\n");
      out.write("                width: 100%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                word-wrap: break-word;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .data-table th,\n");
      out.write("            .data-table td {\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                transition: width 3.3s ease-in-out;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .data-table th {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: #fff;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .data-table td.buttons {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .data-table td.buttons button {\n");
      out.write("                margin-right: 5px;\n");
      out.write("                padding: 5px 10px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: #fff;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: background-color 0.3s;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input{\n");
      out.write("                height: 15px;\n");
      out.write("                width: 100%;\n");
      out.write("                max-width: 100%;\n");
      out.write("                overflow-x: hidden;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table {\n");
      out.write("                width: 100%;\n");
      out.write("                table-layout: fixed;\n");
      out.write("            }\n");
      out.write("            th, td {\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 8px;\n");
      out.write("                word-wrap: break-word;\n");
      out.write("                height: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .data-table td.buttons button:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .fixed-buttons {\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 20px;\n");
      out.write("                right: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .fixed-buttons button {\n");
      out.write("                margin-left: 10px;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 3px;\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: #fff;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: background-color 0.3s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .fixed-buttons button:hover {\n");
      out.write("                background-color: #45a049;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input:focus {\n");
      out.write("                outline: none;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[readonly] {\n");
      out.write("                pointer-events: none;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            select[disabled]{\n");
      out.write("                color: #333;\n");
      out.write("                opacity: 100%;\n");
      out.write("                cursor: not-allowed;\n");
      out.write("                pointer-events: none;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .data-table tr:nth-child(even) {\n");
      out.write("                background-color: #f9f9f9;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <script>\n");
      out.write("        function expandcolumn(id, size){\n");
      out.write("            document.getElementById(id).style.width=size;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function shrinkcolumn(id){\n");
      out.write("            document.getElementById(id).style.width=\"\";\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function confirmDelete(codigo) {\n");
      out.write("            var confirmation = confirm(\"Tem a certeza de que pretende eliminar a conferencia \" + codigo + \"?\");\n");
      out.write("            if (confirmation) {\n");
      out.write("                const url = window.location.href;\n");
      out.write("                console.log(url);\n");
      out.write("                fetch(url, {\n");
      out.write("                    method: 'POST',\n");
      out.write("                    headers: {\n");
      out.write("                        'Content-Type': 'application/json',\n");
      out.write("                        'JSESSIONID': '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.session.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\n");
      out.write("                    },\n");
      out.write("                    body: JSON.stringify(\"Delete//\" + codigo)\n");
      out.write("                })\n");
      out.write("                    .then(response => response.text())\n");
      out.write("                    .then(html => {\n");
      out.write("                        console.log(html);\n");
      out.write("                    })\n");
      out.write("                    .catch(error => {\n");
      out.write("                        // Handle network error\n");
      out.write("                        console.error('Network error:', error);\n");
      out.write("                    });\n");
      out.write("                location.reload();\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function toggleEdit(codigo) {\n");
      out.write("            var nomeElement = document.getElementById(\"nome-\" + codigo);\n");
      out.write("            var horainicioElement = document.getElementById(\"horaInicio-\" + codigo);\n");
      out.write("            var horafimElement = document.getElementById(\"horaFim-\" + codigo);\n");
      out.write("            var salaElement = document.getElementById(\"sala-\" + codigo);\n");
      out.write("            var entradaElement = document.getElementById(\"entrada-\" + codigo);\n");
      out.write("            var descricaoElement = document.getElementById(\"descricao-\" + codigo);\n");
      out.write("            var oradorElement = document.getElementById(\"orador-\" + codigo);\n");
      out.write("            var temaElement = document.getElementById(\"tema-\" + codigo);\n");
      out.write("            var editButton = document.getElementById(\"editButton-\" + codigo);\n");
      out.write("\n");
      out.write("            if (nomeElement.readOnly || horainicioElement.readOnly || horafimElement.readOnly || salaElement.disabled \n");
      out.write("                    || entradaElement.readOnly || descricaoElement.readOnly || oradorElement.readOnly || temaElement.readOnly) {\n");
      out.write("                nomeElement.readOnly = false;\n");
      out.write("                horainicioElement.readOnly = false;\n");
      out.write("                horafimElement.readOnly = false;\n");
      out.write("                salaElement.disabled = false;\n");
      out.write("                entradaElement.readOnly = false;\n");
      out.write("                descricaoElement.readOnly = false;\n");
      out.write("                oradorElement.readOnly = false;\n");
      out.write("                temaElement.readOnly = false;\n");
      out.write("                editButton.innerHTML = \"Submit\";\n");
      out.write("            } else {\n");
      out.write("                nomeElement.readOnly = true;\n");
      out.write("                horainicioElement.readOnly = true;\n");
      out.write("                horafimElement.readOnly = true;\n");
      out.write("                salaElement.disabled = true;\n");
      out.write("                entradaElement.readOnly = true;\n");
      out.write("                descricaoElement.readOnly = true;\n");
      out.write("                oradorElement.readOnly = true;\n");
      out.write("                temaElement.readOnly = true;\n");
      out.write("                editButton.innerHTML = \"Edit\";\n");
      out.write("                submitChanges(codigo, nomeElement.value, horainicioElement.value, horafimElement.value, salaElement.value, entradaElement.checked,\n");
      out.write("                    descricaoElement.value, oradorElement.value, temaElement.value);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        function submitChanges(codigo, nome, horainicio, horafim, sala, entrada, descricao, orador, tema) {\n");
      out.write("            horainicio = new Date(horainicio).getTime();\n");
      out.write("            horafim = new Date(horafim).getTime();\n");
      out.write("            if(entrada) entrada = \"true\";\n");
      out.write("            else entrada = \"false\";\n");
      out.write("            const url = window.location.href; // Get the current URL\n");
      out.write("            const data = \"Edit//\" + codigo + \"//\" + nome + \"//\" + horainicio + \"//\" + horafim + \n");
      out.write("                    \"//\" + sala + \"//\" + entrada + \"//\" + descricao + \"//\" + orador + \"//\" + tema;\n");
      out.write("            console.log(data)\n");
      out.write("            fetch(url, {\n");
      out.write("              method: 'POST',\n");
      out.write("              headers: {\n");
      out.write("                'Content-Type': 'application/json',\n");
      out.write("                'JSESSIONID': '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.session.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\n");
      out.write("              },\n");
      out.write("              body: JSON.stringify(data)\n");
      out.write("            })\n");
      out.write("            .then(response => response.text())\n");
      out.write("            .then(message => { console.log(message);\n");
      out.write("        \n");
      out.write("                if(message === \"true\\n\")\n");
      out.write("                    document.getElementById(\"confirmMessage\").textContent = \"Conferencia \" + codigo + \" editada com sucesso!\";\n");
      out.write("                else document.getElementById(\"errorMessage\").textContent = message;\n");
      out.write("                setTimeout(function(){\n");
      out.write("                document.getElementById(\"errorMessage\").textContent = \"\";\n");
      out.write("                location.reload();\n");
      out.write("                document.getElementById(\"confirmMessage\").textContent = \"\";\n");
      out.write("                }, 3000);\n");
      out.write("            })\n");
      out.write("            .catch(error => {\n");
      out.write("              // Handle network error\n");
      out.write("              console.error('Network error:', error);\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function confirmMessage(codigo){\n");
      out.write("            document.getElementById(\"confirmMessage\").textContent = \"Conferencia \" + codigo + \" criada com sucesso!\";\n");
      out.write("            setTimeout(function(){\n");
      out.write("                document.getElementById(\"confirmMessage\").textContent = \"\";\n");
      out.write("            }, 3000);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    <body>\n");
      out.write("        <button style=\"position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\" onclick=\"window.location.href='login'\">Logout</button>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <h1>Gestão de Conferências</h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main-menu\">\n");
      out.write("            <a href=\"adminMainMenu\" style=\"margin-left:15px\">Menu Principal</a> > Gestão de Conferências\n");
      out.write("        </div>\n");
      out.write("        <p id= \"confirmMessage\" style=\"width: 100%; text-align: center; color: green\"> </p>\n");
      out.write("        ");
 if (session.getAttribute("createdConferencia") != null) {
            out.println("<script>confirmMessage('" + session.getAttribute("createdConferencia") + "');</script>");
            session.setAttribute("createdConferencia", null);
            }
        
      out.write("\n");
      out.write("        <p id= \"errorMessage\" style=\"width: 100%; text-align: center; color: red\"> </p>\n");
      out.write("        <div class=\"table-container\">\n");
      out.write("            <table class=\"data-table\">\n");
      out.write("                <tr>\n");
      out.write("                    <th id=\"columncodigo\">Codigo</th>\n");
      out.write("                    <th id=\"columnname\">Nome</th>\n");
      out.write("                    <th id=\"columnhorainicio\">Dia/Hora de Inicio</th>\n");
      out.write("                    <th id=\"columnhorafim\">Dia/Hora de Fim</th>\n");
      out.write("                    <th>Sala</th>\n");
      out.write("                    <th>Entrada Livre</th>\n");
      out.write("                    <th>Descrição</th>\n");
      out.write("                    <th id=\"columnorador\">Orador</th>\n");
      out.write("                    <th id=\"columntema\">Tema</th>\n");
      out.write("                    <th style=\"width:150px\">Ações</th>\n");
      out.write("                </tr>\n");
      out.write("                ");
 List<sgs.Conferencia> rows = (List<sgs.Conferencia>) request.getAttribute("allConferencias");
                if (rows != null) {
                    for (sgs.Conferencia row : rows) { 
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <!-- Row data... -->\n");
      out.write("                            <td onmouseover=\"expandcolumn('columncodigo', '200px');\" onmouseout=\"shrinkcolumn('columncodigo');\" id=\"codigo-");
      out.print( row.getCodigo() );
      out.write('"');
      out.write('>');
      out.print( row.getCodigo() );
      out.write("</td>\n");
      out.write("                            <td onmouseover=\"expandcolumn('columnname', '350px');\" onmouseout=\"shrinkcolumn('columnname');\">\n");
      out.write("                                <input class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"nome-");
      out.print( row.getCodigo() );
      out.write("\" type=\"text\" value=\"");
      out.print( row.getNome() );
      out.write("\" readonly>\n");
      out.write("                            </td>\n");
      out.write("                            <td onmouseover=\"expandcolumn('columnhorainicio', '200px');\" onmouseout=\"shrinkcolumn('columnhorainicio');\">\n");
      out.write("                                ");
 
                                    java.util.Date dateInicio = new java.util.Date(row.getHoraInicio());
                                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                                    String formattedDateInicio = sdf.format(dateInicio);  
                                
      out.write("\n");
      out.write("                                <input class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"horaInicio-");
      out.print( row.getCodigo() );
      out.write("\" type=\"datetime-local\" value=\"");
      out.print( formattedDateInicio );
      out.write("\" readonly>\n");
      out.write("                            </td>\n");
      out.write("                            <td onmouseover=\"expandcolumn('columnhorafim', '200px');\" onmouseout=\"shrinkcolumn('columnhorafim');\">\n");
      out.write("                                ");
 
                                    java.util.Date date = new java.util.Date(row.getHoraFim());
                                    String formattedDate = sdf.format(date);  
                                
      out.write("\n");
      out.write("                                <input class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"horaFim-");
      out.print( row.getCodigo() );
      out.write("\" type=\"datetime-local\" value=\"");
      out.print( formattedDate );
      out.write("\" readonly>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <select class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"sala-");
      out.print( row.getCodigo() );
      out.write("\" disabled>\n");
      out.write("                                    ");
 
                                    List<String> dropdownSalaOptions = (List<String>) request.getAttribute("allSalasCodigos");
                                    if (dropdownSalaOptions != null) {
                                        for (String option : dropdownSalaOptions) {
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( option );
      out.write('"');
if(row.sala.getCodigo().equals(option)) out.print("selected"); 
      out.write('>');
      out.print( option );
      out.write("</option>\n");
      out.write("                                    ");
 
                                        }
                                    }
                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"entrada-");
      out.print( row.getCodigo() );
      out.write("\" type=\"checkbox\" ");
      out.print( row.getLivre() ? "checked" : "unchecked" );
      out.write(" readonly>\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                                <input class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"descricao-");
      out.print( row.getCodigo() );
      out.write("\" type=\"text\" value=\"");
      out.print( row.getDescrição() );
      out.write("\" readonly>\n");
      out.write("                            </td>\n");
      out.write("                            <td onmouseover=\"expandcolumn('columnorador', '400px');\" onmouseout=\"shrinkcolumn('columnorador');\">\n");
      out.write("                                <input class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"orador-");
      out.print( row.getCodigo() );
      out.write("\" type=\"text\" value=\"");
      out.print( row.getOrador() );
      out.write("\" readonly>\n");
      out.write("                            </td>\n");
      out.write("                            <td onmouseover=\"expandcolumn('columntema', '300px');\" onmouseout=\"shrinkcolumn('columntema');\">\n");
      out.write("                                <input class=\"cell-content\" style=\"background: transparent;border: none;font-family: Arial, sans-serif; font-size: 16px\" id=\"tema-");
      out.print( row.getCodigo() );
      out.write("\" type=\"text\" value=\"");
      out.print( row.getTema() );
      out.write("\" readonly>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width:150px\" class=\"buttons\">\n");
      out.write("                                ");

                                    if(session.getAttribute("currentTime")!= null && row.getHoraInicio() > (long) session.getAttribute("currentTime")){
                                
      out.write("\n");
      out.write("                                <button id=\"editButton-");
      out.print( row.getCodigo() );
      out.write("\" type=\"button\" onclick=\"toggleEdit('");
      out.print( row.getCodigo() );
      out.write("')\">Edit</button>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                                <input type=\"hidden\" name=\"codigo\" value=\"");
      out.print( row.getCodigo() );
      out.write("\">\n");
      out.write("                                <button style=\"background-color: red; color: #fff\" type=\"button\" onclick=\"confirmDelete('");
      out.print( row.getCodigo() );
      out.write("')\">Delete</button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    ");
 }
                } 
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"fixed-buttons\">\n");
      out.write("            <button onclick=\"window.location.href='criarConferencia'\">Criar Conferencia</button>\n");
      out.write("            <button style=\"background-color: #ccc; color: #fff\" onclick=\"window.location.href='adminMainMenu'\">Voltar</button>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}