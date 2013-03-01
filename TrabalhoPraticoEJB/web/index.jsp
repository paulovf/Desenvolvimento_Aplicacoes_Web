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
        <title>Gerenciador de Cadastro de Exames</title>
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="style.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <div class="container-fluid">
        </div>
        <div class="offset6">
                <f:view>
                    <h3>Login no Sistema:<br /><br />
                        <h:form id="cadastro" prependId="false">
                            Login <h:inputText id="nome" value="#{Usuarios.login}" maxlength="60" /><br />
                            Senha <h:inputSecret id="crm" value="#{Usuarios.senha}" maxlength="15" /><br /><br />
                            <h:commandButton action="#{Usuarios.validarLogin()}" value="Login"/>
                            &nbsp;&nbsp;
                            <h:outputText value="#{Usuarios.mensagemRetornoErro}" style="color:#ff0000"/>
                        </h:form>
                    </h3>
                </f:view>
        </div>
    </body>
</html>
