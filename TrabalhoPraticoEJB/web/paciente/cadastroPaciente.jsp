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
        <title>Cadastrar Pacientes</title>
        <link href="../css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="../style.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <div class="container">
            <div class="nav-collapse navbar-static">
                <ul class="nav nav-tabs">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="../home.jsp">Home</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Paciente</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="cadastroPaciente.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="alterarPaciente.jsp">Alterar</a></li>
                            <li><a tabindex="-1" href="excluirPaciente.jsp">Excluir</a></li>
                            <li><a tabindex="-1" href="listarPaciente.jsp">Listar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Médico</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="../medico/cadastroMedico.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="../medico/alterarMedico.jsp">Alterar</a></li>
                            <li><a tabindex="-1" href="../medico/excluirMedico.jsp">Excluir</a></li>
                            <li><a tabindex="-1" href="../medico/listarMedico.jsp">Listar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Exame</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="../exame/cadastroExame.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="../exame/alterarExame.jsp">Alterar</a></li>
                            <li><a tabindex="-1" href="../exame/excluirExame.jsp">Excluir</a></li>
                            <li><a tabindex="-1" href="../exame/listarExame.jsp">Listar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Agenda</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="../agenda/cadastroAgenda.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="../agenda/alterarAgenda.jsp">Alterar</a></li>
                            <li><a tabindex="-1" href="../agenda/excluirAgenda.jsp">Excluir</a></li>
                            <li><a tabindex="-1" href="../agenda/listarAgenda.jsp">Listar</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="pull-right">
                    <a href="../index.jsp" class="pull-right">
                        <button class="btn btn-small btn-inverse">LogOff</button>
                    </a>
                </div>
            </div>        
            <div class="container">
                <f:view>
                    <h3>Cadastro de Paciente:<br /><br />
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
                            <h:commandButton action="#{Paciente.cadastrarPaciente()}" value="Cadastrar"/>
                            &nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro}" style="color:#ff0000"/>
                            <h:outputText value="#{Paciente.mensagemRetornoOK}" style="color:#00CC00"/>
                        </h:form>
                    </h3>
                </f:view>
            </div>            
        </div>
    </body>
</html>
