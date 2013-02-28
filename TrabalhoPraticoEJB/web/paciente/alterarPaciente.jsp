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
        
        <script src="../js/mascara.js"></script>
    </head>
    <body>
        <div class="container">
            <f:view>
                <h3>Alterar dados de Paciente:</h3><br /><br />
                <h5>
                        <h:form id="alterar" prependId="false">
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
                            <h:commandButton action="#{Paciente.alterarPaciente()}" value="Cadastrar"/>
                            &nbsp;&nbsp;
                        <h:outputText value="#{Paciente.mensagemRetornoErro[6]}" style="color:#ff0000"/>
                        <h:outputText value="#{Paciente.mensagemRetornoOK}" style="color:#00CC00"/>
                        <br /><br />
                        <h:commandLink action="listarPaciente.jsp">
                            <img src="../img/voltar.jpg" border="0" width="190" height="33" />
                        </h:commandLink>                        
                    </h:form>
                </h5>
            </f:view>
        </div>
    </body>
</html>
