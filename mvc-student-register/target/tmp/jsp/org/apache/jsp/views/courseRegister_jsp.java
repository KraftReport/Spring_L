/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/11.0.18
 * Generated at: 2024-02-14 07:02:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class courseRegister_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("jar:file:/C:/Users/KraftWork/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153361682000L));
    _jspx_dependants.put("file:/C:/Users/KraftWork/.m2/repository/org/springframework/spring-webmvc/6.1.3/spring-webmvc-6.1.3.jar", Long.valueOf(1704966249000L));
    _jspx_dependants.put("file:/C:/Users/KraftWork/.m2/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1153506114000L));
    _jspx_dependants.put("/views/header.jsp", Long.valueOf(1707853483388L));
    _jspx_dependants.put("jar:file:/C:/Users/KraftWork/.m2/repository/org/springframework/spring-webmvc/6.1.3/spring-webmvc-6.1.3.jar!/META-INF/spring-form.tld", Long.valueOf(1704940276000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fnobody;

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fnobody.release();
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("       <!--  <link rel=\"stylesheet\" href=\"views/css/test.css\"> -->\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"test.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\r\n");
      out.write("        crossorigin=\"anonymous\"></script>\r\n");
      out.write("    \r\n");
      out.write("        <title>Course Registration</title>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("        function displayDateTime() {\r\n");
      out.write("            var currentDate = new Date();\r\n");
      out.write("            var day = currentDate.getDate();\r\n");
      out.write("            var month = currentDate.getMonth() + 1; // Month is zero-based\r\n");
      out.write("            var year = currentDate.getFullYear();\r\n");
      out.write("            var hours = currentDate.getHours();\r\n");
      out.write("            var minutes = currentDate.getMinutes();\r\n");
      out.write("            var seconds = currentDate.getSeconds();\r\n");
      out.write("\r\n");
      out.write("            // Format the date and time as needed\r\n");
      out.write("            var formattedDateTime ='Current Date : '+ day + '/' + month + '/' + year;\r\n");
      out.write("\r\n");
      out.write("            // Display the formatted date and time in an HTML element\r\n");
      out.write("            document.getElementById('datetimeDisplay').innerHTML = formattedDateTime;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // Call the function when the page loads\r\n");
      out.write("        window.onload = displayDateTime;\r\n");
      out.write("        </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	 \r\n");
      out.write("\r\n");
      out.write("  <div id=\"testheader\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=row>        \r\n");
      out.write("            <div class=\"col-md-5 \">\r\n");
      out.write("        <a href=\"welcome.jsp\"><h3>Student Registration</h3></a>\r\n");
      out.write("    </div>  \r\n");
      out.write("    <div class=\"col-md-6\">  \r\n");
      out.write("        <p class=\"top text-dark\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.name}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write(':');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginUser.role}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" </p>\r\n");
      out.write("        <p class=\"top text-dark\" id=\"datetimeDisplay\"> </p>\r\n");
      out.write("    </div>  \r\n");
      out.write("    <div class=\"col-md-1\" >\r\n");
      out.write("        <a href=\"logout\"><input type=\"button\" class=\"btn-basic\" id=\"lgnout-button\" value=\"Log Out\"></a>\r\n");
      out.write("    </div>        \r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("    <!-- <div id=\"testsidebar\">Hello World </div> -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("    <div class=\"sidenav\">\r\n");
      out.write("        \r\n");
      out.write("        <button class=\"dropdown-btn\" > Class Management <i class=\"fa fa-caret-down\"></i></button>\r\n");
      out.write("        \r\n");
      out.write("            <div class=\"dropdown-container\">\r\n");
      out.write("      \r\n");
      out.write("          ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("       \r\n");
      out.write("          <a href=\"studentRegister\">Student Registration </a>\r\n");
      out.write("          <a href=\"studentManage\">Student Search </a>\r\n");
      out.write("          \r\n");
      out.write("        </div>\r\n");
      out.write("        <a href=\"userManage\">Users Management</a>\r\n");
      out.write("      </div>\r\n");
      out.write("       <div class=\"card-body\">\r\n");
      out.write("				 \r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("          </div>");
      out.write("\r\n");
      out.write("      <div class=\"main_contents\">\r\n");
      out.write("    <div id=\"sub_content\">\r\n");
      out.write("    \r\n");
      out.write("	 \r\n");
      out.write("    <form action=\"courseRegister\" method=\"post\">\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("        <h2 class=\"col-md-6 text-dark offset-md-2 mb-5 mt-4\">Course Registration</h2>\r\n");
      out.write("         \r\n");
      out.write("\r\n");
      out.write("        <div class=\"row mb-4\">\r\n");
      out.write("            <div class=\"col-md-2\"></div>\r\n");
      out.write("            <label for=\"name\" class=\"col-md-2 col-form-label text-dark\">Name</label>\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\"  name=\"name\" id=\"name\" required=\"required\" value=\"Java\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      \r\n");
      out.write("      <div class=\"row mb-4\">\r\n");
      out.write("            <div class=\"col-md-2\"></div>\r\n");
      out.write("            <label for=\"name\" class=\"col-md-2 col-form-label text-dark\">Status</label>\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                   <input type=\"text\" name=\"status\" class=\"form-control\" readonly=\"readonly\" value=\"open\" required=\"required\" />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      \r\n");
      out.write("       \r\n");
      out.write("        <div class=\"row mb-4\">\r\n");
      out.write("            <div class=\"col-md-4\"></div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("               \r\n");
      out.write("\r\n");
      out.write("                <button type=\"submit\" class=\"btn btn-secondary col-md-2\"  >Add</button>\r\n");
      out.write("                <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\"\r\n");
      out.write("                    aria-hidden=\"true\">\r\n");
      out.write("                    <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("                        <div class=\"modal-content\">\r\n");
      out.write("                            <div class=\"modal-header\">\r\n");
      out.write("                                <h5 class=\"modal-title\" id=\"exampleModalLabel\">Course Registration</h5>\r\n");
      out.write("                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"\r\n");
      out.write("                                    aria-label=\"Close\"></button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <h5 style=\"color: rgb(127, 209, 131);\">Registered Succesfully !</h5>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-footer\">\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-success col-md-2\" data-bs-dismiss=\"modal\">Ok</button>\r\n");
      out.write("                               \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("        <div id=\"testfooter\">\r\n");
      out.write("            <span>Copyright &#169; ACE Inspiration 2022</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script>\r\n");
      out.write("            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */\r\n");
      out.write("            var dropdown = document.getElementsByClassName(\"dropdown-btn\");\r\n");
      out.write("            var i;\r\n");
      out.write("            \r\n");
      out.write("            for (i = 0; i < dropdown.length; i++) {\r\n");
      out.write("              dropdown[i].addEventListener(\"click\", function() {\r\n");
      out.write("              this.classList.toggle(\"active\");\r\n");
      out.write("              var dropdownContent = this.nextElementSibling;\r\n");
      out.write("              if (dropdownContent.style.display === \"block\") {\r\n");
      out.write("              dropdownContent.style.display = \"none\";\r\n");
      out.write("              } else {\r\n");
      out.write("              dropdownContent.style.display = \"block\";\r\n");
      out.write("              }\r\n");
      out.write("              });\r\n");
      out.write("            }\r\n");
      out.write("            </script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html> ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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

  private boolean _jspx_meth_c_005fif_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /views/header.jsp(73,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.role == 'admin' }", boolean.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("          \r\n");
          out.write("          <a href=\"courseRegister\">Course Registration </a>\r\n");
          out.write("          <a href=\"courseManage\">Course Manage</a>\r\n");
          out.write("          ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /views/header.jsp(87,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty succMsg}", boolean.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<p class=\"text-center text-success\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${succMsg}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("					");
          if (_jspx_meth_c_005fremove_005f0(_jspx_th_c_005fif_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fremove_005f0(jakarta.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_005fremove_005f0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fnobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    boolean _jspx_th_c_005fremove_005f0_reused = false;
    try {
      _jspx_th_c_005fremove_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fremove_005f0.setParent((jakarta.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
      // /views/header.jsp(89,5) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f0.setVar("succMsg");
      int _jspx_eval_c_005fremove_005f0 = _jspx_th_c_005fremove_005f0.doStartTag();
      if (_jspx_th_c_005fremove_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fnobody.reuse(_jspx_th_c_005fremove_005f0);
      _jspx_th_c_005fremove_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fremove_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fremove_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /views/header.jsp(92,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty errorMsg}", boolean.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<p class=\"text-center text-success\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsg}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("					");
          if (_jspx_meth_c_005fremove_005f1(_jspx_th_c_005fif_005f2, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fremove_005f1(jakarta.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_005fremove_005f1 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fnobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    boolean _jspx_th_c_005fremove_005f1_reused = false;
    try {
      _jspx_th_c_005fremove_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fremove_005f1.setParent((jakarta.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
      // /views/header.jsp(94,5) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fremove_005f1.setVar("errorMsg");
      int _jspx_eval_c_005fremove_005f1 = _jspx_th_c_005fremove_005f1.doStartTag();
      if (_jspx_th_c_005fremove_005f1.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fremove_0026_005fvar_005fnobody.reuse(_jspx_th_c_005fremove_005f1);
      _jspx_th_c_005fremove_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fremove_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fremove_005f1_reused);
    }
    return false;
  }
}
