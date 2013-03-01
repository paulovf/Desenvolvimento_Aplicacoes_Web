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
        <title>Cadastrar Agenda</title>
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
                    <h3>Cadastro de Agendas:</h3><br /><br />
                    <h5>
                        <h:form id="cadastro" prependId="false">
                            Médico: <h:selectOneMenu value="#{Agenda.idMedico}" id="medico">
                                <f:selectItems value="#{Medico.medicoBeans}" var="med" itemLabel="#{med.nome}" itemValue="#{med.idMedico}"/>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText value="#{Agenda.mensagemRetornoErro[0]}" style="color:#ff0000"/><br />
                            Paciente: <h:selectOneMenu value="#{Agenda.idPaciente}" id="paciente">
                                <f:selectItems value="#{Paciente.pacienteBeans}" var="pac" itemLabel="#{pac.nome}" itemValue="#{pac.idPaciente}"/>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText value="#{Agenda.mensagemRetornoErro[1]}" style="color:#ff0000"/><br />                            
                            Exame: <h:selectOneMenu value="#{Agenda.idExame}" id="exame">
                                <f:selectItems value="#{Exame.exameBeans}" var="ex" itemLabel="#{ex.nome}" itemValue="#{es.idExame}"/>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:outputText value="#{Agenda.mensagemRetornoErro[2]}" style="color:#ff0000"/><br />
                            Data e Hora: <h:inputText id="dataHora" value="#{Agenda.dataHora}">
                                     <f:convertDateTime pattern="dd/MM/yyyy HH:mm"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="#{Agenda.mensagemRetornoErro[3]}" style="color:#ff0000"/><br />
                            Resultado: <h:inputText id="resultado" value="#{Agenda.resultado}"/>&nbsp;&nbsp;
                            <h:outputText value="#{Agenda.mensagemRetornoErro[4]}" style="color:#ff0000"/><br />
                            Observação: <h:inputText id="obs" value="#{Agenda.obs}"/><br /><br />
                            <h:commandButton action="#{Agenda.cadastrarAgenda()}" value="Cadastrar Agenda"/>
                            &nbsp;&nbsp;
                            <h:outputText value="#{Agenda.mensagemRetornoErro[5]}" style="color:#ff0000"/>
                            <h:outputText value="#{Agenda.mensagemRetornoOK}" style="color:#00CC00"/>                            
                        </h:form>
                    </h5>
                </f:view>
            </div>            
        </div>
    </body>
</html>
