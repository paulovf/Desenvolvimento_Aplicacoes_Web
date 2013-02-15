<%-- 
    Document   : cadastroMedico
    Created on : 10/02/2013, 14:37:44
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Paciente" class="br.java.tp.bean.PacienteBean" scope="session" />
<jsp:setProperty name="Paciente" property="nome"/>
<jsp:setProperty name="Paciente" property="dataNasc"/>
<jsp:setProperty name="Paciente" property="logradouro"/>
<jsp:setProperty name="Paciente" property="numero"/>
<jsp:setProperty name="Paciente" property="bairro"/>
<jsp:setProperty name="Paciente" property="cidade"/>
<jsp:setProperty name="Paciente" property="uf"/>

<%
    String nome = request.getParameter("nome");
    String dataNasc = request.getParameter("dataNasc");
    String logradouro = request.getParameter("logradouro");
    String numero = request.getParameter("numero");
    String bairro = request.getParameter("bairro");
    String cidade = request.getParameter("cidade");
    String uf = request.getParameter("uf");
    
    
    if(nome != null && dataNasc != null && logradouro != null && numero != null 
            && bairro != null && cidade != null && uf != null){
        System.out.println("1111");
        boolean status = Paciente.cadastrarPaciente();
        System.out.println("2222");
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
            <form action="cadastroPaciente.jsp" method="POST">
                Nome: <input type="text" name="nome" /><br />
                Data Nascimento: <input type="text" name="dataNasc" /><br />
                rua: <input type="text" name="logradouro" /><br />
                número: <input type="text" name="numero" /><br />
                bairro: <input type="text" name="bairro" /><br />
                cidade: <input type="text" name="cidade" /><br />
                UF: <input type="text" name="uf" /><br /><br />
                <input type="submit" value="Salvar" />
            </form>        
    </body>
</html>
