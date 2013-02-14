<%-- 
    Document   : cadastroMedico
    Created on : 10/02/2013, 14:37:44
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuarios" class="br.java.tp.bean.UsuariosBean" scope="session" />
<jsp:setProperty name="Usuarios" property="nome"/>
<jsp:setProperty name="Usuarios" property="login"/>
<jsp:setProperty name="Usuarios" property="senha"/>

<%
    String nome = request.getParameter("nome");
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    
    if(nome != null && login != null && senha != null){
        boolean status = Usuarios.cadastrarUsuarios();
        if(status){
            out.println("Cadastro realisado com sucesso!<br /><a href=\"home.jsp\">Voltar</a>");
        }else{
            out.println("Cadastro incorreto");
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
            <form action="cadastroUsuarios.jsp" method="POST">
                Nome: <input type="text" name="nome" /><br />
                Login: <input type="text" name="login" /><br />
                Senha: <input type="password" name="senha" /><br /><br />
                <input type="submit" value="Salvar" />
            </form>        
    </body>
</html>
