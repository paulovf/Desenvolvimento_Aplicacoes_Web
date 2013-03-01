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
                    <h:form>
                    <h3>Relatório de Exames:</h3><br /><br />
                        <h5>
                            <h:dataTable id="listaExames" 
                                         value="#{Agenda.listaAgendas()}" var="ag"
                                     border="2" width="100%" cellpadding="2" cellspacing="2">
                                <f:facet name="header">
                                    <h:outputText value="Relatório de Agendas por valor"/>
                                </f:facet>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Data e Hora"/>
                                    </f:facet>
                                    <h:outputText value="#{ag.dataHora}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Médico"/>
                                    </f:facet>                            
                                    <h:outputText value="#{ag.idMedico}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Paciente"/>
                                    </f:facet>
                                    <h:outputText value="#{ag.idPaciente}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Exame"/>
                                    </f:facet>
                                    <h:outputText value="#{ag.idExame}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Valor"/>
                                    </f:facet>
                                    <h:outputText value="#{ag.exameBean.valor}"/>
                                </h:column>
                        
                                <f:facet name="footer">
                                    <h:outputLabel value="Total: #{Agenda.total}"/>
                                </f:facet>                                 
                            </h:dataTable>
                        </h5>
                        <br /><br />
                        <h:outputText value="#{Agenda.mensagemRetornoErro[2]}" style="color:#ff0000"/>
                        <h:outputText value="#{Agenda.mensagemRetornoOK}" style="color:#00CC00"/>
                    </h:form>
                </f:view>
            </div>            
        </div>
    </body>
</html>                
