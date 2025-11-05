<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Loterie Virtuelle</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #333;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #2c3e50;
            margin-top: 50px;
        }

        form {
            background-color: #ecf0f1;
            display: inline-block;
            padding: 30px 50px;
            margin-top: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        input[type="text"] {
            padding: 8px;
            width: 250px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            padding: 10px 20px;
            margin-top: 15px;
            border-radius: 5px;
            border: none;
            background-color: #3498db;
            color: white;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<h1>Tentez votre chance à cette loterie virtuelle !</h1>

<form action="./hello" method="post">
    Nom : <input type="text" name="nom" placeholder="Votre nom ici" required><br><br>
    <input type="submit" value="Participer">
</form>

</body>
</html>
