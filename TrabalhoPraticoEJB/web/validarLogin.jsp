<%-- 
    Document   : validarLogin
    Created on : 28/02/2013, 20:08:16
    Author     : paulo
--%>

<%@page import="br.java.tp.bean.UsuariosBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            if(login != null && senha != null){
                UsuariosBean usuario = new UsuariosBean();
                usuario.setLogin(login);
                usuario.setSenha(senha);
                if(usuario.obterUsuarios() == null){
                    out.println("Login ou senha invÃ¡lidos. <a href='java script:back()'>Voltar</a>");
                }else{
                    session.setAttribute("login", login);
                    session.setAttribute("senha", senha);
                    response.sendRedirect("home.jsp");
                }
            }else{
                out.println("Login ou senha invÃ¡lidos. <a href='java script:back()'>Voltar</a>");
            }
        %>
    </body>
</html>
