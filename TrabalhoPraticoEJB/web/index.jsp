<%-- 
    Document   : index
    Created on : 09/02/2013, 19:11:39
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prova 2</title>
    </head>
    <body>
        <f:view>
            <h3>Login do Sistema:<br /><br />
                <h:form id="cadastro" prependId="false">
                    Login: <h:inputText id="login" value="#{Usuarios.login}"/>
                    &nbsp;&nbsp;
                    <h:outputText value="#{Usuarios.mensagemRetorno}" style="color:#ff0000"/><br />
                    Senha: <h:inputText id="senha" value="#{Usuarios.senha}"/><br /><br />
                    <h:commandButton action="#{Usuarios.validarLogin()}" value="Logar"/>
                    &nbsp;&nbsp;
                    <h:commandButton action="#{Usuarios.cadastrarUsuario()}" value="Cadastrar Novo Usuario"/>            
                </h:form>
            </h3>
        </f:view>
    </body>
</html>
