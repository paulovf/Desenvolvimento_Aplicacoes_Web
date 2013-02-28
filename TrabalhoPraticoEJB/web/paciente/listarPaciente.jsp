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
                        <a class="dropdown-toggle" href="../home.jsp">Home</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Paciente</a>
                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="cadastroPaciente.jsp">Cadastro</a></li>
                            <li><a tabindex="-1" href="pesquisarPaciente.jsp">Pesquisar Paciente</a></li>
                            <li><a tabindex="-1" href="listarPaciente.jsp">Listar</a></li>
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
                    <h3>Relação de Paciente:</h3><br /><br />
                        <h5>
                            <h:dataTable id="listaPacientes" 
                                         value="#{Paciente.listarPacientes()}" var="pac"
                                     border="2" width="100%" cellpadding="2" cellspacing="2">
                                <f:facet name="header">
                                    <h:outputText value="Lista de Pacientes"/>
                                </f:facet>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value=""/>
                                    </f:facet>
                                    <h:commandLink action="#{Paciente.removerPaciente(pac.idPaciente)}">
                                        <img src="../img/excluir.png" border="0" width="20" height="20" />
                                    </h:commandLink>
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="ID"/>
                                    </f:facet>                            
                                    <h:outputText value="#{pac.idPaciente}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Nome"/>
                                    </f:facet>
                                    <h:commandLink action="#{Paciente.loadPaciente(pac.nome)}">
                                        <h:outputText value="#{pac.nome}" />
                                    </h:commandLink>
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Data de Nascimento"/>
                                    </f:facet>                            
                                    <h:outputText value="#{pac.dataNasc}">
                                        <f:convertDateTime pattern="dd/mm/yyyy"/>
                                    </h:outputText>
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="rua"/>
                                    </f:facet>                            
                                    <h:outputText value="#{pac.logradouro}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Nº."/>
                                    </f:facet>                            
                                    <h:outputText value="#{pac.numero}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Bairro"/>
                                    </f:facet>                            
                                    <h:outputText value="#{pac.bairro}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="Cidade"/>
                                    </f:facet>                            
                                    <h:outputText value="#{pac.cidade}" />
                                </h:column>
                                <h:column>
                                    <f:facet name="header">
                                        <h:outputText value="UF"/>
                                    </f:facet>                            
                                    <h:outputText value="#{pac.uf}" />
                                </h:column>                            
                            </h:dataTable>
                        </h5>
                        <br /><br />
                        <h:outputText value="#{Paciente.mensagemRetornoErro[6]}" style="color:#ff0000"/>
                        <h:outputText value="#{Paciente.mensagemRetornoOK}" style="color:#00CC00"/>
                    </h:form>
                </f:view>
            </div>            
        </div>
    </body>
</html>