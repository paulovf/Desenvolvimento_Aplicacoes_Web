<%-- 
    Document   : cadastroMedico
    Created on : 10/02/2013, 14:37:44
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Medico" class="br.java.tp.bean.MedicoBean" scope="session" />
<jsp:setProperty name="Medico" property="nome"/>
<jsp:setProperty name="Medico" property="crm"/>
<jsp:setProperty name="Medico" property="idMedico"/>

<%
    String nome = request.getParameter("nome");
    String crm = request.getParameter("crm");
    
    if(nome != null && crm != null){
        boolean status = Medico.cadastrarMedico();
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
            <form action="cadastroMedico.jsp" method="POST">
                Nome: <input type="text" name="nome" /><br />
                CRM: <input type="text" name="crm" /><br /><br />
                <input type="submit" value="Salvar" />
            </form>        
    </body>
</html>
