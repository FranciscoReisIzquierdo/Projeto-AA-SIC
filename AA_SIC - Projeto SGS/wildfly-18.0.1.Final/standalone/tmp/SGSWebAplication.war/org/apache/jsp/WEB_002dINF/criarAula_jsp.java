/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: WildFly Full 18.0.1.Final (WildFly Core 10.0.3.Final) - 2.0.27.Final
 * Generated at: 2023-06-22 20:23:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class criarAula_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Criar Aula</title>\n");
      out.write("        <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 20px;\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            max-width: 800px;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            background-color: #fff;\n");
      out.write("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 4px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .title {\n");
      out.write("            font-size: 24px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #333;\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .breadcrumb {\n");
      out.write("            margin-top: 10px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            color: #666;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-container {\n");
      out.write("            margin-top: 20px;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-input {\n");
      out.write("            width: 300px;\n");
      out.write("            padding: 8px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            color: #666;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .form-select {\n");
      out.write("            width: 319px;\n");
      out.write("            padding: 8px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            color: #666;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-buttons {\n");
      out.write("            margin-top: 20px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-buttons button {\n");
      out.write("            padding: 8px 16px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            margin-right: 10px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .cancel-button {\n");
      out.write("            background-color: #ccc;\n");
      out.write("            color: #fff\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .create-button {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .form-group {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("          font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"checkbox\"] {\n");
      out.write("          margin-top: 5px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <button style=\"position: fixed; top: 20px; right: 20px; padding: 12px; background-color: #ff0000; border: none; color: #fff; font-size: 16px; border-radius: 4px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\" onclick=\"window.location.href='login'\">Logout</button>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <h1 class=\"title\">Criar Aula</h1>\n");
      out.write("        <a href=\"adminMainMenu\">Menu Principal</a> > <a href=\"aulaManager\">Gestão de Aulas</a> > Criar Aulas\n");
      out.write("        <p style=\"color: red\" id=\"errorMessage\"></p>\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("            <form id=\"createAulaForm\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"horaInicio\">Data de Inicio:</label>\n");
      out.write("                    <input id=\"horaInicio\" type=\"datetime-local\" name=\"horaInicio\" class=\"form-input\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"horaFim\">Data de Fim:</label>\n");
      out.write("                    <input type=\"datetime-local\" name=\"horaFim\" class=\"form-input\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"codigo\">Código:</label>\n");
      out.write("                    <input type=\"text\" name=\"codigo\" class=\"form-input\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"nome\">Nome:</label>\n");
      out.write("                    <input type=\"text\" name=\"nome\" class=\"form-input\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"sala\">Sala:</label>\n");
      out.write("                    <select id=\"sala\" name=\"sala\" class=\"form-select\">\n");
      out.write("                        ");
 
                        List<String> dropdownSalaOptions = (List<String>) request.getAttribute("allSalasCodigos");
                        if (dropdownSalaOptions != null) {
                            for (String option : dropdownSalaOptions) {
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print( option );
      out.write('"');
      out.write('>');
      out.print( option );
      out.write("</option>\n");
      out.write("                        ");
 
                            }
                        }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"disciplina\">Disciplina</label>\n");
      out.write("                    <select id=\"disciplina\" name=\"disciplina\" class=\"form-select\">\n");
      out.write("                        ");
 
                        List<String> dropdownDiscpOptions = (List<String>) request.getAttribute("allDiscpCodigos");
                        if (dropdownDiscpOptions != null) {
                            for (String option : dropdownDiscpOptions) {
                        
      out.write("\n");
      out.write("                        <option value=\"");
      out.print( option );
      out.write('"');
      out.write('>');
      out.print( option );
      out.write("</option>\n");
      out.write("                        ");
 
                            }
                        }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"turno\">Turno</label>\n");
      out.write("                    <input type=\"text\" name=\"turno\" class=\"form-input\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-buttons\">\n");
      out.write("                    <button class=\"cancel-button\" type=\"button\" onclick=\"goBack()\">Cancelar</button>\n");
      out.write("                    <button class=\"create-button\" type=\"button\" onclick=\"createAula()\">Criar</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("        <script>\n");
      out.write("            function goBack() {\n");
      out.write("                window.location.href = 'aulaManager';\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function createAula() {\n");
      out.write("                var form = document.getElementById(\"createAulaForm\");\n");
      out.write("                var formData = new FormData(form);\n");
      out.write("                var codigo = formData.get(\"codigo\");\n");
      out.write("                var nome = formData.get(\"nome\");\n");
      out.write("                var sala = formData.get(\"sala\");\n");
      out.write("                var horaInicio = new Date(formData.get(\"horaInicio\")).getTime();\n");
      out.write("                var horaFim = new Date(formData.get(\"horaFim\")).getTime();\n");
      out.write("                var disciplina = formData.get(\"disciplina\");\n");
      out.write("                var turno = formData.get(\"turno\");\n");
      out.write("\n");
      out.write("                var dataString = codigo + \"//\" + nome + \"//\" + horaInicio + \"//\" + horaFim + \"//\" + sala + \"//\" + disciplina + \"//\" + turno;\n");
      out.write("                const url = window.location.href;\n");
      out.write("                if(!dataString.split(\"//\").some(element => element === \"NaN\" || element === \"\")){\n");
      out.write("                    fetch(url, {\n");
      out.write("                        method: 'POST',\n");
      out.write("                        headers: {\n");
      out.write("                          'Content-Type': 'application/json',\n");
      out.write("                          'JSESSIONID': '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.session.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\n");
      out.write("                        },\n");
      out.write("                        body: JSON.stringify(dataString)\n");
      out.write("                      })\n");
      out.write("                      .then(response => response.text())\n");
      out.write("                      .then(isValid => {\n");
      out.write("                          console.log(isValid);\n");
      out.write("                          if(isValid === \"true\\n\") goBack();\n");
      out.write("                          else{\n");
      out.write("                              var errorMessage = document.getElementById(\"errorMessage\");\n");
      out.write("                              errorMessage.textContent = \"Erro ao criar aula. \" + isValid;\n");
      out.write("                          }\n");
      out.write("                        })\n");
      out.write("                      .catch(error => {\n");
      out.write("                        // Handle network error\n");
      out.write("                        console.error('Network error:', error);\n");
      out.write("                      });\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                        var errorMessage = document.getElementById(\"errorMessage\");\n");
      out.write("                        errorMessage.textContent = \"Erro ao criar aula. Um ou mais campos em falta\";\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
