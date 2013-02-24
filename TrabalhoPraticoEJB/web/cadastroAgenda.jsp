<%-- 
    Document   : cadastroAgenda
    Created on : 23/02/2013, 19:46:32
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
            <h3>Cadastro de Agendas:<br /><br />
                <h:form id="cadastro" prependId="false">
                    Médico: <h:inputText id="idMedico" value="#{AgendaPK.idMedico}"/>
                    &nbsp;&nbsp;
                    <h:outputText value="#{Agenda.mensagemRetorno}" style="color:#ff0000"/><br />
                    Paciente: <h:inputText id="idPaciente" value="#{AgendaPK.idPaciente}"/><br />
                    Exame: <h:inputText id="idExame" value="#{AgendaPK.idExame}"/><br />
                    <%--
                    Data e Hora: <h:inputText id="dataHora" value="#{Agenda.agendaPK.dataHora}">
                            <f:convertDateTime pattern="dd/mm/yyyy" />
                    </h:inputText><br />--%>
                    Resultado: <h:inputText id="resultado" value="#{Agenda.resultado}"/><br />
                    Observação: <h:inputText id="obs" value="#{Agenda.obs}"/><br />
                    <br />
                    <h:commandButton action="#{AgendaPK.cadastrarAgendaPK()}" value="Cadastrar Exame"/>
                </h:form>
            </h3>
        </f:view>
    </body>
</html>
