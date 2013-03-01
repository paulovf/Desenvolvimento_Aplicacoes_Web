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
        <title>Gerar Relatório de Consultas</title>
        <link href="../css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="../style.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <script src="../js/jquery.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/mascara.js"></script>
        <div class="container">
            <div class="nav-collapse navbar-static">
                <ul class="nav nav-tabs">
                    <li class="dropdown">
                        <a class="dropdown-toggle" href="../home.jsp">Home</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Paciente</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="../paciente/cadastroPaciente.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="../paciente/pesquisarPaciente.jsp">Pesquisar Paciente</a></li>
                            <li><a tabindex="-1" href="../paciente/listarPaciente.jsp">Listar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Médico</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="../medico/cadastroMedico.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="../medico/pesquisarMedico.jsp">Pesquisar Médico</a></li>
                            <li><a tabindex="-1" href="../medico/listarMedico.jsp">Listar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Exame</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="../exame/cadastroExame.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="../exame/pesquisarExame.jsp">Pesquisar Exame</a></li>
                            <li><a tabindex="-1" href="../exame/listarExame.jsp">Listar</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Agenda</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="cadastroAgenda.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="pesquisarAgenda.jsp">Pesquisar Agenda</a></li>
                            <li><a tabindex="-1" href="listarAgenda.jsp">Listar</a></li>
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
                    <h:form><%--
                        <h3>Relatório de Consultas:</h3><br /><br />
                        <h5>
                            Data e Hora Inicial: <h:inputText id="dataHoraI" value="#{Agenda.}">
                            <f:convertDateTime pattern="dd/MM/yyyy HH:mm"/><br />
                            Data e Hora Final: <h:inputText id="dataHoraF" value="#{Agenda.dFinal}">
                            <f:convertDateTime pattern="dd/MM/yyyy HH:mm"/><br /><br />
                            <h:commandButton action="#{Agenda.obterAgendas(Agenda.dInicial, Agenda.dFinal)}" value="Pesquisar"/>
                            &nbsp;&nbsp;&nbsp;
                        <h:outputText value="#{Paciente.mensagemRetornoErro[6]}" style="color:#ff0000"/>
                        <h:outputText value="#{Paciente.mensagemRetornoOK}" style="color:#00CC00"/>
                        </h5>--%>
                    </h:form>
                </f:view>
            </div>            
        </div>
    </body>
</html>                