<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.title}</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<img class="wave" src="images/wave.png">
<div class="container">
    <div class="img">
        <img src="images/bg.svg">
    </div>
    <div class="login-content">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <img src="images/avatar.svg">
            <h2 class="title">Welcome tot Real Parking</h2>
            <div class="input-div one">
                <div class="i">
                    <i class="fas fa-user"></i>
                </div>
                <div class="div">
                    <h5>Username</h5>
                    <input type="text" class="input" name="username" id="username">
                </div>
            </div>
            <div class="input-div pass">
                <div class="i">
                    <i class="fas fa-lock"></i>
                </div>
                <div class="div">
                    <h5>Password</h5>
                    <input type="password" class="input" name="password" id="password">
                </div>
            </div>
            <input type="submit" class="btn" value="Login">
        </form>
    </div>
</div>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>