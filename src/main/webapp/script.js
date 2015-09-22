var id;
function sendAdminPanel(ID) {
    id = ID;
    request(id);
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

var url;

function request(action) {
    url = getUrl(action);
    data = getData(action);
    callback = getCallBack(action);
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function getCallBack(action) {
    if (action == "add_bus")
        back = "callbacknew_bus";
    if (action == "add_city")
        back = "city_manager";
    if (action == "add_station")
        back = "station_manager";
    if (action == "add_route")
        back = "route_manager";
    if (action == "add_trip")
        back = "trip_manager";
    if (action == "showbus")
        back = show_bus;
    if (action == "showcity")
        back = show_city;
    if (action == "showstation")
        back = show_station;
    if (action == "showroute")
        back = show_routes;
    if (action == "showtrip")
        back = show_trips;
    return back;
}

function callbackBus() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            document.getElementById(obj).click();
        }
    }
}

function show_bus(action) {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var result = "";
            responseXML = req.responseXML;
            var buses = responseXML.getElementsByTagName("buses")[0];
            if (buses.childNodes.length > 0) {
                result = "<table>";
                for (i = 0; i < buses.childNodes.length; i++) {
                    var bus = buses.childNodes[i];
                    var id = bus.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var name = bus.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                    var seats = bus.getElementsByTagName("seats")[0].childNodes[0].nodeValue;
                    result += "<tr>"
                    result += "<td>" + id + "</td>";
                    result += "<td><input type='text' id='edit_bus_name"+id+"' value='" + name + "'></td>";
                    result += "<td><input type='text' id='edit_bus_seats"+id+"' value='" + seats + "'></td>";
                    result += "<td><button onclick='delete_bus(this.id)' id='" + id + "'>Удалить</button></td>";
                    result += "<td><button onclick='edit_bus(this.id)' id='" + id + "'>Сохранить</button></td>";
                    result += "</tr>";
                }
                result += "</table>";
            }
            document.getElementById("result").innerHTML = result;
        }
    }
}

function show_city(action) {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var result = "";
            responseXML = req.responseXML;
            var cities = responseXML.getElementsByTagName("cities")[0];
            if (cities.childNodes.length > 0) {
                result = "<table>";
                for (i = 0; i < cities.childNodes.length; i++) {
                    var city = cities.childNodes[i];
                    var id = city.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var name = city.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                    result += "<tr>"
                    result += "<td>" + id + "</td>";
                    result += "<td><input type='text' id='edit_city_name"+id+"' value='" + name + "'></td>";
                    result += "<td><button onclick='delete_city(this.id)' id='" + id + "'>Удалить</button></td>";
                    result += "<td><button onclick='edit_city(this.id)' id='" + id + "'>Сохранить</button></td>";
                    result += "</tr>";
                }
                result += "</table>";
            }
            document.getElementById("result").innerHTML = result;
        }
    }
}

function show_station(action) {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var result = "";
            responseXML = req.responseXML;
            var stations = responseXML.getElementsByTagName("stations")[0];
            if (stations.childNodes.length > 0) {
                result = "<table>";
                for (i = 0; i < stations.childNodes.length; i++) {
                    var station = stations.childNodes[i];
                    var id = station.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var name = station.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                    var city_name = station.getElementsByTagName("city_name")[0].childNodes[0].nodeValue;
                    var city_id = station.getElementsByTagName("city_id")[0].childNodes[0].nodeValue;
                    result += "<tr>"
                    result += "<td>" + id + "</td>";
                    result += "<td><input type='text' id='edit_station_name"+id+"' value='" + name + "'></td>";
                    result += "<td><input type='text' id='edit_station_city_name"+id+"' value='" + city_name + "'readonly></td>";
                    result += "<td><input style='display:none' type='text' id='edit_station_city_id"+id+"' value='" + city_id + "'></td>";
                    result += "<td><button onclick='delete_station(this.id)' id='" + id + "'>Удалить</button></td>";
                    result += "<td><button onclick='edit_station(this.id)' id='" + id + "'>Сохранить</button></td>";
                    result += "</tr>";
                }
                result += "</table>";
            }
            document.getElementById("result").innerHTML = result;
        }
    }
}


function show_routes(action) {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var result = "";
            responseXML = req.responseXML;
            var routes = responseXML.getElementsByTagName("routes")[0];
            if (routes.childNodes.length > 0) {
                result = "<table>";
                for (i = 0; i < routes.childNodes.length; i++) {
                    var route = routes.childNodes[i];
                    var id = route.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var from_station_name = route.getElementsByTagName("from_station_name")[0].childNodes[0].nodeValue;
                    var from_station_id = route.getElementsByTagName("from_station_id")[0].childNodes[0].nodeValue;
                    var to_station_name = route.getElementsByTagName("to_station_name")[0].childNodes[0].nodeValue;
                    var to_station_id = route.getElementsByTagName("to_station_id")[0].childNodes[0].nodeValue;
                    var from_city_name = route.getElementsByTagName("from_city_name")[0].childNodes[0].nodeValue;
                    var from_city_id = route.getElementsByTagName("from_city_id")[0].childNodes[0].nodeValue;
                    var to_city_name = route.getElementsByTagName("to_city_name")[0].childNodes[0].nodeValue;
                    var to_city_id = route.getElementsByTagName("to_city_id")[0].childNodes[0].nodeValue;
                    result += "<tr>"
                    result += "<td>" + id + "</td>";
                    result += "<td><input type='text' id='edit_from_station_name"+id+"' value='" + from_station_name + "' readonly></td>";
                    result += "<td><input type='text' id='edit_from_city_name"+id+"' value='" + from_city_name + "' readonly></td>";
                    result += "<td><input type='text' id='edit_to_station_name"+id+"' value='" + to_station_name + "' readonly></td>";
                    result += "<td><input type='text' id='edit_from_city_nsme"+id+"' value='" + to_city_name + "' readonly></td>";
                    result += "<td><button onclick='delete_route(this.id)' id='" + id + "'>Удалить</button></td>";
                    result += "</tr>";
                }
                result += "</table>";
            }
            document.getElementById("result").innerHTML = result;
        }
    }
}

function show_trips(action) {
    if (req.readyState == 4) {
        if (req.status == 200) {
            var result = "";
            responseXML = req.responseXML;
            var trips = responseXML.getElementsByTagName("trips")[0];
            if (trips.childNodes.length > 0) {
                result = "<table>";
                for (i = 0; i < trips.childNodes.length; i++) {
                    var trip = trips.childNodes[i];
                    var id = trip.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var bus_name = trip.getElementsByTagName("bus_name")[0].childNodes[0].nodeValue;
                    var bus_id = trip.getElementsByTagName("bus_id")[0].childNodes[0].nodeValue;
                    var departure_date = trip.getElementsByTagName("departure_date")[0].childNodes[0].nodeValue;
                    var departure_time = trip.getElementsByTagName("departure_time")[0].childNodes[0].nodeValue;
                    var arrival_date = trip.getElementsByTagName("arrival_date")[0].childNodes[0].nodeValue;
                    var arrival_time = trip.getElementsByTagName("arrival_time")[0].childNodes[0].nodeValue;
                    var route_id = trip.getElementsByTagName("route_id")[0].childNodes[0].nodeValue;
                    var from_station_name = trip.getElementsByTagName("from_station_name")[0].childNodes[0].nodeValue;
                    var from_station_id = trip.getElementsByTagName("from_station_id")[0].childNodes[0].nodeValue;
                    var to_station_name = trip.getElementsByTagName("to_station_name")[0].childNodes[0].nodeValue;
                    var to_station_id = trip.getElementsByTagName("to_station_id")[0].childNodes[0].nodeValue;
                    var from_city_name = trip.getElementsByTagName("from_city_name")[0].childNodes[0].nodeValue;
                    var from_city_id = trip.getElementsByTagName("from_city_id")[0].childNodes[0].nodeValue;
                    var to_city_name = trip.getElementsByTagName("to_city_name")[0].childNodes[0].nodeValue;
                    var to_city_id = trip.getElementsByTagName("to_city_id")[0].childNodes[0].nodeValue;
                    result += "<tr>"
                    result += "<td>" + id + "&thinsp;&thinsp;&thinsp;</td>";
                    result += "<td><label id='bus_name"+id+"'>" + bus_name + "&thinsp;&thinsp;&thinsp;</label></td>";
                    result += "<td><label id='departure_date"+id+"'>" + departure_date + " " + departure_time + "&thinsp;&thinsp;&thinsp;</label></td>";
                    result += "<td><label id='arrival_date"+id+"'>" + arrival_date + " " + arrival_time + "&thinsp;&thinsp;&thinsp;</label></td>";
                    result += "<td><label id='from_station_name"+id+"'>" + from_station_name + "&thinsp;&thinsp;&thinsp;</label></td>";
                    result += "<td><label id='from_city_name"+id+"'>" + from_city_name + "&thinsp;&thinsp;&thinsp;</label></td>";
                    result += "<td><label id='to_station_name"+id+"'>" + to_station_name + "&thinsp;&thinsp;&thinsp;</label></td>";
                    result += "<td><label id='to_city_name"+id+"'>" + to_city_name + "&thinsp;&thinsp;&thinsp;</label></td>";

                    result += "<td><button onclick='delete_trip(this.id)' id='" + id + "'>Удалить</button></td>";
                    result += "</tr>";
                }
                result += "</table>";
            }
            document.getElementById("result").innerHTML = result;
        }
    }
}


function getUrl(action) {
    if (action == "add_bus")
        url = "bus_manager";
    if (action == "add_city")
        url = "city_manager";
    if (action == "add_station")
        url = "station_manager";
    if (action == "add_route")
        url = "route_manager";
    if (action == "add_trip")
        url = "trip_manager";
    if (action == "showbus")
        url = "show_bus";
    if (action == "showcity")
        url = "show_city";
    if (action == "showstation")
        url = "show_station";
    if (action == "showroute")
        url = "show_route";
    if (action == "showtrip")
        url = "show_trips";
    if (action == "showbusconfig")
        url = "show_bus_config";
    return url;
}

function getData(action) {
    data = "";
    if (action == "add_bus") {
        bus_name = document.getElementById("bus_name").value;
        places = document.getElementById("places").value;
        data = "bus_name=" + bus_name + "&places=" + places + "&action=add";
    }
    if (action == "add_city") {
        data = "name=" + document.getElementById("city_name").value + "&action=add";
    }
    if (action == "add_station") {
        station = document.getElementById("station_name").value;
        station_city = document.getElementById("station_city").accept;
        data = "name=" + station + "&station_city=" + station_city + "&action=add";
    }
    if (action == "add_route") {
        route_from = document.getElementById("route_from_station").accept;
        route_to = document.getElementById("route_to_station").accept;
        data = "from=" + route_from + "&to=" + route_to + "&action=add";
    }
    if (action == "add_trip") {
        trip_route = document.getElementById("trip_route").accept;
        trip_date_from = document.getElementById("trip_date_from").value;
        trip_time_from = document.getElementById("trip_time_from").value;
        trip_date_to = document.getElementById("trip_date_to").value;
        trip_time_to = document.getElementById("trip_time_to").value;
        trip_bus = document.getElementById("trip_bus").accept;
        data = "route=" + trip_route + "&departure_date=" + trip_date_from + "&departure_time=" + trip_time_from + "&arrival_date=" + trip_date_to + "&arrival_time=" + trip_time_to + "&bus=" + trip_bus + "&action=add";
    }

    return data;
}

var obj;

function changeAdminPanel(object) {
    obj = object;
    document.getElementById("adminContent").innerHTML = document.getElementById("new_" + object).innerHTML;
    request("show" + object)
}

function delete_bus(id){
    alert("Are you sure?");
    url = "bus_manager";
    data = "action=delete&id=" + id;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function edit_bus(id){
    name = document.getElementById("edit_bus_name" + id).value;
    seats = document.getElementById("edit_bus_seats" + id).value;
    url = "bus_manager";
    data = "action=edit&id=" + id + "&name=" + name + "&seats=" + seats;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function delete_city(id){
    alert("Are you sure?");
    url = "city_manager";
    data = "action=delete&id=" + id;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function delete_station(id){
    alert("Are you sure?");
    url = "station_manager";
    data = "action=delete&id=" + id;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function edit_city(id){
    name = document.getElementById("edit_city_name" + id).value;
    url = "city_manager";
    data = "action=edit&id=" + id + "&name=" + name;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function edit_station(id){
    name = document.getElementById("edit_station_name" + id).value;
    city = document.getElementById("edit_station_city_id" + id).value;
    url = "station_manager";
    data = "action=edit&id=" + id + "&name=" + name + "&city=" + city;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function delete_route(id){
    alert("Are you sure?");
    url = "route_manager";
    data = "action=delete&id=" + id;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function delete_trip(id){
    alert("Are you sure?");
    url = "trip_manager";
    data = "action=delete&id=" + id;
    req = initRequest();
    req.open("POST", url, true);
    req.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    req.onreadystatechange = callback;
    req.send(data);
}

function show_station_autocomplete() {
    document.getElementById("stations").innerHTML = "";
    if (req.readyState == 4) {
        if (req.status == 200) {
            responseXML = req.responseXML;
            var stations = responseXML.getElementsByTagName("stations")[0];
            if (stations.childNodes.length > 0) {
                for (i = 0; i < stations.childNodes.length; i++) {
                    var station = stations.childNodes[i];
                    var id = station.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var name = station.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                    appendStations(name, id);
                }
            }
        }
    }
}

function show_routes_autocomplete() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            responseXML = req.responseXML;
            var routes = responseXML.getElementsByTagName("routes")[0];
            if (routes.childNodes.length > 0) {

                for (i = 0; i < routes.childNodes.length; i++) {
                    var route = routes.childNodes[i];
                    var id = route.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var from_station_name = route.getElementsByTagName("from_station_name")[0].childNodes[0].nodeValue;
                    var to_station_name = route.getElementsByTagName("to_station_name")[0].childNodes[0].nodeValue;
                    appendRoutes(from_station_name, to_station_name, id);
                }
            }
        }
    }
}

function show_buses_autocomplete() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            responseXML = req.responseXML;
            var buses = responseXML.getElementsByTagName("buses")[0];
            if (buses.childNodes.length > 0) {

                for (i = 0; i < buses.childNodes.length; i++) {
                    var bus = buses.childNodes[i];
                    var id = bus.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                    var name = bus.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                    appendBuses(name, id);
                }
            }
        }
    }
}

