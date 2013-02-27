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
        <title>Pesquisar Pacientes</title>
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
                        <a class="dropdown-toggle" data-toggle="dropdown" href="home.jsp">Home</a>
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
                    <h3>Pesquisar Paciente:</h3><br />
                        <h5>
                            <ul>
                                <li><u>Nome:</u> &nbsp;&nbsp;&nbsp;<h:outputText id="nome" value="#{Paciente.nome}" /></li>
                                <li><u>Data de Nascimento:</u> &nbsp;&nbsp;&nbsp;<h:outputText id="dataNasc" value="#{Paciente.dataNasc}" /></li>
                                <li><u>Rua:</u> &nbsp;&nbsp;&nbsp;<h:outputText id="logradouro" value="#{Paciente.logradouro}" /></li>
                                <li><u>Nº. :</u> &nbsp;&nbsp;&nbsp;<h:outputText id="numero" value="#{Paciente.numero}" /></li>
                                <li><u>Bairro:</u> &nbsp;&nbsp;&nbsp;<h:outputText id="bairro" value="#{Paciente.bairro}" /></li>
                                <li><u>Cidade:</u> &nbsp;&nbsp;&nbsp;<h:outputText id="cidade" value="#{Paciente.cidade}" /></li>
                                <li><u>UF:</u> &nbsp;&nbsp;&nbsp;<h:outputText id="uf" value="#{Paciente.uf}" /></li>
                            </ul>
                        </h5>
                        <h:commandButton action="alterarPaciente.jsp" value="Alterar"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton action="#{Paciente.removerPaciente(Paciente.idPaciente)}" value="Excluir"/>
                        <h:outputText value="#{Paciente.mensagemRetornoErro}" style="color:#ff0000"/>
                        <h:outputText value="#{Paciente.mensagemRetornoOK}" style="color:#00CC00"/>
                        <br /><br />
                        <h:commandLink action="pesquisarPaciente.jsp">
                            <img src="../img/voltar.jpg" border="0" width="190" height="33" />
                        </h:commandLink>                         
                    </h:form>
                </f:view>
            </div>            
        </div>
    </body>
</html>