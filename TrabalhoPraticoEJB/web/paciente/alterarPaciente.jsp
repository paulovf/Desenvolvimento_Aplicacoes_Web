<%-- 
    Document   : alterarPaciente
    Created on : 24/02/2013, 20:36:07
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Pacientes</title>
        <link href="../css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="../style.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <div class="container">
            <f:view>
                <h3>Alterar dados de Paciente:<br /><br />
                    <h:form id="cadastro" prependId="false">
                        Nome: <h:inputText id="nome" value="#{Paciente.nome}"/><br />
                        Data de Nascimento: <h:inputText id="dataNasc" value="#{Paciente.dataNasc}">
                        <f:convertDateTime pattern="dd/mm/yyyy" />
                        </h:inputText><br />
                        Rua: <h:inputText id="logradouro" value="#{Paciente.logradouro}"/><br />
                        Nº. : <h:inputText id="numero" value="#{Paciente.numero}"/><br />
                        Bairro: <h:inputText id="bairro" value="#{Paciente.bairro}"/><br />
                        Cidade: <h:inputText id="cidade" value="#{Paciente.cidade}"/><br />
                        UF: <h:inputText id="uf" value="#{Paciente.uf}"/><br /><br />
                        <h:commandButton action="#{Paciente.alterarPaciente()}" value="Cadastrar"/>
                        &nbsp;&nbsp;
                        <h:outputText value="#{Paciente.mensagemRetornoErro}" style="color:#ff0000"/>
                        <h:outputText value="#{Paciente.mensagemRetornoOK}" style="color:#00CC00"/>
                        <br /><br />
                        <h:commandLink action="listarPaciente.jsp">
                            <img src="../img/voltar.jpg" border="0" width="190" height="33" />
                        </h:commandLink>                        
                    </h:form>
                </h3>
            </f:view>
        </div>
    </body>
</html>
