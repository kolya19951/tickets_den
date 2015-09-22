<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auto-Completion using AJAX</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <script type="text/javascript" src="javascript.js"></script>
</head>
<body onload="init()">
<div class="menu">
    <ul>
        <li><a href="/">Главная</a></li>
        <li><a href="reservation">Бронирование</a></li>
        <li><a href="info">Информация</a></li>
        <li><a href="contacts">Связь</a></li>
    </ul>
</div>
<div class="main">
    <div class="why_bus">
        <div class="bus_text"><p>Почему путешествие на автобусе это удобно?</p>
            <p>Мы вам приведем три примера, после которых вы полностью перейдете на сторону автобусов.</p>
            <p>Во первых комфортные места, хорошие новые автобусы, wifi, кондиционер, вежливый водитель</p>
            опытный, который вам всегде окажет помощь, уютные кресла, телевизор.</p>
            <p>Остановки. Вы сможете выйти размяться, подышать воздухом, пообщаться с соседом по креслу</p>
            <p>А самое главное это быстрая, качественная и удобная поездка. 16 часовые плацкарты это уже в прошлом.</p>
            <p>Путешествовать можно семьей, с коллегами, с супрогом или супрогой, или самому.</p>
            <br>
            <p>Довольный пассажир важнее всего!</p>
        </div>
    </div>
    <div class="step">
        <div id="#triangle" class="step_one" style="background:#1DCCD5;">
            <center><p>1. Выбор рейса, даты</p></center>
        </div>
        <div class="step_two">
            <center><p>2. Бронирование</p></center>
        </div>
        <div class="step_three">
            <center><p>3. Покупка</p></center>
        </div>
    </div>
    <div class="frame">
        <center><%--@declare id="state_list"--%>


            <input type="text" class="input"  list="cities" placeholder="Откуда" required max="64" id="from"
                   oninput="doCompletion(this.id);">

            <datalist id="cities">
            </datalist>
            <input type="text" class="input" placeholder="Куда" required max="64" id="to" oninput="doCompletion(this.id);" list="cities">

            <input type="date" class="input "id="date"><script>document.getElementById('date').valueAsDate = new Date();</script>
            <input type="submit" class="button" value="Поиск" onClick="search_trips()">
        </center>
    </div>

    <table id="complete-table" />
    </td>
    </tr>
    </tbody>
    </table>

    <center>
        <div class="wrapper">
            <div class="table">
                <div class="row_info">
                    <div class="col date">
                        <b>Дата:</b>
                    </div>

                    <div class="col c">
                        <b>Отправление</b>
                    </div>

                    <div class="col date">
                        <b>Дата:</b>
                    </div>

                    <div class="col c">
                        <b>Прибытие</b>
                    </div>


                    <div class="col c">
                        <b>Стоимость</b>
                    </div>
                </div>
            </div>
            <div class="table" id="tripsTable">
            </div>
        </div>
    </center>
</div>
<div class="footer">
    <div class="footer_text">
        <p>Сайт 2015 ©</p>
    </div>
    </div>
    <form action="step2" method="get" style="display: none">
        <input type="text" value="0" id="tripId"name="id">
        <input type="submit" id="sendIdButton">
    </form>
</body>
</html>
