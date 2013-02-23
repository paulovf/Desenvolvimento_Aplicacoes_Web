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
            <h3>Cadastro de Médico:<br /><br />
                <h:form id="cadastro" prependId="false">
                    Nome: <h:inputText id="nome" value="#{Medico.nome}"/>
                    &nbsp;&nbsp;
                    <h:outputText value="#{Medico.mensagemRetorno}" style="color:#ff0000"/><br />
                    CRM: <h:inputText id="crm" value="#{Medico.crm}"/><br /><br />
                    <h:commandButton action="#{Medico.cadastrarMedico()}" value="Cadastrar"/>
                </h:form>
            </h3>
        </f:view> 
    </body>
</html>
