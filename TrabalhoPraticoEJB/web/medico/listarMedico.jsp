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
        <title>Listar Médicos</title>
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
                            <li><a tabindex="-1" href="cadastroMedico.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="pesquisarMedico.jsp">Pesquisar Médico</a></li>
                            <li><a tabindex="-1" href="listarMedico.jsp">Listar</a></li>
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
                            <li><a tabindex="-1" href="../agenda/cadastroAgenda.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="../agenda/pesquisarAgenda.jsp">Pesquisar Agenda</a></li>
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
                    <h:form>
                    <h3>Relação de Médicos:</h3><br /><br />
                        <h5>
                            <h:dataTable id="listaMedcios" 
                                         value="#{Medico.listarMedicos()}" var="med"
                                     border="2" width="100%" cellpadding="2" cellspacing="2">
                                <f:facet name="header">
                                    <h:outputText value="Lista de Médicos"/>
                                </f:facet>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value=""/>
                                    </f:facet>
                                    <h:commandLink action="#{Medico.removerMedico(med.idMedico)}">
                                        <img src="../img/excluir.png" border="0" width="20" height="20" />
                                    </h:commandLink>
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="ID"/>
                                    </f:facet>                            
                                    <h:outputText value="#{med.idMedico}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Nome"/>
                                    </f:facet>
                                    <h:commandLink action="#{Medico.loadMedico(med.nome)}">
                                        <h:outputText value="#{med.nome}" />
                                    </h:commandLink>
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="CRM"/>
                                    </f:facet>
                                    <h:outputText value="#{med.crm}" />
                                </h:column>                                        
                            </h:dataTable>
                        </h5>
                        <br /><br />
                        <h:outputText value="#{Medico.mensagemRetornoErro[2]}" style="color:#ff0000"/>
                        <h:outputText value="#{Medico.mensagemRetornoOK}" style="color:#00CC00"/>
                    </h:form>
                </f:view>
            </div>            
        </div>
    </body>
</html>