<%@ page isELIgnored="false" language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/font-awesome.css">

	<style>
		input::-webkit-input-placeholder {
			color: white;
		}

		input::-moz-placeholder {
			/* Mozilla Firefox 19+ */
			color: white;
		}

		input:-moz-placeholder {
			/* Mozilla Firefox 4 to 18 */
			color: white;
		}

		input:-ms-input-placeholder {
			/* Internet Explorer 10-11 */
			color: white;
		}

		body {
			background: url("../img/12345.jpg") center;
			background-size: 120% auto;
			background-repeat: no-repeat;
		}

		#login-box {
			width: 30%;
			height: auto;
			margin: 0 auto;
			margin-top: 15%;
			text-align: center;
			background: #00000080;
			padding: 20px 50px;
		}

		#login-box h1 {
			color: white;

		}

		#login-box .form .item {
			margin-top: 15px;
		}

		#login-box .form .item input {
			width: 180px;
			font-size: 18px;
			border: 0;
			border-bottom: 3px solid white;
			padding: 5px 10px;
			background: #ffffff00;
			color: #ffffff;
		}

		#login-box .form .item input[placeholder] {
			color: white;
		}

		#login-box .form .item i {
			font-size: 18px;
			color: white;
		}

		#login-box button {
			border: 0;
			margin-top: 15px;
			width: 125px;
			height: 30px;
			font-size: 20px;
			font-weight: 700;
			color: white;
			background-image: linear-gradient(to right, #00dbde 0%, #fc00ff 100%);
			border-radius: 15px;
		}

		#message-box {
			color: white;
			position: fixed;
			bottom: 0px;
			width: 100%;
			text-align: center;
		}
	</style>
</head>

<body>
	hola
</body>

<footer>
	<div id="message-box">Hello, I'm JiadeChen!</div>
</footer>

</html>