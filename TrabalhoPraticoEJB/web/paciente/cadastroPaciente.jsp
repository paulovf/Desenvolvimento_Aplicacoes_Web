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
                    <h3>Cadastro de Paciente:</h3><br /><br />
                    <h5>
                        <h:form id="cadastro" prependId="false">
                            Nome: <h:inputText id="nome" value="#{Paciente.nome}"/>&nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro[0]}" style="color:#ff0000"/><br />
                            Data de Nascimento: <h:inputText id="dataNasc" value="#{Paciente.dataNasc}" onkeypress="return dateMask(this, event);">
                            <f:convertDateTime pattern="dd/mm/yyyy" />
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro[1]}" style="color:#ff0000"/><br />
                            Rua: <h:inputText id="logradouro" value="#{Paciente.logradouro}"/>&nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro[2]}" style="color:#ff0000"/><br />
                            Nº. : <h:inputText id="numero" value="#{Paciente.numero}"/>&nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro[3]}" style="color:#ff0000"/><br />
                            Bairro: <h:inputText id="bairro" value="#{Paciente.bairro}"/>&nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro[4]}" style="color:#ff0000"/><br />
                            Cidade: <h:inputText id="cidade" value="#{Paciente.cidade}"/>&nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro[5]}" style="color:#ff0000"/><br />
                            UF: 
                                <h:selectOneListbox value="#{Paciente.uf}" size="1">
                                    <f:selectItem id="ac" itemLabel="AC" itemValue="ac" />
                                    <f:selectItem id="al" itemLabel="AL" itemValue="al" />
                                    <f:selectItem id="am" itemLabel="AM" itemValue="am" />
                                    <f:selectItem id="ap" itemLabel="AP" itemValue="ap" />
                                    <f:selectItem id="ba" itemLabel="BA" itemValue="ba" />
                                    <f:selectItem id="ce" itemLabel="CE" itemValue="ce" />
                                    <f:selectItem id="df" itemLabel="DF" itemValue="df" />
                                    <f:selectItem id="es" itemLabel="ES" itemValue="es" />
                                    <f:selectItem id="go" itemLabel="GO" itemValue="go" />
                                    <f:selectItem id="ma" itemLabel="MA" itemValue="ma" />
                                    <f:selectItem id="mg" itemLabel="MG" itemValue="mg" />
                                    <f:selectItem id="ms" itemLabel="MS" itemValue="ms" />
                                    <f:selectItem id="mt" itemLabel="MT" itemValue="mt" />
                                    <f:selectItem id="pa" itemLabel="PA" itemValue="pa" />
                                    <f:selectItem id="pb" itemLabel="PB" itemValue="pb" />
                                    <f:selectItem id="pe" itemLabel="PE" itemValue="pe" />
                                    <f:selectItem id="pr" itemLabel="PR" itemValue="pr" />
                                    <f:selectItem id="pi" itemLabel="PI" itemValue="pi" />
                                    <f:selectItem id="rj" itemLabel="RJ" itemValue="rj" />
                                    <f:selectItem id="rn" itemLabel="RN" itemValue="rn" />
                                    <f:selectItem id="ro" itemLabel="RO" itemValue="ro" />
                                    <f:selectItem id="rr" itemLabel="RR" itemValue="rr" />
                                    <f:selectItem id="rs" itemLabel="RS" itemValue="rs" />
                                    <f:selectItem id="sc" itemLabel="SC" itemValue="sc" />
                                    <f:selectItem id="se" itemLabel="SE" itemValue="se" />
                                    <f:selectItem id="sp" itemLabel="SP" itemValue="sp" />
                                    <f:selectItem id="to" itemLabel="TO" itemValue="to" />
                                </h:selectOneListbox><br /><br />
                            <h:commandButton action="#{Paciente.cadastrarPaciente()}" value="Cadastrar"/>
                            &nbsp;&nbsp;
                            <h:outputText value="#{Paciente.mensagemRetornoErro[6]}" style="color:#ff0000"/>
                            <h:outputText value="#{Paciente.mensagemRetornoOK}" style="color:#00CC00"/>
                        </h:form>
                    </h5>
                </f:view>
            </div>            
        </div>
    </body>
</html>
