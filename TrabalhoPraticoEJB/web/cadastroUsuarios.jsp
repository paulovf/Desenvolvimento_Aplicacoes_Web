<%-- 
    Document   : cadastroMedico
    Created on : 10/02/2013, 14:37:44
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TrabalhoPraticoEJB</title>
    </head>
    <body>
        <f:view>
            <h3>Cadastrar Usuario:<br /><br />
                <h:form id="cadastro" prependId="false">
                    Nome: <h:inputText id="nome" value="#{Usuarios.nome}"/>
                    &nbsp;&nbsp;
                    <h:outputText value="#{Usuarios.mensagemRetorno}" style="color:#ff0000"/><br />
                    Login: <h:inputText id="login" value="#{Usuarios.login}"/><br />                    
                    Senha: <h:inputText id="senha" value="#{Usuarios.senha}"/><br /><br />
                    <h:commandButton action="#{Usuarios.cadastrarUsuarios()}" value="Cadastrar"/>
                </h:form>
            </h3>
        </f:view>
    </body>
</html>
