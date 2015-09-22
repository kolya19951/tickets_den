<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.isNew()) {
        session.setAttribute("lang", "en");
    }
    String lang = (String) session.getAttribute("lang");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>Auto-Completion using AJAX</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" type="text/css" href="home.css">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <script type="text/javascript" src="javascript.js"></script>
</head>
<body>
<center><div class="image_table">
    <div class="image_row">
        <div class="bg_one icon">
            <a href="reservation"><b>Buy Tickets</b></a>
        </div>
        <div class="bg_two icon">
            <a href="info"><b>Information</b></a>
        </div>
    </div>
    <div class="image_row">
        <div class="bg_three icon">
            <a href="contacts"><b>Contacts</b></a>
        </div>
        <div class="bg_four icon">
            <a href=""><b>Exit</b></a>
        </div>
    </div>
</div></center>
</body>
</html>
