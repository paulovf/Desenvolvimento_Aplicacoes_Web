<%-- 
    Document   : index
    Created on : 09/02/2013, 19:11:39
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="Usuarios" class="br.java.tp.bean.UsuariosBean" scope="session" />
<jsp:setProperty name="Usuarios" property="login"/>
<jsp:setProperty name="Usuarios" property="senha"/>

<%
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    if(login != null){
        String retorno = Usuarios.validarUsuarios(login, senha);
        if(retorno == null){
            out.println("Login incorreto");
        }else{
            out.println(retorno + ", seja bem vindo!");
            response.sendRedirect("home.jsp");
        }        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <form action="index.jsp" method="POST">
                login: <input type="text" name="login" /><br />
                senha: <input type="password" name="senha" /><br /><br />
                <input type="submit" value="Logar" />
            </form>
    </body>
</html>
