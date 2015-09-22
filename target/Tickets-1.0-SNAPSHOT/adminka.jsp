<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Документ без названия</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" type="text/css" href="reset.css">
    <script type='text/javascript' src='script.js'></script>
    <script type='text/javascript' src='javascript.js'></script>
</head>

<body>
<div class="menu">
    <ul>
        <li><a href="Index.html">Главная</a></li>
        <li><a href="Reservations.html">Бронирование</a></li>
        <li><a href="Info.html">Информация</a></li>
        <li><a href="Contacts.html">Связь</a></li>
    </ul>
</div>
<div class="main">
    <br>

    <div id="logo">
        <center><img src="img/logo.png" width="180" height="174"></center>
    </div>
    <div class="step">

    </div>
    <div id='adminBar'>
        <button onclick='changeAdminPanel(this.id)' id='bus'>Добавить автобус</button>
        <button onclick='changeAdminPanel(this.id)' id='city'>Добавить город</button>
        <button onclick='changeAdminPanel(this.id)' id='station'>Добавить вокзал</button>
        <button onclick='changeAdminPanel(this.id)' id='route'>Добавить маршрут</button>
        <button onclick='changeAdminPanel(this.id)' id='trip'>Добавить рейс</button>
        <button onclick='changeAdminPanel(this.id)' id='config'>Конфигурация</button>
        <button onclick='changeAdminPanel(this.id)' id='seats'>Управление местами</button>
    </div>
    <div id='adminContent'>

    </div>
    <div id="result">
        </div>
    <div id="result_bus">
    </div>

</div>
</body>
<div id='new_bus' class='adminAdd'>
    <input type='text' placeholder="Автобус" id="bus_name">
    <input type='text' placeholder='Количество мест' id="places"><br>
    <br>
    <input type='submit' value='Добавить' onClick='sendAdminPanel(this.id)' id='add_bus'>
</div>
<div id='new_city' class='adminAdd'>

    <input type='text' placeholder='Город' id="city_name">

    <input type='submit' value='Добавить' id='add_city' onClick='sendAdminPanel(this.id)'>
</div>
<div id='new_station' class='adminAdd'>

    <input type='text' placeholder='Название вокзала' id="station_name">
    <input type='text' placeholder='Город' id="station_city" oninput="doCompletion(this.id);" list="cities">
    <datalist id="cities">
    </datalist>

    <input type='submit' value='Добавить' id='add_station' onClick='sendAdminPanel(this.id)'>
</div>
<div id='new_route' class='adminAdd'>

    <%--@declare id="stations"--%>
    <input type='text' placeholder='Откуда город' id="route_from" oninput="doCompletion(this.id);" list="cities">
    <input type='text' placeholder='Куда город' id="route_to" oninput="doCompletion(this.id);" list="cities">
    <input type='text' placeholder='Откуда станция' id="route_from_station" onfocus="doCompletionStations(this.id);" list="stations">
    <input type='text' placeholder='Куда станция' id="route_to_station" onfocus="doCompletionStations(this.id);" list="stations">
        <datalist id="stations">
        </datalist>
    <br>
    <input type='submit' value='Добавить' id='add_route' onclick='sendAdminPanel(this.id)'>
</div>
<div id='new_trip' class='adminAdd'>
    <%--@declare id="buses"--%><input type='text' placeholder='Откуда город' id="route_from_city" oninput="doCompletion(this.id);" list="cities">
    <input type='text' placeholder='Куда город' id="route_to_city" oninput="doCompletion(this.id);" list="cities">
    <input type='text' placeholder='Маршрут' id="trip_route" onfocus="doCompletionRoutes(this.id)" list="routes">
    <datalist id="routes">
    </datalist>
    <input type='date' id="trip_date_from">
    <input type='time' id="trip_time_from">
    <input type='date' id="trip_date_to">
    <input type='time' id="trip_time_to">
    <input type='text' placeholder='Автобус' id="trip_bus" onfocus="doCompletionBuses(this.id)" list="buses">
        <datalist id="buses">
        </datalist>
    <br>
    <input type='submit' value='Добавить' id='add_trip' onClick='sendAdminPanel(this.id)'>
</div>
<div id='new_config' class='adminAdd'>

    <input type='text' placeholder='Автобус' id="config_bus_name" onfocus="doCompletionBuses(this.id)" list="buses">

    <input type='submit' value='Показать' id='add_cnfig' onClick='sendAdminPanel(this.id)'>
</div>
<div id='new_seats' class='adminAdd'>

    <input type='text' placeholder='ID рейса' id="seats_trip_id">

    <input type='submit' value='Показать' id='showbusconfig' onClick='sendAdminPanel(this.id)'>
</div>
</html>