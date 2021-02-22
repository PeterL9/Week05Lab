<%-- 
    Document   : login
    Created on : Feb 21, 2021, 4:35:17 PM
    Author     : 799768
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            Username: <input type="text" name="username"></input>
            Password: <input type="password" name="password"></input>
            <input type="submit" value="Log in"</input>
        </form>
    </body>
</html>
