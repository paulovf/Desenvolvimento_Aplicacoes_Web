<%-- 
    Document   : index
    Created on : 09/02/2013, 19:11:39
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciador de Cadastro de Exames</title>
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="style.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <div class="container-fluid">
        </div>
        <div class="offset6">
                <h3>Login do Sistema:<br /><br />
                    <form method="POST" action="validarLogin.jsp">
                        Login: <input type="text" name="login" /> <br />
                        Senha: <input type="text" name="senha" /><br /><br />
                        <input type="submit" value="Login" />
                    </form>
                </h3>
        </div>
    </body>
</html>
