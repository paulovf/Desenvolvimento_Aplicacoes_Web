<%-- 
    Document   : cadastroExame
    Created on : 23/02/2013, 17:41:10
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
            <h3>Cadastro de Exame:<br /><br />
                <h:form id="cadastro" prependId="false">
                    Nome do Exame: <h:inputText id="nome" value="#{Exame.nome}"/>
                    &nbsp;&nbsp;
                    <h:outputText value="#{Exame.mensagemRetorno}" style="color:#ff0000"/><br />
                    Valor: <h:inputText id="valor" value="#{Exame.valor}"/><br /><br />
                    <h:commandButton action="#{Exame.cadastrarExame}" value="Cadastrar"/>           
                </h:form>
            </h3>
        </f:view>
    </body>
</html>
