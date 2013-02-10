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
    if(request.getParameter("nome") != null){
        String retorno = Usuarios.validarUsuarios();
        if(retorno == null){
            out.println("Login incorreto");
        }else{
            out.println(retorno + ", seja bem vindo!");
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
                senha: <input type="text" name="senha" /><br /><br />
                <input type="submit" value="Logar" />
            </form>
    </body>
</html>
