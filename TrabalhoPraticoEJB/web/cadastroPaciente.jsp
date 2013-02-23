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
            <h3>Cadastro de Paciente:<br /><br />
                <h:form id="cadastro" prependId="false">
                    Nome: <h:inputText id="nome" value="#{Paciente.nome}"/>
                    &nbsp;&nbsp;
                    <h:outputText value="#{Paciente.mensagemRetorno}" style="color:#ff0000"/><br />
                        Data de Nascimento: <h:inputText id="dataNasc" value="#{Paciente.dataNasc}">
                    <f:convertDateTime pattern="dd/mm/yyyy" />
                    </h:inputText><br />
                    Rua: <h:inputText id="logradouro" value="#{Paciente.logradouro}"/><br />
                    Nº. : <h:inputText id="numero" value="#{Paciente.numero}"/><br />
                    Bairro: <h:inputText id="bairro" value="#{Paciente.bairro}"/><br />
                    Cidade: <h:inputText id="cidade" value="#{Paciente.cidade}"/><br />
                    UF: <h:inputText id="uf" value="#{Paciente.uf}"/><br /><br />
                    <h:commandButton action="#{Paciente.cadastrarPaciente()}" value="Cadastrar"/>
                </h:form>
            </h3>
        </f:view>
    </body>
</html>
